package at.nejo.test2;

public class Phone extends AbstractProduct {
    private int id;
    private String title;
    private int number;

    public Phone(int id, String title, int number) {
        super(id, title, "A phone", 0.0);
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
