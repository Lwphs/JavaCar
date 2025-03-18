package org.JavaCar;

import java.util.Arrays;
import java.util.List;

public class Moto extends Vehicle{
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase,int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model,preuBase, motor, rodes);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {

        return cilindrada;
    }

    @Override
    public double calcularPreu(int dies) {
        if (cilindrada > 500)
            return dies * (preuBase + 5);
        else
            return dies * preuBase;
    }

    @Override
    public String toString() {
        return "Moto --> " +
                "matricula: " + matricula + '\'' +
                ", marca: " + marca + '\'' +
                ", model: " + model + '\'' +
                ", preuBase: " + preuBase +
                ", motor: " + motor +
                ", rodes: " + Arrays.toString(rodes) +
                ", etiquetaAmbiental: " + etiquetaAmbiental;
    }
}
