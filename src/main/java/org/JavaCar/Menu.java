package org.JavaCar;
import org.JavaCar.Usuaris.Administrador;
import org.JavaCar.Usuaris.Client;
import org.JavaCar.Usuaris.Usuari;

import static org.JavaCar.GestorLloguers.llistaVehicles;

public class Menu {

    final static Usuari usuari = new Usuari();
    final static Client client = new Client();
    final static Administrador administrador = new Administrador();

    public static void menuUsuari() {
        int option;
        do {
            usuari.imprimirMenu();
            option = Main.comprovarInput();

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

    public static void submenu(int option) {
        int suboption;
        do {
            selectorMenus(option);
            suboption = Main.comprovarInput();

            switch (suboption) {
                case 1:
                    if (option == 2){
                        llistaVehicles.get(1).setLlogat(true);
                        llistaVehicles.get(6).setLlogat(true);


                        GestorLloguers.alquilarVehicle();
                        System.out.println();
                        System.out.println();
                        GestorLloguers.vehiclesLlogats();
                    }
                    else System.out.println(Main.calculIngresos());
                    break;
                case 2:
                    if (option == 2) GestorLloguers.retornarVehicle();
                    else GestorLloguers.vehiclesLlogats();
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    Main.modificarVehicle();
                    break;
                default:
                    System.out.println("""
                    Si us plau introdueix una de les opcions anteriors.
                    """);
                    break;
            }
        } while (suboption != 3);
    }

    private static void selectorMenus(int option) {
        if (option == 1) administrador.imprimirMenu();
        if (option == 2) client.imprimirMenu();
    }

    public static void menuModificar(Vehicle vehicle) {
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

            suboption = Main.comprovarInput();
            Main.input.nextLine();

            switch (suboption) {
                case 1:
                    System.out.println("Si us plau entra el nom de la Matrícula");
                    String matricula = Main.input.nextLine();
                    vehicle.setMatricula(matricula);
                    break;
                case 2:
                    System.out.println("Si us plau entra el nom de la marca.");
                    vehicle.setMarca(Main.input.nextLine());
                    break;
                case 3:
                    System.out.println("Si us plau entra el nom del model");
                    vehicle.setModel(Main.input.nextLine());
                    break;
                case 4:
                    System.out.println("Si us plau entra un preu base del vehicle.");
                    vehicle.setPreuBase(Main.input.nextInt());
                    Main.input.nextLine();
                    break;
                case 5:
                    System.out.print("Si us plau entra el tipus de motor: ");
                    String tipusMotor = Main.input.nextLine();
                    System.out.print("Entra la potència: ");
                    int potencia = Main.input.nextInt();

                    Motor motor = new Motor(tipusMotor, potencia);
                    vehicle.setMotor(motor);
                    break;
                case 6:
                    System.out.print("Si us plau, entra el tipus de rodes: ");
                    String tipusRodes = Main.input.nextLine();
                    Main.input.next();
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
                    System.out.print("Si us plau, entra l'any de fabricació: ");
                    vehicle.setAnyFabricacio(Main.input.nextInt());
                default:
                    System.out.println("""
                    Si us plau introdueix una de les opcions anteriors!!!!
                    """);
                    break;
            }
        } while (suboption != 8);
        vehicle.calcularEtiqueta();
    }
}
