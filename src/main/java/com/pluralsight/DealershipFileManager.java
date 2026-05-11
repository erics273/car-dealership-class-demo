package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DealershipFileManager {

    //variable for the path to the CSV file
    private final String FILE_PATH = "src/main/resources/inventory.csv";

    public Dealership getDealership(){

        //placeholder for our dealership
        Dealership theDealership = null;

        try{
            //lets try some stuff and hope it goes well

            //create the BufferedReader for the csv
            BufferedReader inventoryReader = new BufferedReader(new FileReader(FILE_PATH));

            //grab the first line since it's the dealership info and we need that to create our dealership
            String dealershipInfo = inventoryReader.readLine();

            if(dealershipInfo != null){

                //break apart the dealership info into the individual pieces
                String[] dealershipParts = dealershipInfo.split("\\|");
                String name = dealershipParts[0];
                String address = dealershipParts[1];
                String phone = dealershipParts[2];

                //create an instance of the dealership based on the dealership
                //info in the first line of the CSV
                theDealership = new Dealership(name, address, phone);

            }

            //now lets handle the rest of the CSV which reprents the inventory
            String vehicleInfo;
            while((vehicleInfo = inventoryReader.readLine()) != null){

                //split the line into the separete pieces
                String[] vehicleParts = vehicleInfo.split("\\|");

                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String type = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);
                double price = Double.parseDouble(vehicleParts[7]);

                //create the vehicle
                Vehicle theVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);

                //add the vehicle to the inventory
                theDealership.addVehicle(theVehicle);

            }

            //close the csv
            inventoryReader.close();

        }catch (Exception potato){
            //oh darn! the crap we hoped would go well, didnt't so lets do this instead
            System.out.println("Couldn't parse invetory file " + potato.getMessage());
        }


        //return the created dealership
        return theDealership;
    }

    //stay empty for now but we will revisit later
    // Writes the dealership and its vehicles to the CSV file
    public void saveDealership(Dealership dealership) {
        try {
            // Open the file for writing (overwrites existing file)
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_PATH));

            // Write dealership header info (first line)
            fileWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            fileWriter.newLine();

            // Write one line for each vehicle
            ArrayList<Vehicle> inventory = dealership.getAllVehicles();
            for (Vehicle vehicle : inventory) {
                fileWriter.write(vehicle.toString());
                fileWriter.newLine();
            }

            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error writing dealership file: " + e.getMessage());
        }
    }

}