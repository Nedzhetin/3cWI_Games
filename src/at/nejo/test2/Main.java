package at.nejo.test2;

public class Main {
    public static void main(String[] args) {
        GUI1 gui1 = new GUI1();

        Phone phone1 = new Phone(1, "Samsung", "its good", 59.99, 67695048);
        Phone phone2 = new Phone(2, "Manasek", "its good", 59.98, 35347575);

        gui1.addProduct(new Shoe(1, "Sneakers", "Comfortable sneakers", 59.99));
        gui1.addProduct(new Phone(2, "Samsung","its better", 89.99, 40712));
        gui1.addProduct(new Shoe(3, "Nike", "Comfortable Nike", 59.98));
        gui1.addProduct(new Phone(4, "Manasek","way beeter", 110.98, 67605048));

        phone2.call(phone1);

        gui1.start();



    }
}
