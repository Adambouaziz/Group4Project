package at.ac.fhcampuswien;

import Enums.Category;
import Enums.Country;
import Enums.Language;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;

public class NewsApi {

    private final OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();

    String begUrl = "https://newsapi.org/v2";
    String topHeadLinesAustriaUrl = "/top-headlines?";

    private static final String API_KEY = "dece954c62a847f19648591d3110f141";


    public String getRun(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String howToUrlTopHeadlines(Language lang, Category cat, Country cou){
        return begUrl +
                topHeadLinesAustriaUrl +
                "&language=" + lang +
                "&category=" + cat +
                "&country=" + cou +
                "&apiKey=" + API_KEY;
    }

    public List<Article> response(String url) throws Exception {
        String gString = getRun(url);

        NewsResponse newsResponse = gson.fromJson(gString, NewsResponse.class);
        return newsResponse.getArticles();
    }


}
