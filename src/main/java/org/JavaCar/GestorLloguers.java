package org.JavaCar;
import java.util.ArrayList;
import java.util.List;

public abstract class GestorLloguers {
    public static ArrayList<Vehicle> llistaVehicles = new ArrayList<>();
    public static ArrayList<LogVehicle> logsVehiclesAlquitlats = new ArrayList<>();

    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies){
        double total = 0;
        for (Vehicle element : vehicles){
            total += element.calcularPreu(dies);
        } return total;
    }

    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        ArrayList<Vehicle> vehiclesFiltrats = new ArrayList<>();
        for (Vehicle vehicle : vehicles ){
            if (vehicle.getPreuBase() <= preuMax && !vehicle.isLlogat()){
                vehiclesFiltrats.add(vehicle);
            }
        }
        return vehiclesFiltrats;
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
        int count = 0;

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
    }

    public static double calculIngresos() {
        double ingresos = 0;
        for (LogVehicle vehicle : logsVehiclesAlquitlats) {
            ingresos += vehicle.mostrarFactura();
        }
        return ingresos;
    }
}


