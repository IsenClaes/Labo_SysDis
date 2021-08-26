package hepl.isen.TvaService.article;

import hepl.isen.TvaService.tva.Tva;

import javax.persistence.*;

@Entity
@Table
public class Article {
    @Id
    @SequenceGenerator(
            name = "article_sequence",
            sequenceName = "article_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "article_sequence"
    )
    private Long id;
    private String nomArticle;
    private double prix;
    private String categorie;
    private int quantiteDispo;

    @ManyToOne
    private Tva tva;

    public Article() {
    }

    public Article(Long id, String nomArticle, double prix, String categorie, int quantiteDispo, Tva tva) {
        this.id = id;
        this.nomArticle = nomArticle;
        this.prix = prix;
        this.categorie = categorie;
        this.quantiteDispo = quantiteDispo;
        this.tva = tva;
    }

    public Article(String nomArticle, double prix, String categorie, int quantiteDispo, Tva tva) {
        this.nomArticle = nomArticle;
        this.prix = prix;
        this.categorie = categorie;
        this.quantiteDispo = quantiteDispo;
        this.tva = tva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getQuantiteDispo() {
        return quantiteDispo;
    }

    public void setQuantiteDispo(int quantiteDispo) {
        this.quantiteDispo = quantiteDispo;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Article==false)
            return false;

        Article tmp= (Article) obj;

        if (tmp.getId()==this.id)
            return true;

        return false;

    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", nomArticle='" + nomArticle + '\'' +
                ", prix=" + prix +
                ", categorie='" + categorie + '\'' +
                ", quantiteDispo=" + quantiteDispo +
                ", tva=" + tva +
                '}';
    }
}
