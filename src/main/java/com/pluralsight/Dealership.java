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

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        //the list that will hold the vehicles that match the color provided
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : this.inventory){
            //we need to ask the vehicle if it matches the color provided
            //if it does, add it to the results
            if(vehicle.getColor().equalsIgnoreCase(color)){
                results.add(vehicle);
            }
        }

        return results;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type){
        //the list that will hold the vehicles that match the color provided
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : this.inventory){
            //we need to ask the vehicle if it matches the color provided
            //if it does, add it to the results
            if(vehicle.getVehicleType().equalsIgnoreCase(type)){
                results.add(vehicle);
            }
        }

        return results;
    }


    //add veichle created in the UI to the list
    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
