package at.nejo.test;

public abstract class AbstractVehicle implements Vehicle {
    private String name;
    private int id;

    public AbstractVehicle(String name, int id){
        this.name = name;
        this.id = id;
    }


    public String getName(){
        return this.name;
    }

    public int getID(){
        return id;
    }



}
