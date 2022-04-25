package at.ac.fhcampuswien;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsApi {

    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception {
        topHeadLinesAustriaApi();
    }


    public void topHeadLinesAustriaApi() throws Exception {
        Request request = new Request.Builder()
                .url("https://newsapi.org/v2/everything?q=Austria&apiKey=dece954c62a847f19648591d3110f141")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

            System.out.println(response.body().string());
        }
    }
}
