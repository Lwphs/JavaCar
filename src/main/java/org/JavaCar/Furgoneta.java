package org.JavaCar;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase,  double capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        if (capacitatCarga > 1000)
            return dies * (preuBase + 10);
        else
            return dies * preuBase;
    }

    public double getCapacitatCarga() {
        return capacitatCarga;
    }
}
