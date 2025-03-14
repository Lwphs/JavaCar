package org.JavaCar;

public abstract class Vehicle implements Llogable {
    String matricula;
    String marca;
    String model;
    double preuBase;
    String motor;
    int rodes;
    String etiquetaAmbiental;

    public Vehicle(String matricula, String marca, String model, double preuBase, String motor, int rodes, String etiquetaAmbiental) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.etiquetaAmbiental = etiquetaAmbiental;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public double getPreuBase() {
        return preuBase;
    }

    public String getMotor() {
        return motor;
    }

    public int getRodes() {
        return rodes;
    }

    public String getEtiquetaAmbiental() {
        return etiquetaAmbiental;
    }
}
