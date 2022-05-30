package at.ac.fhcampuswien;

import Enums.*;
import com.google.gson.Gson;
import okhttp3.Connection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;

public class NewsApi {

    private final OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();
    String begUrl = "https://newsapi.org";

    private static final String API_KEY = "dece954c62a847f19648591d3110f141";

    private String getRun(String url) throws IOException{
        Request request = null;
        try {
            request = new Request.Builder()
                    .url(url)
                    .build();

            if (!(url.contains("?"))){
                throw new NewsApiException("URL does not contain -?-.");
            }else if (!(url.contains(API_KEY))){
                throw new NewsApiException("URL does not contain API-key");
            }
        } catch (NewsApiException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code..." + response);
                return Objects.requireNonNull(response.body()).string();
            }

    }


    public String howToUrlTopHeadlines(Endpoint end, Language lang, Category cat, Country cou, SortBy sort, Page page, PageSize size) throws NewsApiException{
            return  begUrl +
                    end.endpoint + "?" +
                    "language=" + lang.language +
                    "&category=" + cat.category +
                    "&country=" + cou.country +
                    "&sortBy=" + sort.sortBy +
                    "&page=" + page.page +
                    "&pageSize=" + size.pageSize +
                    "&apiKey=" + API_KEY;
    }

    public String howToUrlAllNewsBitcoin(Endpoint end, Language lang, Query quer, Page page, PageSize size){
            return begUrl +
                    end.endpoint + "?" +
                    "language=" + lang.language +
                    "&q=" + quer.query +
                    "&page=" + page.page +
                    "&pageSize=" + size.pageSize +
                    "&apiKey=" + API_KEY;
    }



    public List<Article> parseResponse(String url) throws IOException, NewsApiException {
        String gString = getRun(url);
        NewsResponse newsResponse = null;

        try {
            newsResponse = gson.fromJson(gString, NewsResponse.class);
            if (newsResponse.getArticles() == null){
                throw new NewsApiException("Articles is null.");
            }
        }catch (NewsApiException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

        System.out.println("{" +
                "\n" +
                "status:" + newsResponse.getStatus() + "\n" +
                "totalResults:" + newsResponse.getTotalResult() + "\n" +
                "articles:");

        return newsResponse.getArticles();

        /*gString = gson.toJson(newsResponse);
        System.out.println(gString);*/
    }
}
