package at.ac.fhcampuswien;

import java.util.List;

public class NewsResponse {

    private String status;
    private int totalResult;
    private List<Article> articles;

    public NewsResponse(){
        setTotalResult(totalResult);
        setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResult() {
        return articles.size();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
       return articles;
    }
}
