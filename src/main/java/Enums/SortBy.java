package Enums;

public enum SortBy {
    RELEVANCY("relevancy"),
    POPULARITY("popularity"),
    PUBLISHEDAT("publishedAt");

    public final String sortBy;

    SortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
