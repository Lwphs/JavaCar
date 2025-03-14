package org.JavaCar;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, String motor, int rodes, String etiquetaAmbiental, double capacitatCarga) {
        super(matricula, marca, model, preuBase, new Motor(), new Roda(), etiquetaAmbiental);
        this.capacitatCarga = capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        return 0;
    }
}
