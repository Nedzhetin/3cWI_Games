package at.nejo.test2;

public class Phone extends AbstractProduct {
    private int id;
    private String title;
    private int number;

    public Phone(int id, String title,String description,double price, int number) {
        super(id, title,description,price);
        this.id = id;
        this.title = title;
        this.number = number;
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void call(Phone phone) {
        System.out.println("Calling from " + phone.title + " to number " + phone.number);
    }

}
