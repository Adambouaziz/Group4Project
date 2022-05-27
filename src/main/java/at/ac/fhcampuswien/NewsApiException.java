package at.ac.fhcampuswien;

import okhttp3.internal.http2.ErrorCode;

public class NewsApiException extends Exception{

    public NewsApiException(String message, Throwable cause){
        super();
    }

    public NewsApiException(String message){
        super(message);
    }

    public NewsApiException(Throwable cause){
        super(cause);
    }
}
