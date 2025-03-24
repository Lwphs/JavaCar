package org.JavaCar;

import java.util.Arrays;

public class Moto extends Vehicle{
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase,int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model,preuBase, motor, rodes);
        this.cilindrada = cilindrada;
    }

    public Moto(String matricula, String marca, String model, double preuBase,int cilindrada, Motor motor, Roda[] rodes, int anyFabricacio) {
        super(matricula, marca, model, preuBase, motor, rodes, anyFabricacio);
        this.cilindrada = cilindrada;
    }


    public int getCilindrada() { return cilindrada; }
    public void setCilindrada(int cilindrada) { this.cilindrada = cilindrada; }

    /**
     * Calcula el preu del lloguer de la moto en funció dels dies i la cilindrada.
     * Si la moto té més de 500cc, s'afegeix un suplement de 5€/dia.
     * @param dies Nombre de dies de lloguer.
     * @return Preu total del lloguer.
     */
    @Override
    public double calcularPreu(int dies) {
        if (cilindrada > 500)
            return dies * (preuBase + 5);
        else
            return dies * preuBase;
    }

    @Override
    public String toString() {
        return "Moto (llogat: " + llogat + ") --> " +
                "matricula: " + matricula  +
                ", marca: " + marca +
                ", model: " + model +
                ", preuBase: " + preuBase +
                ", motor: " + motor +
                ", rodes: " + Arrays.toString(rodes) +
                ", etiquetaAmbiental: " + etiquetaAmbiental +
                ", any de Fabricació: " + anyFabricacio;
    }
}
