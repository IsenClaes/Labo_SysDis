package hepl.isen.MainApp.itemCommande;

import hepl.isen.MainApp.article.Article;
import hepl.isen.MainApp.commande.Commande;

import javax.persistence.*;

@Entity
@Table
public class ItemCommande {
    @Id
    @SequenceGenerator(
            name = "itemcommande_sequence",
            sequenceName = "itemcommande_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "itemcommande_sequence"
    )
    private Long id;

    @ManyToOne
    private Commande commande;
    private int quantite;

    @ManyToOne
    private Article article;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
