package at.ac.fhcampuswien;

import Enums.Category;
import Enums.Country;
import Enums.Language;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class NewsApi {

    private final OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();

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



    public List<Article> parseResponse(String url) throws IOException {
        String gString = getRun(url);


        NewsResponse newsResponse = gson.fromJson(gString, NewsResponse.class);
        return newsResponse.getArticles();
    }


        /*
        gString = gson.toJson(newsResponse);
        System.out.println(gString);

         */


}


