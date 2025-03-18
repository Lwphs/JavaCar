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

    public static void modificarVehicle() {
        int i = 0;
        Vehicle vehicleModificar;

        System.out.println("Selecciona el vehicle que vols modificar.");
        for (Vehicle vehicle : llistaVehicles) {
            i++;
            System.out.println(i + " - " + vehicle);
        }
        try {
            vehicleModificar = llistaVehicles.get(comprovarInput() - 1);
            Menu.menuModificar(vehicleModificar);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Va jefe, para de liar-la.\n");
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

    private static void retornarVehicle() {
        System.out.println("Qui vol retornar el vehicle?");
    }
}
