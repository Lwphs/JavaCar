package org.JavaCar;
import org.JavaCar.Usuaris.Administrador;
import org.JavaCar.Usuaris.Client;
import org.JavaCar.Usuaris.Usuari;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.JavaCar.GestorLloguers.retornarVehicle;

public class Main {
    final public static Scanner input = new Scanner(System.in);
    final static Usuari usuari = new Usuari();
    final static Client client = new Client();
    final static Administrador administrador = new Administrador();


    public static void main(String[] args) {
        GestorLloguers.creacioVehicles();
        menuUsuari();
    }



    private static void menuUsuari() {
        int option;
        do {
            usuari.imprimirMenu();
            option = comprovarInput();

            switch (option) {
                case 1, 2:
                    submenu(option);
                    break;
                case 3:
                    System.out.println("Sortint . . .");
                    break;
                default:
                    System.out.println("""
                    Si us plau introdueix una de les opcions anteriors.
                    """);
                    break;
            }
        } while (option != 3);
    }

    private static void submenu(int option) {
        int suboption;
        do {
            selectorMenus(option);
            suboption = comprovarInput();

            switch (suboption) {
                case 1:
                    
                    //GestorLloguers.alquilarVehicle();
                    //System.out.println();
                    //System.out.println();
                    //GestorLloguers.vehiclesLlogats();

                    if (option == 2){

                    }
                    else System.out.println(calculIngresos());
                    break;
                case 2:
                    if (option == 2) GestorLloguers.retornarVehicle();
                    else GestorLloguers.vehiclesLlogats();
                    break;
                case 3:
                    System.out.println();
                    break;
                default:
                    System.out.println("""
                    Si us plau introdueix una de les opcions anteriors.
                    """);
                    break;
            }
        } while (suboption != 3);
    }

    private static double calculIngresos() {
        System.out.println("Quants dies s'han fet servir els cotxes?");
        int dies = input.nextInt();
        return GestorLloguers.calcularIngressosTotals(GestorLloguers.llistaVehicles, dies);
    }

    private static void selectorMenus(int option) {
        if (option == 1) administrador.imprimirMenu();
        if (option == 2) client.imprimirMenu();
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