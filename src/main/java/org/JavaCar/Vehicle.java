package org.JavaCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void setEtiquetaAmbiental(EtiquetaAmbiental etiquetaAmbiental) {
        this.etiquetaAmbiental = calcularEtiqueta();
    }
    public EtiquetaAmbiental getEtiquetaAmbiental() {
        return etiquetaAmbiental;
    }

    private EtiquetaAmbiental calcularEtiqueta() {
        if (anyFabricacio < 2000) return EtiquetaAmbiental.SenseDistintiu;
        if (anyFabricacio > 2000 && anyFabricacio <= 2005) return EtiquetaAmbiental.B;
        if (anyFabricacio > 2005 && anyFabricacio <= 2015) return EtiquetaAmbiental.C;
        if (motor.getTipus().equalsIgnoreCase("Hibrid") || motor.getTipus().equals("Gas")) return EtiquetaAmbiental.ECO;
        if (motor.getTipus().equalsIgnoreCase("Electric") || motor.getTipus().equalsIgnoreCase("Elèctric")) return EtiquetaAmbiental.ZeroEmisions;

        return EtiquetaAmbiental.SenseDistintiu;
    }

    @Override
    public List<Vehicle> ensenyarLlogable(List<Vehicle> vehicles) {

        List<Vehicle> vehiclesDisponibles = new ArrayList<>();

        for (int i = 0; i < vehicles.size(); i++) {
            if (!isLlogat())
                vehiclesDisponibles.add(vehicles.get(i));
        }
        return vehiclesDisponibles;
    }


    @Override
    public String toString() {
        return "Vehicle --> " +
                "matricula: " + matricula + '\'' +
                ", marca: " + marca + '\'' +
                ", model: " + model + '\'' +
                ", preuBase: " + preuBase +
                ", motor: " + motor +
                ", rodes: " + Arrays.toString(rodes) +
                ", etiquetaAmbiental: " + etiquetaAmbiental;
    }
}
