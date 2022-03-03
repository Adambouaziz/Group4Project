package at.ac.fhcampuswien;

import java.util.List;

public class AppController {
    private List<Article> articles;
    public int count;
    public List<Article> topHeadlinesAustria;
    public List<Article> allNewsBitcoin;

    public AppController(){

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

    protected static List<Article> filterList(String query, List<Article> articles){}

    private static List<Article> generateMockList(){}
}
