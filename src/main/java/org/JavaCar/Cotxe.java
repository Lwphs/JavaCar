package org.JavaCar;

public class Cotxe extends Vehicle{
    int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, String motor, int rodes, String etiquetaAmbiental, int nombrePlaces) {
        super(matricula, marca, model, preuBase, motor, rodes, etiquetaAmbiental);
        this.nombrePlaces = nombrePlaces;
    }

    @Override
    public double calcularPreu(int dies) {
        return 0;
    }
}
