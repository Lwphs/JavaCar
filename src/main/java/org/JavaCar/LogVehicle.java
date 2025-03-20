package org.JavaCar;

import java.util.ArrayList;

public class LogVehicle {
    public static ArrayList<LogVehicle> logsVehiclesAlquitlats = new ArrayList<>();

    private Vehicle vehicle;
    private int dies;

    public LogVehicle(Vehicle vehicle, int dies) {
        this.vehicle = vehicle;
        this.dies = dies;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double calcularPreu () {
        if (vehicle instanceof Moto) {
            if (((Moto) vehicle).getCilindrada() > 500) {
                System.out.println("Preu base moto: " + vehicle.getPreuBase() + "€, extra: 5€, dies alquilar " + dies + ": total --> " + dies * (vehicle.getPreuBase() + 5) + "€.");
                return dies * (vehicle.getPreuBase() + 5);
            }
            else {
                System.out.println("Preu base moto: " + vehicle.getPreuBase() + "€, dies alquilar " + dies + ": total --> " + dies * (vehicle.getPreuBase()) + "€.");
                return dies * vehicle.getPreuBase();
            }
        } else if (vehicle instanceof Furgoneta) {
            if (((Furgoneta) vehicle).getCapacitatCarga() > 1000) {
                System.out.println("Preu base furgoneta: " + vehicle.getPreuBase() + "€, extra: 10€, dies alquilar " + dies + ": total --> " + dies * (vehicle.getPreuBase() + 10) + "€.");
                return dies * (vehicle.getPreuBase() + 10);
            }
            else {
                System.out.println("Preu base furgoneta: " + vehicle.getPreuBase() + "€, dies alquilar " + dies + ": total --> " + dies * (vehicle.getPreuBase()) + "€.");
                return dies * vehicle.getPreuBase();
            }
        } else {
            System.out.println("Preu base cotxe: " + vehicle.getPreuBase() + "€, dies alquilar " + dies + ": total --> " + dies * (vehicle.getPreuBase()) + "€.");
            return vehicle.getPreuBase() * dies;
        }
    }
}
