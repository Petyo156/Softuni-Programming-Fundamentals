package _5_VehicleCatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();
        //truck Man red 200
        String command;
        while(true){
            command = scanner.nextLine();
            if(command.equals("End")){
                break;
            }
            String[] commandParts = command.split(" ");
            //Type: {typeOfVehicle} Model: {modelOfVehicle} Color: {colorOfVehicle} Horsepower: {horsepowerOfVehicle}
            String type = commandParts[0];
            String model = commandParts[1];
            String color = commandParts[2];
            int horsepower = Integer.parseInt(commandParts[3]);
            Vehicle vehicle = new Vehicle(type,model,color,horsepower);
            vehicles.add(vehicle);
        }

        int carsHorsepower = 0; int carsCount = 0;
        int trucksHorsepower = 0; int trucksCount = 0;
        while(true){
            command = scanner.nextLine();
            if(command.equals("Close the Catalogue")){
                break;
            }
            for (Vehicle vehicle:vehicles) {
                if (command.equals(vehicle.getModel())){
                    if(vehicle.getType().equalsIgnoreCase("car")){
                        carsHorsepower += vehicle.getHorsepower();
                        carsCount++;
                        System.out.printf("Type: %s%n",vehicle.getType());
                        System.out.printf("Model: %s%n",vehicle.getModel());
                        System.out.printf("Color: %s%n",vehicle.getColor());
                        System.out.printf("Horsepower: %d%n",vehicle.getHorsepower());
                    }
                    else if(vehicle.getType().equalsIgnoreCase("truck")) {
                        trucksHorsepower += vehicle.getHorsepower();
                        trucksCount++;
                        System.out.printf("Type: %s%n",vehicle.getType());
                        System.out.printf("Model: %s%n",vehicle.getModel());
                        System.out.printf("Color: %s%n",vehicle.getColor());
                        System.out.printf("Horsepower: %d%n",vehicle.getHorsepower());
                    }
                }
            }
        }
        if (carsCount==0){carsHorsepower=0;}
        if (trucksCount==0){trucksHorsepower=0;}
        double avgCarHorsepower = (double) carsHorsepower / carsCount;
        double avgTruckHorsepower = (double) trucksHorsepower / trucksCount;
        System.out.printf("Cars have average horsepower of %.2f.%n", avgCarHorsepower);
        System.out.printf("Trucks have average horsepower of %.2f.", avgTruckHorsepower);
    }
}
/*
* package VehicleCatalogue_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            vehicles.add(new Vehicle(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3])));
            input = scanner.nextLine();
        }

        String model = scanner.nextLine();
        double sumCar = 0;
        double sumTruck = 0;
        int countCar = 0;
        int countTruck = 0;
        while (!model.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(model)) {
                    System.out.println(vehicle);

                }
            }
            model = scanner.nextLine();
        }

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals("car")) {
                sumCar += vehicle.getHorsePower();
                countCar++;
            } else if (vehicle.getType().equals("truck")) {
                sumTruck += vehicle.getHorsePower();
                countTruck++;
            }
        }

        double averageCars = sumCar / countCar;
        if(countCar == 0) {averageCars = 0;}
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCars);
        double averageTrucks = sumTruck / countTruck;
        if(countTruck == 0) {averageTrucks = 0;}
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageTrucks);

    }
}*/