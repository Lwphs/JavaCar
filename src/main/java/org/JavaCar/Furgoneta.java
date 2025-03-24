package org.JavaCar;
import java.util.Arrays;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase,  double capacitatCarga, Motor motor, Roda[] rodes, int anyFabricacio) {
        super(matricula, marca, model, preuBase, motor, rodes, anyFabricacio);
        this.capacitatCarga = capacitatCarga;
    }

    public Furgoneta(String matricula, String marca, String model, double preuBase,  double capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }

    public void setCapacitatCarga(double capacitatCarga) { this.capacitatCarga = capacitatCarga; }
    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    /**
     * Calcula el preu del lloguer de la furgoneta en funció dels dies.
     * S'aplica un suplement extra depenent de la capacitat de càrrega de la furgoneta.
     * @param dies Nombre de dies de lloguer.
     * @return Preu total del lloguer.
     */
    @Override
    public double calcularPreu(int dies) {
        if (capacitatCarga > 1000) return dies * (preuBase + 10);
        else return dies * preuBase;
    }

    @Override
    public String toString() {
        return "Furgoneta (llogat: " + llogat + ") --> " +
                "matricula: " + matricula +
                ", marca: " + marca +
                ", model: " + model +
                ", preuBase: " + preuBase +
                ", motor: " + motor +
                ", rodes: " + Arrays.toString(rodes) +
                ", etiquetaAmbiental: " + etiquetaAmbiental +
                ", any de Fabricació: " + anyFabricacio;
    }
}