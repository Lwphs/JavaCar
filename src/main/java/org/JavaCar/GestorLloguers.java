package org.JavaCar;
import java.util.ArrayList;
import java.util.List;

public class GestorLloguers {
    public static ArrayList<Vehicle> llistaVehicles = new ArrayList<>();

    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies){
        double total = 0;
        for (Vehicle element : vehicles){
            total += element.calcularPreu(dies);
        } return total;
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

        llistaVehicles.get(1).setLlogat(true);
        llistaVehicles.get(6).setLlogat(true);
    }

    public static void llistaVehiclesPerAlquilar() {
        int i = 0;
        System.out.println("-------Vehicles disponibles------");

        for (Vehicle vehicle : llistaVehicles) {
            i++;
            if (!vehicle.isLlogat()) {
                System.out.println(i + " - " + vehicle);
            }
        } System.out.print("Selecciona quin vehicle vols alquilar: ");
    }

    public static void vehiclesLlogats() {
        int count = 1;

        for (Vehicle vehicle : llistaVehicles) {
            count++;
            if (vehicle.isLlogat()) {
                System.out.println(count + " - " + vehicle);
            }
        }
    }

    public static void mostraVehicles() {
        int i = 0;

        for (Vehicle vehicle : llistaVehicles) {
            i ++;
            System.out.println(i + " - " + vehicle);
        }
        System.out.println();
    }
}


