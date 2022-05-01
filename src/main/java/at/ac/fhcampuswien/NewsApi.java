package at.ac.fhcampuswien;

import Enums.*;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NewsApi {

    private final OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();

    String begUrl = "https://newsapi.org";

    private static final String API_KEY = "dece954c62a847f19648591d3110f141";


        public String getRun(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                return response.body().string();
            }
        }


    public String howToUrlTopHeadlines(Endpoint end, Language lang, Category cat, Country cou, SortBy sort, Page page, PageSize size){
        return begUrl +
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

    public List<Article> parseResponse(String url) throws IOException {
        String gString = getRun(url);

        NewsResponse newsResponse = gson.fromJson(gString, NewsResponse.class);

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
