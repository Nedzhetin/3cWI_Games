package at.nejo.test2;

public abstract class AbstractProduct {
    private int id;
    private String title;
    private String description;
    private double price;


    public AbstractProduct(int id, String title, String description, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
       return title;
    }

    public String getDescription(){
        return description;
    }

    public double getPrice(){
       return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }





}
