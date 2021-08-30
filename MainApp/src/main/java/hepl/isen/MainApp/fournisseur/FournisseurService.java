package hepl.isen.MainApp.fournisseur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FournisseurService {


    public List<Fournisseur> askPriceForArticle(int idArticle) {

        System.err.println("Going throught StockService - askPriceForArticle ");

        List<Fournisseur> fournisseurList = new LinkedList<Fournisseur>();

        boolean dispo;
        for (int i = 0; i < 2; i++) {

            dispo = true;
            int randomWithMathRandom = (int) ((Math.random() * (100 - 1)) + 1);
            if (randomWithMathRandom % 2 == 0)
                dispo = false;

            fournisseurList.add(new Fournisseur("Fournisseur " + i+1, idArticle, randomWithMathRandom, dispo));

        }

        return fournisseurList;

    }

    public void ConfirmationArticle(int idArticle, Fournisseur fournisseur) {

        System.err.println("ConfirmationArticle " + idArticle + " par fournisseur " + fournisseur.getName());

    }

}
