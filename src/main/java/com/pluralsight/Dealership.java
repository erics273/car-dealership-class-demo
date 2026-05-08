package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        this.inventory = new ArrayList<Vehicle>();
    }

    //methods for the most part will get called from the UI

    //filter inventory list by price and return that list
    public ArrayList<Vehicle> getVehiclesByPrice(){
        return null;
    }

    //return the entire list
    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    //add veichle created in the UI to the list
    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }
}
