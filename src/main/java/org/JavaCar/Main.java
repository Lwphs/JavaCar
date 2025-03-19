package org.JavaCar;

import java.util.InputMismatchException;
import java.util.Scanner;
import static org.JavaCar.GestorLloguers.llistaVehicles;

public class Main {
    final public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        GestorLloguers.creacioVehicles();
        Menu.menuUsuari();
    }

    public static void alquilarVehicle() {
        int opcio;

        GestorLloguers.llistaVehiclesPerAlquilar();
        System.out.println();
        opcio = Main.comprovarInput();

        if (!llistaVehicles.get(opcio-1).isLlogat()) {
            llistaVehicles.get(opcio-1).setLlogat(true);
            System.out.println("El vehículo ha sido alquilado con éxito.");
        } else {
            System.out.println("El vehículo ya está alquilado.");
        }
    }

    public static void retornarVehicle() {
        int opcio;

        System.out.println("Selecciona quin vehicle vols tornar.");
        GestorLloguers.vehiclesLlogats();

        opcio = Main.comprovarInput();
        if (llistaVehicles.get(opcio-1).isLlogat()){
            llistaVehicles.get(opcio-1).setLlogat(false);
            System.out.println("Has retornat el vehicle correctament");
        }
        else{
            System.out.println("El vehicle no està llogat");
        }
    }

    static double calculIngresos() {
        System.out.println("Quants dies s'han fet servir els cotxes?");
        int dies = input.nextInt();
        return GestorLloguers.calcularIngressosTotals(llistaVehicles, dies);
    }

    public static int comprovarInput() {
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("No has introduit un numero!");
            input.next();
        }
        return option;
    }
}
