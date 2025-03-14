package org.JavaCar;
import java.util.List;

public class GestorLloguers {
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
}
