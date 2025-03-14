package org.JavaCar;

public class Moto extends Vehicle{
    int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, String motor, int rodes, String etiquetaAmbiental, int cilindrada) {
        super(matricula, marca, model, preuBase, motor, rodes, etiquetaAmbiental);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularPreu(int dies) {
        return 0;
    }
}
