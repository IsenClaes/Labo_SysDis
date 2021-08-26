package hepl.isen.TvaService.tva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tva")
public class TvaController {

    private final TvaService tvaService;

    @Autowired
    public TvaController(TvaService tvaService) {
        this.tvaService = tvaService;
    }

    @GetMapping("{articleId}")
    public double getTvaForArticle(@PathVariable("articleId") Long articleId){
        return tvaService.getTvaForArticle(articleId);
    }
}
