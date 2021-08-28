package hepl.isen.MainApp.services.serviceOrder;

import hepl.isen.MainApp.article.Article;
import hepl.isen.MainApp.commande.Commande;
import hepl.isen.MainApp.commande.CommandeRepository;
import hepl.isen.MainApp.itemCommande.ItemCommande;
import hepl.isen.MainApp.itemCommande.ItemCommandeRepository;
import hepl.isen.MainApp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    ItemCommandeRepository itemCommandeRepository;

    public boolean CreateOrder(List<Article> articles, double montantTotal, User user, HttpServletRequest request) {

        System.err.println("Creating a new Order ");
        Commande commande = new Commande();
        commande.setMontantTotal(montantTotal);
        user.setMontantDispo((int) (user.getMontantDispo()-commande.getMontantTotal()));
        commande.setUser(user);
        commande.setItemCommandCollection(new LinkedList<ItemCommande>());
        commande.setStatut("EN PREPARATION");
        commandeRepository.saveAndFlush(commande);

        for (Article article : articles) {
            ItemCommande itemCommande = new ItemCommande();
            itemCommande.setArticle(article);
            itemCommande.setQuantite(article.getQuantiteDispo());
            itemCommande.setCommande(commande);
            commande.getItemCommandCollection().add(itemCommande);
            itemCommandeRepository.saveAndFlush(itemCommande);

        }

        request.getSession().setAttribute("ListeCommand", user.getListCommandes());

        return true;
    }
}
