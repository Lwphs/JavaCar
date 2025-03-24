package org.JavaCar;

import java.util.Arrays;

public class Cotxe extends Vehicle{
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes, int anyFabricacio) {
        super(matricula, marca, model, preuBase, motor, rodes, anyFabricacio);
        this.nombrePlaces = nombrePlaces;
    }

    public Cotxe(){}

    /**
     * Calcula el preu del lloguer del cotxe en funció dels dies.
     * No s'aplica cap suplement addicional.
     * @param dies Nombre de dies de lloguer.
     * @return Preu total del lloguer.
     */
    @Override
    public double calcularPreu(int dies) {
        return preuBase * dies;
    }

    @Override
    public String toString() {
        return "Cotxe (llogat: " + llogat + ") --> " +
                "matricula: " + matricula +
                ", marca: " + marca +
                ", model: " + model +
                ", preuBase: " + preuBase +
                ", motor: " + motor +
                ", rodes: " + Arrays.toString(rodes) +
                ", nombre de places: " + nombrePlaces +
                ", etiquetaAmbiental: " + etiquetaAmbiental +
                ", any de Fabricació: " + anyFabricacio;
    }
}