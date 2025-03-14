package org.JavaCar;
import java.util.List;

public class GestorLloguers {
    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies){
        double total = 0;
        for (Vehicle vehicle : vehicles){
            total =  * dies;
        }
    }

    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        //si cilindrada supera 500cc se li afegeix 5 euros per dia?
        return vehicles;
    }
}
