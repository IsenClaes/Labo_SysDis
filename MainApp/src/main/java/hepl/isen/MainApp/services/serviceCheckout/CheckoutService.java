package hepl.isen.MainApp.services.serviceCheckout;

import hepl.isen.MainApp.article.Article;
import hepl.isen.MainApp.article.ArticleRepository;
import hepl.isen.MainApp.auth.ApplicationUser;
import hepl.isen.MainApp.services.serviceOrder.OrderService;
import hepl.isen.MainApp.shoppingcart.ShoppingCart;
import hepl.isen.MainApp.user.User;
import hepl.isen.MainApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;

@Service
public class CheckoutService {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OrderService orderService;
    @Autowired
    private ArticleRepository articleRepository;

    private User GetUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ApplicationUser customUser = (ApplicationUser) authentication.getPrincipal();
        long userId = customUser.getId();
        User user = userRepository.findById(userId).get();
        return user;
    }



    public String Checkout(String livraison, Model model, HttpServletRequest httpServletRequest) {

        double tauxTva, total = 0;
        ShoppingCart shoppingCart = (ShoppingCart) httpServletRequest.getSession().getAttribute("ShoppingCart");

        try
        {
            for (Article article : shoppingCart.listArticles)
            {
                tauxTva = restTemplate.getForObject("http://tva-service/tva/" + article.getId(), double.class);
                total += (article.getQuantiteDispo() * article.getPrix()) + ((article.getQuantiteDispo() * article.getPrix() * tauxTva)/100);
            }
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }


        if (livraison.equals("Normal"))
            total += 4;
        else
            total += 9;

        User user = this.GetUser();
        if (user.getMontantDispo() > total)
        {
            String message = "Order complete !";
            model.addAttribute("Error", message);
            orderService.CreateOrder(shoppingCart.listArticles, total, user, httpServletRequest);
        }
        else
        {
            String message = "Transaction refused, not enough money !";
            model.addAttribute("Error", message);
            for (Article article : shoppingCart.listArticles)
            {
                int index = shoppingCart.listArticles.indexOf(article);
                Article article1 = shoppingCart.listArticles.get(index);
                shoppingCart.listArticles.remove(article);
                int quantite = articleRepository.findById(article.getId()).get().getQuantiteDispo();
                quantite += article1.getQuantiteDispo();
                articleRepository.findById(article.getId()).get().setQuantiteDispo(quantite);
                articleRepository.flush();
            }
            httpServletRequest.getSession().setAttribute("ListeArticle", articleRepository.findAll());
        }

        httpServletRequest.getSession().setAttribute("ShoppingCart", new ShoppingCart());

        return "home";
    }
}
