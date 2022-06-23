package at.ac.fhcampuswien.patterns;

import at.ac.fhcampuswien.NewsResponse;
import com.google.gson.Gson;

public class SingletonGson {
    private static Gson instance = null;

    private SingletonGson(){}

    public static Gson getInstance(){
        if (instance == null){
            instance = new Gson();
        }
        return instance;
    }
}