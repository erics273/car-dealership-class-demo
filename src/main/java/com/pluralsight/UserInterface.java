package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    //starts the menu
    public void display(){
        //creates the dealership for this class and makes sure the UI has access
        //to the data (inventory of the dealership)
        this.init();

        //create a scanner to handly the menu choices from the user
        Scanner theScanner = new Scanner(System.in);

        //lets create a variable that can turn on and off the menu
        boolean menuRunning = true;

        // do your menu loopy stuff with the switch
        while (menuRunning){
            // Show menu options
            System.out.println("\n=== Car Dealership Menu ===");
            System.out.println("1 - Find vehicles by price");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List all vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter option: ");

            //handle the menu selection from user and run the appropriate
            //method that handles the related business logic

            //placeholder for the option so we can do some validation
            //before just taking the users actual option
            int option;
            if(theScanner.hasNextInt()){
                //if i got an interget form the user
                //now I will take their answr
                option = theScanner.nextInt();
                //eat the next line to be safe
                theScanner.nextLine();
            }else{
                //discard the invalid input by eating the line
                theScanner.nextLine();

                //make sure we set the option to one that will probaly
                //nerver exist
                option = -1;
            }

            //hande the user input with a switch statement
            switch (option){
                case 4:
                    this.processGetVehiclesByColorRequest();
                    break;
                case 6:
                    this.processGetVehiclesByTypeRequest();
                    break;
                case 7:
                    this.processGetAllVehiclesRequest();
                    break;
                case 99:
                    menuRunning = false;
                    System.out.println();
                    System.out.println("Have a great day!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Option");
            }


        }
    }

    private void init(){
        //lets create an instance of the DealerShipFileManager
        //because it job is to read the csv and create the dealerhip and populate
        //its inventory
        DealershipFileManager fileManager = new DealershipFileManager();

        //call the get dealership method and store the returned Dealership
        //in the UI so that the UI can interact with it and its invetory
        this.dealership = fileManager.getDealership();
    }

    public void processGetAllVehiclesRequest(){
        //holds the list of vehicles requested from the dealershpp
        ArrayList<Vehicle> allTheCars = dealership.getAllVehicles();
        //give the list to the thing that diplays it
        this.displayVehicles(allTheCars);

        //one-liner
        //this.displayVehicles(dealership.getAllVehicles());
    }

    public void processGetVehiclesByColorRequest(){
        //ask the user the color they want with the a scanner
        Scanner theScanner = new Scanner(System.in);
        System.out.println("What color do you want?");

        //store the answer so we can use it to pass to the dealerhip method
        String color = theScanner.nextLine();
        //holds the list of vehicles requested from the dealershpp
        ArrayList<Vehicle> matchingColorCars = dealership.getVehiclesByColor(color);
        //give the list to the thing that diplays it
        this.displayVehicles(matchingColorCars);

        //one-liner
        //this.displayVehicles(dealership.getAllVehicles());
    }

    public void processGetVehiclesByTypeRequest(){
        //ask the user the color they want with the a scanner
        Scanner theScanner = new Scanner(System.in);
        System.out.println("What type of vehicle do you want?");

        //store the answer so we can use it to pass to the dealerhip method
        String type = theScanner.nextLine();
        //holds the list of vehicles requested from the dealershpp
        ArrayList<Vehicle> matches = dealership.getVehiclesByType(type);
        //give the list to the thing that diplays it
        this.displayVehicles(matches);

        //one-liner
        //this.displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        //ask the user the fir the vehicle info

        //create the vehicle instance with that info

        //call the dealership.addVehcile method and pass it the vehicle created

        //create an instance of the file manager
        DealershipFileManager dfm = new DealershipFileManager();
        //call the filemangers .saveDealership and pass it the dealehip from this class
        dfm.saveDealership(dealership);
    }


    private void displayVehicles(ArrayList<Vehicle> vehicles){
        System.out.println();
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.toString());
        }
    }


}
