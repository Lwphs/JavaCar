package org.JavaCar;
import org.JavaCar.Usuaris.Administrador;
import org.JavaCar.Usuaris.Client;
import org.JavaCar.Usuaris.Usuari;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.JavaCar.GestorLloguers.llistaVehicles;
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
                    llistaVehicles.get(1).setLlogat(true);
                    llistaVehicles.get(6).setLlogat(true);


                    GestorLloguers.alquilarVehicle();
                    System.out.println();
                    System.out.println();
                    GestorLloguers.vehiclesLlogats();

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
                case 4:
                    modificarVehicle();
                    break;
                default:
                    System.out.println("""
                    Si us plau introdueix una de les opcions anteriors.
                    """);
                    break;
            }
        } while (suboption != 3);
    }

    private static void modificarVehicle() {
        int i = 0;
        System.out.println("Selecciona el vehicle que vols modificar.");
        for (Vehicle vehicle : llistaVehicles) {
            i++;
            System.out.println(i + " - " + vehicle);
        }
        Vehicle vehicleModificar = llistaVehicles.get(comprovarInput() - 1);

        menuModificar(vehicleModificar);
    }

    private static void menuModificar(Vehicle vehicle) {
        int suboption;

        do {
            System.out.println("""
                Què vols modificar?
                1 - Matrícula
                2 - Marca
                3 - Model
                4 - Preu base
                5 - Motor
                6 - Rodes
                7 - Any de Fabricació
                8 - Enrere""");

            suboption = comprovarInput();
            input.nextLine();

            switch (suboption) {
                case 1:
                    System.out.println("Si us plau entra el nom de la Matrícula");
                    String matricula = input.nextLine();
                    vehicle.setMatricula(matricula);
                    break;
                case 2:
                    System.out.println("Si us plau entra el nom de la marca.");
                    vehicle.setMarca(input.nextLine());
                    break;
                case 3:
                    System.out.println("Si us plau entra el nom del model");
                    vehicle.setModel(input.nextLine());
                    break;
                case 4:
                    System.out.println("Si us plau entra un preu base del vehicle.");
                    vehicle.setPreuBase(input.nextInt());
                    input.nextLine();
                    break;
                case 5:
                    System.out.print("Si us plau entra el tipus de motor: ");
                    String tipusMotor = input.nextLine();
                    System.out.print("Entra la potència: ");
                    int potencia = input.nextInt();

                    Motor motor = new Motor(tipusMotor, potencia);
                    vehicle.setMotor(motor);
                    break;
                case 6:
                    System.out.print("Si us plau, entra el tipus de rodes: ");
                    String tipusRodes = input.nextLine();
                    input.next();
                    System.out.print("Entra el diàmetre: ");
                    double diametreRodes = input.nextDouble();

                    Roda roda = new Roda(tipusRodes, diametreRodes);
                    Roda[] rodes;
                    if (vehicle instanceof Moto)
                        rodes = new Roda[]{roda, roda};
                    else
                        rodes = new Roda[]{roda, roda, roda, roda};
                    vehicle.setRodes(rodes);
                    break;
                case 7:
                    System.out.print("Si us plau, entra l'any de fabricació: ");
                    vehicle.setAnyFabricacio(input.nextInt());
                default:
                    System.out.println("""
                    Si us plau introdueix una de les opcions anteriors!!!!
                    """);
                    break;
            }
        } while (suboption != 8);
        vehicle.calcularEtiqueta();
    }


private static double calculIngresos() {
    System.out.println("Quants dies s'han fet servir els cotxes?");
    int dies = input.nextInt();
    return GestorLloguers.calcularIngressosTotals(llistaVehicles, dies);
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
    } catch (IndexOutOfBoundsException e) {
        System.out.println("Va profe, para de liar-la.");
    }
    return option;
}

    private static void retornarVehicle() {
        System.out.println("Qui vol retornar el vehicle?");
    }

    private static void alquilarVehicle() {
        llistaVehiclesPerAlquilar();
    }

    private static void llistaVehiclesPerAlquilar() {
        System.out.println("Selecciona quin vehicle vols alquilar");
        int i = 0;
        for (Vehicle vehicle : llistaVehicles) {
            if (!vehicle.isLlogat()) {
                i++;
                System.out.println(i + " " + vehicle);
            }
        }
    }

    private static void vehiclesLlogats() {
        int i = 0;
        for (Vehicle vehicle : llistaVehicles) {
            if (vehicle.isLlogat()) {
                i++;
                System.out.println(i + " " + vehicle);
            }
        }
    }
}
