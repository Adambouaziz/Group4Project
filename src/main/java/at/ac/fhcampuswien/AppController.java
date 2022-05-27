package at.ac.fhcampuswien;

import Enums.*;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppController {
    private List<Article> articles;

    NewsApi newsApi = new NewsApi();

    public static List<Article> allNewsBitcoin = new ArrayList<Article>();

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {return articles;}

    public int getArticleCount(){
        return articles.size();
    }

    public List<Article> getTopHeadlinesAustria(){
        try {
            articles = newsApi.parseResponse(newsApi.howToUrlTopHeadlines(Endpoint.TOPHEADLINES, Language.GERMAN, Category.GENERAL,Country.AUSTRIA, SortBy.PUBLISHEDAT, Page.PAGE, PageSize.PAGESIZE));
        } catch (NewsApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getCause();
        }
        return articles;
    }

    public List<Article> getAllNewsBitcoin(){
        try {
            articles = newsApi.parseResponse(newsApi.howToUrlAllNewsBitcoin(Endpoint.EVERYTHING, Language.GERMAN, Query.BITCOIN, Page.PAGE, PageSize.PAGESIZE));
        } catch (NewsApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getCause();
        }

        return articles;
    }

    protected static List<Article> filterList(String query, List<Article> articles){

        if (articles != null) {
            try {
                Predicate<Article> bitcoin = article -> article.getTitle().toLowerCase().contains(query.toLowerCase());

                allNewsBitcoin = articles.stream().filter(bitcoin)
                        .collect(Collectors.toList());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return allNewsBitcoin;
    }

    /*private static List<Article> generateMockList(){
        Article bitcoinRave = new Article("Steve Smith", "The Bitcoins are raving");
        Article deadCat = new Article("Liliane Haider", "My poor cat, omg...");
        Article floridaMan = new Article("Franz Jospeh", "Florida man burned down house with spaghetti sauce");
        Article transformers = new Article("Shia Lebouf", "Cars are able to speak now...?");
        Article encanto = new Article("Mirabel Madrigal", "I blew out my family's special candle");
        Article cyborgs = new Article("Chris Baker", "Why Cyborgs will endanger our species.");
        Article running = new Article("Ham Middleton", "Is running really healthy?");
        Article doomsday = new Article("Pam Jackson", "Bitcoin doomsday: Why it will fall to 0.");
        Article invest = new Article("Wojak Trapper", "What you should invest all your money in RIGHT NOW!!");
        Article chalamet = new Article("Kitty Kat", "Why is Timothée Chalamet so hot???");
        Article dogs = new Article ("Heute", "Wir suchen die beliebten Hunderassen");
        Article kaliumJod = new Article ("Kleine Zeitung", "Wann man KaliumJod einnehmen sollte");
        Article minister = new Article ("ATV", "Johannes Rauch: Neuer Gesundheitsminister");
        Article boerse = new Article ("Der Standard", " Börsen im freien Fall");
        Article hanf = new Article ("Schaufenster", "Ist Hanf das Bessere Holz?");


        liste = Arrays.asList(bitcoinRave, deadCat, floridaMan, transformers, encanto, cyborgs, running, doomsday, invest, chalamet, dogs, kaliumJod, minister, boerse, hanf);
        return liste;
    }*/
    public String getMostPopuplarSources(){

        String mostTimesSource = null;
        int SourceTimes = 0;
        Map<String, Integer> map = new HashMap<>();

        for (Article a : articles){
            if (map.merge(a.getSourceName(), 1, Integer::sum) > SourceTimes){
                SourceTimes = map.get(a.getSourceName());
                mostTimesSource = a.getSourceName();
            }
        }
        return mostTimesSource;
    }

    public String getLongestAuthorName(){
        Article longest = articles.stream().max(Comparator.comparingInt(Article::getAuthorLength))
                .orElse(null);

        return longest.getAuthor();
    }

    public int getNewYorkTimesArticleCount(){

        List<Article> streamedArticle = articles.stream()
                .filter(article -> article.getSourceName().toLowerCase().contains("newyorktimes"))
                .collect(Collectors.toList());

        return streamedArticle.size();
    }

    public List<Article> getShortHeadlines(){

        return articles.stream().filter(article -> article.getTitle().length() < 15).collect(Collectors.toList());
    }

}
