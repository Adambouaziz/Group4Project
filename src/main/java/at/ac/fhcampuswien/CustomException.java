package at.ac.fhcampuswien;

import okhttp3.internal.http2.ErrorCode;

public class CustomException extends Exception{

    public final ErrorCode code;

    public CustomException(ErrorCode code) {
        this.code = code;
    }

    public CustomException(String message, Throwable cause, ErrorCode code){
        super();
        this.code = code;
    }

    public CustomException(String message, ErrorCode code){
        super(message);
        this.code = code;
    }

    public CustomException(Throwable cause, ErrorCode code){
        super(cause);
        this.code = code;
    }
}
