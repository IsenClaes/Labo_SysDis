package hepl.isen.MainApp.commande;

import hepl.isen.MainApp.itemCommande.ItemCommande;
import hepl.isen.MainApp.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table
public class Commande {
    @Id
    @SequenceGenerator(
            name = "commande_sequence",
            sequenceName = "commande_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "commande_sequence"
    )
    private Long id;
    private double montantTotal;

    @OneToMany(mappedBy = "commande")
    private Collection<ItemCommande> itemCommandCollection;

    @ManyToOne
    private User user;

    private String statut;

    private LocalDate dateCommande = LocalDate.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Collection<ItemCommande> getItemCommandCollection() {
        return itemCommandCollection;
    }

    public void setItemCommandCollection(Collection<ItemCommande> itemCommandCollection) {
        this.itemCommandCollection = itemCommandCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }
}
