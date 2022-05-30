package at.ac.fhcampuswien;

public class Article {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
    private Source source;


    public Article(String author, String title){
        setAuthor(author);
        setTitle(title);
        setDescription(description);
        setUrl(url);
        setUrlToImage(urlToImage);
        setPublishedAt(publishedAt);
        setContent(content);
        setSource(source);
    }

    public Source getSource() {
        return source;
    }

    public String getSourceName() {
        return source.getName();
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getAuthor(){
        return author;
    }

    public int getAuthorLength(){
       try {
           return author.length();
       }
       catch (NullPointerException e){
           e.getMessage();
           System.out.println("Can't give you the characters of the Author when there is no author :(");
           return 0;
       }
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

    public String getDescription() {
        return description;
    }

    public int getDescriptionLength(){
        try {
            return description.length();
        }
        catch (NullPointerException e){
            e.getMessage();
            System.out.println("Description of the Article is null");
            return 0;
        }
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return  "\n" +
                getSource() + "\n" +
                "   title: " + getTitle() + "\n" +
                "   author: " + getAuthor() + "\n" +
                "   description: " + getDescription() + "\n" +
                "   description length: " +getDescriptionLength() + "\n" +
                "   url: " + getUrl() + "\n" +
                "   urlToImage: " + getUrlToImage() + "\n" +
                "   publishedAt: " + getPublishedAt() + "\n" +
                "   content: " + getContent() + "\n" +
                " }" + "\n";
    }
}
