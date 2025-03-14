package org.JavaCar;

public class Furgoneta extends Vehicle {
    double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, String motor, int rodes, String etiquetaAmbiental, double capacitatCarga) {
        super(matricula, marca, model, preuBase, motor, rodes, etiquetaAmbiental);
        this.capacitatCarga = capacitatCarga;
    }
}
