package at.nejo.SemesterTest;

public abstract class AbstractBook {
    int id;
    String title;
    float price;
    String description;

    public AbstractBook(int id, String title, float price, String description) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
    }
    public  int getId() {
        return id;
    }

    public  String getTitle() {
        return title;
    }
    public  float getPrice() {
        return price;
    }

    public  String getDescription() {
        return description;
    }
}
