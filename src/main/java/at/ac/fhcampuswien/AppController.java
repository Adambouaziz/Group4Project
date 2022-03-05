package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AppController {
    private List<Article> articles;
    public int count;
    public List<Article> topHeadlinesAustria;
    public List<Article> allNewsBitcoin;

    public AppController(){
        generateMockList();
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getArticleCount(){
        return count;
    }

    public List<Article> getTopHeadlinesAustria(){
        return topHeadlinesAustria;
    }

    public List<Article> getAllNewsBitcoin(){
        return allNewsBitcoin;
    }

    //protected static List<Article> filterList(String query, List<Article> articles){}

    private static List<Article> generateMockList(){
        Article bitcoinRave = new Article("Steve Smith", "The Bitcoins are raving");
        Article deadCat = new Article("Liliane Haider", "My poor cat, omg...");
        Article floridaMan = new Article("Franz Jospeh", "Florida man burned down house with spaghetti sauce");
        Article transformers = new Article("Shia Lebouf", "Cars are able to speak now...?");
        Article encanto = new Article("Mirabel Madrigal", "I blew out my family's special candle");

        List<Article> liste = Arrays.asList(bitcoinRave, deadCat, floridaMan, transformers, encanto);
        return liste;
    }
}
