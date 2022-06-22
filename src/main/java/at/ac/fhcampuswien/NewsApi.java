package at.ac.fhcampuswien;

import Enums.*;
import at.ac.fhcampuswien.patterns.SingletonClient;
import at.ac.fhcampuswien.patterns.SingletonGson;
import at.ac.fhcampuswien.patterns.SingletonRequest;
import com.google.gson.Gson;
import okhttp3.Connection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;

public class NewsApi {

    String begUrl = "https://newsapi.org";

    OkHttpClient client = SingletonClient.getInstance();
    Request request = SingletonRequest.getInstance();
    Gson gson = SingletonGson.getInstance();

    private static final String API_KEY = "dece954c62a847f19648591d3110f141";

    private String getRun(String url) throws IOException, NewsApiException {

        if (!(url.contains("?"))){
            throw new NewsApiException("URL does not contain -?-.");
        }else if (!(url.contains(API_KEY))){
            throw new NewsApiException("URL does not contain API-key");
        }

        request = new Request.Builder()
                .url(url)
                .build();

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

        newsResponse = gson.fromJson(gString, NewsResponse.class);

        if (newsResponse.getArticles() == null){
            throw new NewsApiException("Articles is null.");
        }else{
            System.out.println("{" +
                    "\n" +
                    "status:" + newsResponse.getStatus() + "\n" +
                    "totalResults:" + newsResponse.getTotalResult() + "\n" +
                    "articles:");

            if (newsResponse.getStatus().equals("ok")){
                return newsResponse.getArticles();
            }else{
                throw new NewsApiException((this.getClass() + ": http status not ok. Status is: " + newsResponse.getStatus()));
            }
        }
    }
}
