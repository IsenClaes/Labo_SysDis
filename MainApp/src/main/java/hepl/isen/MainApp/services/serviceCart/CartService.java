package hepl.isen.MainApp.services.serviceCart;

import hepl.isen.MainApp.article.Article;
import hepl.isen.MainApp.article.ArticleRepository;
import hepl.isen.MainApp.services.serviceStock.StockService;
import hepl.isen.MainApp.shoppingcart.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Service
public class CartService {
    @Autowired
    StockService serviceStockService;
    @Autowired
    ArticleRepository articleRepository;

    public String removeItem(Long idArticle, HttpServletRequest httpServletRequest, Model model)
    {
        ShoppingCart shoppingCart = (ShoppingCart) httpServletRequest.getSession().getAttribute("ShoppingCart");
        Article article = new Article();
        article.setId(idArticle);
        int index = shoppingCart.listArticles.indexOf(article);
        Article article1 = shoppingCart.listArticles.get(index);
        shoppingCart.listArticles.remove(article);
        int quantite = articleRepository.findById(idArticle).get().getQuantiteDispo();
        quantite += article1.getQuantiteDispo();
        articleRepository.findById(idArticle).get().setQuantiteDispo(quantite);
        articleRepository.flush();
        httpServletRequest.getSession().setAttribute("ListeArticle", articleRepository.findAll());
        model.addAttribute("Error", "Item removed from basket");
        return "home";
    }

    public String addItem(Long idArticle, int quantite, HttpServletRequest httpServletRequest, Model model) {
        boolean test = serviceStockService.checkInventory(idArticle, quantite);
        if (!test)
        {
            model.addAttribute("Error", "Item out of stock !");
        }
        else
        {
            model.addAttribute("Error", "Item added to basket");
            ShoppingCart shoppingCart = (ShoppingCart) httpServletRequest.getSession().getAttribute("ShoppingCart");

            Article article = new Article();
            article.setId(idArticle);
            article.setPrix(articleRepository.findById(idArticle).get().getPrix());
            article.setNomArticle(articleRepository.findById(idArticle).get().getNomArticle());
            article.setQuantiteDispo(quantite);

            if (shoppingCart.listArticles.contains(article))
            {
                int i = shoppingCart.listArticles.indexOf(article);
                int quantiteA = shoppingCart.listArticles.get(i).getQuantiteDispo();
                quantiteA += article.getQuantiteDispo();
                shoppingCart.listArticles.get(i).setQuantiteDispo(quantiteA);
            }
            else
            {
                shoppingCart.listArticles.add(article);
            }
            int a = articleRepository.findById(idArticle).get().getQuantiteDispo();
            articleRepository.findById(idArticle).get().setQuantiteDispo(a - quantite);
            articleRepository.flush();

        }
        httpServletRequest.getSession().setAttribute("ListeArticle", articleRepository.findAll());
        return "home";
    }
}
