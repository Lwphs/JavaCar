package org.JavaCar;
import java.util.Arrays;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase,  double capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }
    public Furgoneta() {}

    public void setCapacitatCarga(double capacitatCarga) { this.capacitatCarga = capacitatCarga; }
    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        if (capacitatCarga > 1000) return dies * (preuBase + 10);
        else return dies * preuBase;
    }

    @Override
    public String toString() {
        return "Furgoneta --> " +
                "matricula: " + matricula +
                ", marca: " + marca +
                ", model: " + model +
                ", preuBase: " + preuBase +
                ", motor: " + motor +
                ", rodes: " + Arrays.toString(rodes) +
                ", etiquetaAmbiental: " + etiquetaAmbiental +
                ", llogat: " + llogat +
                ", any de Fabricació: " + anyFabricacio;
    }
}