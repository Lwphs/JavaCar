package org.JavaCar;

public class LogVehicle {
    private final Vehicle vehicle;
    private final int dies;

    public LogVehicle(Vehicle vehicle, int dies) {
        this.vehicle = vehicle;
        this.dies = dies;
    }

    /**
     * Calcula i mostra la factura per al vehicle llogat, tenint en compte possibles càrrecs addicionals.
     * Si el vehicle és una moto amb més de 500 cilindrades o una furgoneta amb capacitat de càrrega superior a 1000,
     * es cobra un extra.
     * @return El total a pagar pel lloguer del vehicle.
     */
    public double mostrarFactura() {
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
