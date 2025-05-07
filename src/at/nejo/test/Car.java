package at.nejo.test;

public class Car extends AbstractVehicle {
    public Car(String name, int id) {
        super(name, id);
    }


    @Override
    public void drive() {
        System.out.println("Car is driving");
    }
}
