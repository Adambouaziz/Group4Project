package Enums;

public enum Endpoint {
    TOPHEADLINES("/v2/top-headlines"),
    EVERYTHING("/v2/everything");

    public final String endpoint;


    Endpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
