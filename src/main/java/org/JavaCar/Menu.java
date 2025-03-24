package org.JavaCar;
import org.JavaCar.Usuaris.Administrador;
import org.JavaCar.Usuaris.Client;
import org.JavaCar.Usuaris.Usuari;

import java.util.Arrays;

public class Menu {

    /**
     * Mostra el menú principal de l'usuari i gestiona les opcions seleccionades.
     */
    public static void menuUsuari() {
        int option;
        do {
            Usuari.imprimirMenu(); //Mostra el menú principal de l'usuari.
            option = Main.comprovarInput(1, 3); //Llegeix una opció valida de l'1 al 3 i fa el control d'errors.

            switch (option) {
                case 1, 2:
                    submenu(option); //Crida al mètode per ensenyar el submenú en base a una opció.
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

    /**
     * Mostra el submenú corresponent segons el tipus d'usuari seleccionat.
     * @param option Opció amb la qual el programa sap quin menú ensenyar.
     */
    public static void submenu(int option) {
        int suboption;

        do {
            selectorMenus(option);
            System.out.print("Selecciona una opció: ");
            suboption = Main.comprovarInput(1, 3); //Control d'errors

            switch (suboption) {
                case 1:
                    if (option == 2){
                        Client.alquilarVehicle(); //Crida al mètode per llogar un vehicle
                        System.out.println();
                    }
                    else System.out.println("El total d'ingresos és de " + GestorLloguers.calculIngresos() + "€."); //Crida el mètode per calcular els ingresos totals.
                    break;
                case 2:
                    if (option == 2) Client.retornarVehicle(); //Crida el mètode per retornar un vehicle.
                    else menuVehicles();
                    break;
                case 3:
                    System.out.println(); //Torna al menú principal.
                    break;
                default:
                    System.out.println("Si us plau, introdueix una de les opcions anteriors.\n");
                    break;
            }
        } while (suboption != 3);
    }

    /**
     *
     */
    private static void menuVehicles() {
        int suboption;

        do {
            System.out.println("""
                    \n1 - Mostrar tots els vehicles.
                    2 - Afegir un vehicle.
                    3 - Modificar un vehicle.
                    4 - Descatalogar un vehicle.
                    5 - Enrere.""");
            System.out.print("Selecciona una opció: ");
            suboption = Main.comprovarInput(1, 5);

            switch (suboption) {
                case 1:
                    GestorLloguers.mostraVehicles();
                    break;
                case 2:
                    Administrador.afegirVehicle();
                    break;
                case 3:
                    Administrador.modificarVehicle();
                    break;
                case 4:
                    Administrador.eliminarVehicle();
                    break;
                case 5:
                    System.out.println();
                    break;
                default:
                    System.out.println("Si us plau, introdueix una de les opcions anteriors.\n");
                    break;
            }
        } while (suboption != 5);
    }

    private static void selectorMenus(int option) {
        if (option == 1) Administrador.imprimirMenu();
        if (option == 2) Client.imprimirMenu();
    }

    public static void menuModificar(Vehicle vehicle) {
        int suboption;

        do {
            System.out.println("""
                1 - Matrícula
                2 - Marca
                3 - Model
                4 - Preu base
                5 - Motor
                6 - Rodes
                7 - Any de Fabricació
                8 - Enrere""");

            System.out.print("Què vols modificar? ");
            suboption = Main.comprovarInput(1, 8);

            switch (suboption) {
                case 1:
                    System.out.println("Antiga matrícula: " + vehicle.getMatricula());
                    System.out.print("Si us plau, entra el nom de la Matrícula: ");
                    String matricula = Main.input.nextLine();
                    vehicle.setMatricula(matricula);
                    break;
                case 2:
                    System.out.println("Antiga marca: " + vehicle.getMarca());
                    System.out.print("Si us plau, entra el nom de la marca: ");
                    vehicle.setMarca(Main.input.nextLine());
                    break;
                case 3:
                    System.out.println("Antic model: " + vehicle.getModel());
                    System.out.print("Si us plau, entra el nom del model: ");
                    vehicle.setModel(Main.input.nextLine());
                    break;
                case 4:
                    System.out.println("Antic preu base: " + vehicle.getPreuBase());
                    System.out.print("Si us plau, entra un preu base del vehicle: ");
                    vehicle.setPreuBase(Main.input.nextInt());
                    break;
                case 5:
                    System.out.println("Antic motor: " + vehicle.getMotor());
                    System.out.print("Si us plau, entra el tipus de motor: ");
                    String tipusMotor = Main.input.nextLine();
                    System.out.print("Entra la potència: ");
                    int potencia = Main.input.nextInt();

                    vehicle.motor.setPotencia(potencia);
                    vehicle.motor.setTipus(tipusMotor);
                    break;
                case 6:
                    System.out.println("Antigues rodes: " + Arrays.toString(vehicle.getRodes()));
                    System.out.print("Si us plau, entra el tipus de rodes: ");
                    String tipusRodes = Main.input.nextLine();
                    System.out.print("Entra el diàmetre: ");
                    double diametreRodes = Main.input.nextDouble();

                    Roda roda = new Roda(tipusRodes, diametreRodes);
                    Roda[] rodes;
                    if (vehicle instanceof Moto)
                        rodes = new Roda[]{roda, roda};
                    else
                        rodes = new Roda[]{roda, roda, roda, roda};
                    vehicle.setRodes(rodes);
                    break;
                case 7:
                    System.out.println("Antic any de fabricació: " + vehicle.getAnyFabricacio());
                    System.out.print("Si us plau, entra l'any de fabricació: ");
                    vehicle.setAnyFabricacio(Main.input.nextInt());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("""
                    Si us plau introdueix una de les opcions anteriors!!!!
                    """);
                    break;
            }
            System.out.println("S'han aplicat els canvis.");
            vehicle.setEtiquetaAmbiental();
        } while (suboption != 8);
    }
}
