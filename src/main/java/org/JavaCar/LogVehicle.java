package org.JavaCar;

public class LogVehicle {

    Vehicle vehicle;
    int dies;

    public LogVehicle(Vehicle vehicle, int dies) {
        this.vehicle = vehicle;
        this.dies = dies;
    }

    public double calcularPreu () {
        if (vehicle instanceof Moto) {
            if (((Moto) vehicle).getCilindrada() > 500)
                return dies * (vehicle.getPreuBase() + 5);
            else
                return dies * vehicle.getPreuBase();
        } else if (vehicle instanceof Furgoneta) {
            if (((Furgoneta) vehicle).getCapacitatCarga() > 1000) return dies * (vehicle.getPreuBase() + 10);
            else return dies * vehicle.getPreuBase();
        } else
            return vehicle.getPreuBase() * dies;

    }

}
