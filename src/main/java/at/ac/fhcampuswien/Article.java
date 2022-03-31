package at.ac.fhcampuswien;

public class Article {
    private String author;
    private String title;

    public Article(String author, String title){
        setAuthor(author);
        setTitle(title);
        getAuthor();
        getTitle();
    }

    public String getAuthor(){
        return author;
    }

    public String getTitle(){
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
