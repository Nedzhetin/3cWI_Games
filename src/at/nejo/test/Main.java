package at.nejo.test;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Car", 1);
        AeroCar aeroCar = new AeroCar("AeroCar", 2);
        Train train = new Train("Train", 3);

        CarDealer carDealer = new CarDealer();

        carDealer.addCar(car);
        carDealer.addCar(aeroCar);
        carDealer.addCar(train);

        car.drive();
        aeroCar.drive();
        aeroCar.fly();
        train.drive();


        carDealer.printAllCars();
    }
}
