package com.pluralsight;

import java.util.ArrayList;

public class UserInterface {

    private Dealership dealership;

    //starts the menu
    public void display(){
        //creates the dealership for this class
        this.init();

        /// do your menu loopy stuff with the switch


        //have your switch that calls the methods in the dealship to get the filterd lists


        //imagine they selected getAll
        this.processGetAllVehiclesRequest();
    }

    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager();

        this.dealership = fileManager.getDealership();
    }

    public void processGetAllVehiclesRequest(){
        ArrayList<Vehicle> allTheCars = dealership.getAllVehicles();
        this.displayVehicles(allTheCars);
    }

    private static void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.toString());
        }
    }


}
