package hepl.isen.MainApp.user;

import hepl.isen.MainApp.commande.Commande;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="Utilisateurs")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String userName;
    private String password;
    private String addresse;
    private boolean active;
    private String roles;
    @OneToMany(mappedBy = "user")
    private Collection<Commande> listCommandes;

    private int montantDispo;

    public User() {
    }

    public User(Long id, String userName, String password, String addresse, boolean active, String roles, Collection<Commande> listCommandes, int montantDispo) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.addresse = addresse;
        this.active = active;
        this.roles = roles;
        this.listCommandes = listCommandes;
        this.montantDispo = montantDispo;
    }

    public User(String userName, String password, String addresse, boolean active, String roles, Collection<Commande> listCommandes, int montantDispo) {
        this.userName = userName;
        this.password = password;
        this.addresse = addresse;
        this.active = active;
        this.roles = roles;
        this.listCommandes = listCommandes;
        this.montantDispo = montantDispo;
    }

    public User(String userName, String password, String addresse, boolean active, String roles, int montantDispo) {
        this.userName = userName;
        this.password = password;
        this.addresse = addresse;
        this.active = active;
        this.roles = roles;
        this.montantDispo = montantDispo;
        this.listCommandes = new ArrayList<Commande>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Collection<Commande> getListCommandes() {
        return listCommandes;
    }

    public void setListCommandes(Collection<Commande> listCommandes) {
        this.listCommandes = listCommandes;
    }

    public int getMontantDispo() {
        return montantDispo;
    }

    public void setMontantDispo(int montantDispo) {
        this.montantDispo = montantDispo;
    }
}
