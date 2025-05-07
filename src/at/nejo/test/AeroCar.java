package at.nejo.test;

public class AeroCar extends Car{
    public AeroCar(String name, int id) {
        super(name, id);
    }

    @Override
    public void drive() {
        System.out.println("AeroCar is driving");
    }

    public void fly() {
        System.out.println("AeroCar is flying");
    }
}
