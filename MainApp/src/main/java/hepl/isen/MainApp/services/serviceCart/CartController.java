package hepl.isen.MainApp.services.serviceCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart/removeitem")
    public String removeItem(
            @RequestParam(value = "idArticle", required = false) Long idArticle,
            HttpServletRequest httpServletRequest,
            Model model)
    {
        System.err.println("/cart/removeitem/");
        String msg = cartService.removeItem(idArticle, httpServletRequest, model);
        return msg;
    }

    @GetMapping("/cart/additem")
    public String addItem(
            @RequestParam(value = "idArticle", required = false) Long idArticle,
            @RequestParam(value = "selectNumber", required = false) int quantite,
            HttpServletRequest httpServletRequest,
            Model model)
    {
        System.err.println("/cart/additem");
        String msg = cartService.addItem(idArticle, quantite, httpServletRequest, model);
        return msg;
    }
}
