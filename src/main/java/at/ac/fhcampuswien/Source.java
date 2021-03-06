package at.ac.fhcampuswien;

public class Source {

    private String id;
    private String name;

    NewsResponse newsResponse = new NewsResponse();

    public Source(){
        setId(id);
        setName(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  " {" + "\n" +
                "  Source: {" + "\n" +
                "    id:'" + getId() + "\n" +
                "    name:'" + getName() + "\n" +
                "  }";
    }
}
