package hepl.isen.MainApp.services.serviceCheckout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping("/cart/checkout")
    public String Checkout(
            @RequestParam(value = "optnRadio") String livraison,
            Model model,
            HttpServletRequest httpServletRequest)
    {
        System.err.println("/cart/checkout/");
        String msg = checkoutService.Checkout(livraison, model, httpServletRequest);
        return msg;
    }
}
