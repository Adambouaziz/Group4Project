package at.ac.fhcampuswien;
import Enums.*;
import at.ac.fhcampuswien.downloader.Downloader;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppController {
    private List<Article> articles;

    NewsApi newsApi = new NewsApi();
    NewsApi.Builder builder = new NewsApi.Builder();
    Downloader downloader = new Downloader() {
        @Override
        public int process(List<String> urls) {
            return 0;
        }
    };

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
            articles = newsApi.parseResponse(builder.urlBuilder(Endpoint.TOPHEADLINES,Category.GENERAL, Country.AUSTRIA, Language.GERMAN, Page.PAGE, PageSize.PAGESIZE, SortBy.PUBLISHEDAT));

        } catch (NewsApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getCause();
        }
        return articles;
    }

    public List<Article> getAllNewsBitcoin(){
        try {
            articles = newsApi.parseResponse(builder.urlBuilder(Endpoint.EVERYTHING, Language.GERMAN, Query.BITCOIN, Page.PAGE, PageSize.PAGESIZE));
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

    public List<Article> getDescriptionSorted(){
        List<Article> descriptionSort = null;
        try {
            Comparator<Article> sortByLength = Comparator.comparingInt(Article::getDescriptionLength);
            Comparator<Article> sortByLetter = Comparator.comparing(Article::getDescription);

            Comparator<Article> sortedByLengthOrLetter = sortByLength.thenComparing(sortByLetter);

            descriptionSort = articles.stream().sorted(sortedByLengthOrLetter).collect(Collectors.toList());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return descriptionSort;
    }


    public List<String> getMostCommonSources(){
        Comparator<Map.Entry<String, Long>> reversed = Map.Entry.comparingByValue();
        Comparator<Map.Entry<String, Long>> entryComparator = Collections.reverseOrder(reversed);

        return articles.stream()
                .collect(Collectors.groupingBy(Article::getSourceName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(entryComparator)
                .map(Map.Entry::getKey)
                .limit(2)
                .collect(Collectors.toList());
    }

    public String getLongestAuthorName() {
        try {
            return articles.stream().max(Comparator.comparingInt(Article::getAuthorLength))
                    .orElse(null).getAuthor();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return "Ain't no author here, user!";
        }
    }

    public int getNewYorkTimesArticleCount(){
        List<Article> streamedArticle = null;
        try {
            streamedArticle = articles.stream()
                    .filter(article -> article.getSourceName().toLowerCase().contains("newyorktimes"))
                    .collect(Collectors.toList());
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        return streamedArticle.size();
    }

    public List<Article> getShortHeadlines(){
        List<Article> shawtie = articles.stream()
                .filter(article -> article.getTitle().length() < 15)
                .collect(Collectors.toList());
        if (shawtie.isEmpty()){
            System.out.println("There is no short article under 15 characters");
        }

        return shawtie;
    }

    // Method is needed for exercise 4 - ignore for exercise 2 solution
    // returns number of downloaded article urls
    public int downloadURLs(Downloader downloader) throws NewsApiException {
        List<String> urls = new ArrayList<>();

        //TODO extract urls from articles with java stream

        return downloader.process(urls);
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

}