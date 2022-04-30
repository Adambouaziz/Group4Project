package Enums;

public enum Query {
    BITCOIN("bitcoin"),
    CAT("cat"),
    WIEN("wien"),
    VIENNA("vienna"),
    CORONA("corona");

    public final String query;

    Query(String query) {
        this.query = query;
    }
}
