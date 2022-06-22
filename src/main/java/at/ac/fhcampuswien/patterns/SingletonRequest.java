package at.ac.fhcampuswien.patterns;

import okhttp3.Request;

public class SingletonRequest {

    private static Request instance = null;

    private SingletonRequest(){}

    public static Request getInstance(){
        if (instance == null){
            Request instance;
        }
        return instance;
    }
}
