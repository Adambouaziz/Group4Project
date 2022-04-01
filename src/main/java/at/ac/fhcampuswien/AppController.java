package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppController {
    private List<Article> articles;
    static List<Article> liste;
    public int count = generateMockList().size();

    public static List<Article> allNewsBitcoin = new ArrayList<Article>();

    public AppController(){
        liste = articles;
        generateMockList();
        getAllNewsBitcoin();
        filterList("bitcoin", articles);
        getArticles();
        setArticles(articles);
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        articles = generateMockList();
    }

    public List<Article> getArticles() {return articles;}

    public int getArticleCount(){
        return count;
    }
    public List<Article> getTopHeadlinesAustria(){
            return generateMockList();
    }

    public List<Article> getAllNewsBitcoin(){
        return filterList("bitcoin", articles);
    }

    protected static List<Article> filterList(String query, List<Article> articles){
        articles = liste;

        Predicate<Article> bitcoin = article -> article.getTitle().toLowerCase().contains(query.toLowerCase());

        allNewsBitcoin = articles.stream().filter(bitcoin)
                .collect(Collectors.toList());


        return allNewsBitcoin;
    }

    private static List<Article> generateMockList(){
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
    }
}
