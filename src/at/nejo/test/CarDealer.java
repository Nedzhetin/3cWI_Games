package at.nejo.test;

import java.util.ArrayList;
import java.util.List;

public class CarDealer {
    private List<AbstractVehicle> vehicles = new ArrayList<AbstractVehicle>();

    public void printAllCars() {
        for (AbstractVehicle vehicle : vehicles) {
            System.out.println("Car ID: " + vehicle.getID());
        }
    }

    public void addCar(AbstractVehicle vehicle) {
        vehicles.add(vehicle);
    }


}
