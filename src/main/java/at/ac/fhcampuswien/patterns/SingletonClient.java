package at.ac.fhcampuswien.patterns;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.concurrent.Executor;

public class SingletonClient {

    private static OkHttpClient instance = null;

    private SingletonClient(){}

    public static OkHttpClient getInstance(){
        if (instance == null){
            instance = new OkHttpClient();
        }
        return instance;
    }

    public Executor newCall(Request request) {
        return null;
    }
}