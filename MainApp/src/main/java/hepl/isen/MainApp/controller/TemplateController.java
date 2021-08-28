package hepl.isen.MainApp.controller;

import hepl.isen.MainApp.article.ArticleRepository;
import hepl.isen.MainApp.auth.ApplicationUser;
import hepl.isen.MainApp.shoppingcart.ShoppingCart;
import hepl.isen.MainApp.user.User;
import hepl.isen.MainApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TemplateController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/login")
    public String getLogin() {
        return ("/login");
    }

    @GetMapping("/")
    public String getHome(Model model, HttpServletRequest request) {

        if (request.getSession(false) == null) {
            System.err.println("Création de la session");
            request.getSession().setAttribute("ShoppingCart", new ShoppingCart());
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken)
            System.err.println("Not logged in !");
        else
        {
            System.err.println("Logged in !");
            String name = authentication.getName();
            ApplicationUser customUser = (ApplicationUser) authentication.getPrincipal();
            long userId = customUser.getId();
            name = customUser.getUsername();
            request.getSession().setAttribute("userId", userId);
            request.getSession().setAttribute("name", name);


            User user = userRepository.findById(userId).get();

            request.getSession().setAttribute("ListeCommand", user.getListCommandes());
        }

        request.getSession().setAttribute("ListeArticle", articleRepository.findAll());

        return "home";
    }

}
