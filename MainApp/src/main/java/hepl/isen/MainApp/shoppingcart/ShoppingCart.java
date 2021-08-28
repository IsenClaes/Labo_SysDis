package hepl.isen.MainApp.shoppingcart;

import hepl.isen.MainApp.article.Article;

import java.util.LinkedList;

public class ShoppingCart {

    public LinkedList<Article>listArticles;
    public String user;

    public ShoppingCart() {

        listArticles=new LinkedList<Article>() {
        };
    }
}
