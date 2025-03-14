package org.JavaCar;

public class Moto extends Vehicle{
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, String motor, int rodes, String etiquetaAmbiental, int cilindrada) {
        super(matricula, marca, model, preuBase, new Motor(), new Roda(), etiquetaAmbiental);
        this.cilindrada = cilindrada;
    }


}
