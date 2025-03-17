package org.JavaCar;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;
    protected EtiquetaAmbiental etiquetaAmbiental;

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

    public void setEtiquetaAmbiental(EtiquetaAmbiental etiquetaAmbiental) {
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    private EtiquetaAmbiental calcularEtiqueta() {
        if (anyFabricacio < 2000) return EtiquetaAmbiental.SenseDistintiu;
        if (anyFabricacio > 2000 && anyFabricacio <= 2005) return EtiquetaAmbiental.B;
        if (anyFabricacio > 2005 && anyFabricacio <= 2015) return EtiquetaAmbiental.C;
        if (motor.getTipus().equalsIgnoreCase("Hibrid") || motor.getTipus().equals("Gas")) return EtiquetaAmbiental.ECO;
        if (motor.getTipus().equalsIgnoreCase("Electric") || motor.getTipus().equalsIgnoreCase("Elèctric")) return EtiquetaAmbiental.ZeroEmisions;

        return EtiquetaAmbiental.SenseDistintiu;
    }

    public EtiquetaAmbiental getEtiquetaAmbiental() {
        return etiquetaAmbiental;
    }
}
