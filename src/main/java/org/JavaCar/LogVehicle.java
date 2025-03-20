package org.JavaCar;

import java.util.ArrayList;

public class LogVehicle {
    public static ArrayList<LogVehicle> logsVehiclesAlquitlats = new ArrayList<>();

    private final Vehicle vehicle;
    private final int dies;

    public LogVehicle(Vehicle vehicle, int dies) {
        this.vehicle = vehicle;
        this.dies = dies;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double calcularPreu () {
        double extra = 0;

        if (vehicle instanceof Moto && ((Moto) vehicle).getCilindrada() > 500) {
            extra = 5;
        } else if (vehicle instanceof Furgoneta && ((Furgoneta) vehicle).getCapacitatCarga() > 1000) {
            extra = 10;
        }

        double total = vehicle.calcularPreu(dies);
        System.out.println("Preu base de " + vehicle.getClass().getSimpleName() + ": " + vehicle.getPreuBase() + "€, extra: " + extra + "€, dies alquilar: " + dies + ", total --> " + total + "€.");
        return total;
    }
}
