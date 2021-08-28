package hepl.isen.MainApp.services.serviceStock;

import hepl.isen.MainApp.article.ArticleRepository;
import hepl.isen.MainApp.fournisseur.Fournisseur;
import hepl.isen.MainApp.fournisseur.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StockService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    FournisseurService fournisseurService;

    public boolean checkInventory(Long idArticle, int quantite) {

        System.err.println("Going throught StockService - checkInventory");

        if(articleRepository.findById(idArticle).get().getQuantiteDispo() >= quantite)
        {
            return true;
        }
        else
        {
            List<Fournisseur> fournisseurList = fournisseurService.askPriceForArticle(idArticle.intValue());

            fournisseurList.removeIf(fournisseur -> !fournisseur.isDispo());
            Fournisseur minPriceFournisseur = fournisseurList.stream().min(Comparator.comparing(Fournisseur::getPrice)).orElse(null);

            if (minPriceFournisseur != null) {
                fournisseurService.ConfirmationArticle(idArticle.intValue(), minPriceFournisseur);
                articleRepository.findById(idArticle).get().setQuantiteDispo(quantite);
                return true;
            }
            return false;
        }

    }
}
