package org.JavaCar;

public class Cotxe extends Vehicle{
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, String motor, int rodes, String etiquetaAmbiental, int nombrePlaces) {
        super(matricula, marca, model, preuBase, new Motor(), new Roda(), etiquetaAmbiental);
        this.nombrePlaces = nombrePlaces;
    }

    @Override
    public double calcularPreu(int dies) {
        return 0;
    }
}
