package hepl.isen.MainApp.fournisseur;

public class Fournisseur {

    private String name;
    private int article;
    private int price;
    private boolean dispo;

    public Fournisseur(String name, int article, int price, boolean dispo) {
        this.name = name;
        this.article = article;
        this.price = price;
        this.dispo = dispo;
    }

    public Fournisseur(String name, int article, int price) {
        this.name = name;
        this.article = article;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }
}
