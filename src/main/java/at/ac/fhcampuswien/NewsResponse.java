package at.ac.fhcampuswien;

import java.util.List;

public class NewsResponse {

    private String status;
    private int totalResult;
    private List<Article> articles;

    public NewsResponse(){
        setStatus(status);
        setArticles(articles);
        setTotalResult(totalResult);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
