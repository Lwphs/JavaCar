package org.JavaCar;

import java.util.Arrays;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;
    protected EtiquetaAmbiental etiquetaAmbiental;
    protected boolean llogat = false;

    //etiqueta Ambiental
    protected int anyFabricacio;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes, int anyFabricacio) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.anyFabricacio = anyFabricacio;
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public Vehicle() {}

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void setRodes(Roda[] rodes) {
        this.rodes = rodes;
    }

    public void setAnyFabricacio(int anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
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

    public Motor getMotor() {
        return motor;
    }

    public Roda[] getRodes() {
        return rodes;
    }

    public boolean isLlogat() {
        return llogat;
    }

    public void setLlogat(boolean llogat) {
        this.llogat = llogat;
    }

    public void setEtiquetaAmbiental() {
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public EtiquetaAmbiental calcularEtiqueta() {
        if (anyFabricacio < 2000) return EtiquetaAmbiental.SenseDistintiu;
        if (anyFabricacio > 2000 && anyFabricacio <= 2005) return EtiquetaAmbiental.C;
        if (anyFabricacio > 2005 && anyFabricacio <= 2015) return EtiquetaAmbiental.B;
        if (motor.getTipus().equalsIgnoreCase("Hibrid") || motor.getTipus().equals("Gas") || anyFabricacio > 2015) return EtiquetaAmbiental.ECO;
        if (motor.getTipus().equalsIgnoreCase("Electric") || motor.getTipus().equalsIgnoreCase("Elèctric")) return EtiquetaAmbiental.ZeroEmisions;

        return EtiquetaAmbiental.SenseDistintiu;
    }

    @Override
    public String toString() {
        return "Vehicle (llogat: " + llogat + ") --> " +
                "matricula: " + matricula +
                ", marca: " + marca +
                ", model: " + model  +
                ", preuBase: " + preuBase +
                ", motor: " + motor +
                ", rodes: " + Arrays.toString(rodes) +
                ", etiquetaAmbiental: " + etiquetaAmbiental +
                ", any de Fabricació: " + anyFabricacio;
    }
}
