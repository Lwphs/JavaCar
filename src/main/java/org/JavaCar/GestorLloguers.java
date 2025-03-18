package org.JavaCar;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorLloguers {

    final public static Scanner input = new Scanner(System.in);
    public static ArrayList<Vehicle> llistaVehicles = new ArrayList<>();


    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies){
        double total = 0;
        for (Vehicle element : vehicles){
            total += element.calcularPreu(dies);
        }
        return total;
    }

    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        return vehicles;
    }

    public static void creacioVehicles() {
        Roda[] rodesCotxe = {new Roda("Michelin", 17), new Roda("Michelin", 17), new Roda("Michelin", 17), new Roda("Michelin", 17)};
        Roda[] rodesMoto = {new Roda("Michelin", 17), new Roda("Michelin", 17)};

        Motor motorCotxe = new Motor("Gasolina", 120);
        Motor motorMoto = new Motor("Diesel", 80);

        llistaVehicles.add(new Moto("5678DEF", "Yamaha", "R3", 25, 300, motorCotxe, rodesCotxe));
        llistaVehicles.add(new Cotxe("2222DEF", "Ford", "Focus", 28, 5, motorMoto, rodesMoto));
        llistaVehicles.add(new Moto("5678DEF", "Yamaha", "R3", 25, 300, motorCotxe, rodesCotxe));
        llistaVehicles.add(new Cotxe("2222DEF", "Ford", "Focus", 28, 5, motorMoto, rodesMoto));
        llistaVehicles.add(new Moto("1234ABC", "Honda", "CBR500R", 23, 320, motorMoto, rodesMoto));
        llistaVehicles.add(new Cotxe("3333GHI", "Toyota", "Corolla", 30, 5, motorCotxe, rodesCotxe));
        llistaVehicles.add(new Moto("9999XYZ", "Ducati", "Panigale V2", 27, 280, motorMoto, rodesMoto));
        llistaVehicles.add(new Cotxe("7777JKL", "Volkswagen", "Golf", 26, 5, motorCotxe, rodesCotxe));
        llistaVehicles.add(new Moto("5555MNO", "Kawasaki", "Ninja 650", 24, 290, motorMoto, rodesMoto));

    }

    public static void alquilarVehicle() {
        int opcio;
        llistaVehiclesPerAlquilar();

        opcio = Main.comprovarInput();

        if (!llistaVehicles.get(opcio).isLlogat()) {
            llistaVehicles.get(opcio).setLlogat(true);
            System.out.println("El vehículo ha sido alquilado con éxito.");
        } else {
            System.out.println("El vehículo ya está alquilado.");
        }


    }

    public static void retornarVehicle() {
        int opcio;
        vehiclesLlogats();

        opcio = Main.comprovarInput();
        if (llistaVehicles.get(opcio).isLlogat()){
            llistaVehicles.get(opcio).setLlogat(false);
        }
    }

    public static void llistaVehiclesPerAlquilar() {
        System.out.println("Selecciona quin vehicle vols alquilar");
        int i = 0;
        for (Vehicle vehicle : llistaVehicles) {
            if (!vehicle.isLlogat()) {
                i++;
                System.out.println(i + " " + vehicle);
            }
        }
    }

    public static void vehiclesLlogats() {
        int i = 0;
        for (Vehicle vehicle : llistaVehicles) {
            if (vehicle.isLlogat()) {
                i++;
                System.out.println(i + " " + vehicle);
            }
        }
    }
}


