package org.JavaCar;
import org.JavaCar.Usuaris.Administrador;
import org.JavaCar.Usuaris.Client;
import org.JavaCar.Usuaris.Usuari;

public class Menu {
    final static Usuari usuari = new Usuari();
    final static Client client = new Client();
    final static Administrador administrador = new Administrador();

    public static void menuUsuari() {
        int option;
        do {
            usuari.imprimirMenu();
            option = Main.comprovarInput(1, 3);

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
            System.out.print("Selecciona una opció: ");
            suboption = Main.comprovarInput(1, 3);

            switch (suboption) {
                case 1:
                    if (option == 2){
                        Client.alquilarVehicle();
                        System.out.println();
                    }
                    else System.out.println("El total d'ingresos és de " + Main.calculIngresos() + "€.");
                    break;
                case 2:
                    if (option == 2) Client.retornarVehicle();
                    else menuVehicles();
                    break;
                case 3:
                    System.out.println();
                    break;
                default:
                    System.out.println("Si us plau, introdueix una de les opcions anteriors.\n");
                    break;
            }
        } while (suboption != 3);
    }

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
        if (option == 1) administrador.imprimirMenu();
        if (option == 2) client.imprimirMenu();
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
                    Main.input.nextLine();
                    System.out.print("Si us plau, entra el nom de la Matrícula: ");
                    String matricula = Main.input.nextLine();
                    vehicle.setMatricula(matricula);
                    break;
                case 2:
                    Main.input.nextLine();
                    System.out.print("Si us plau, entra el nom de la marca: ");
                    vehicle.setMarca(Main.input.nextLine());
                    break;
                case 3:
                    Main.input.nextLine();
                    System.out.print("Si us plau, entra el nom del model: ");
                    vehicle.setModel(Main.input.nextLine());
                    break;
                case 4:
                    System.out.print("Si us plau, entra un preu base del vehicle: ");
                    vehicle.setPreuBase(Main.input.nextInt());
                    break;
                case 5:
                    System.out.print("Si us plau, entra el tipus de motor: ");
                    String tipusMotor = Main.input.nextLine();
                    System.out.print("Entra la potència: ");
                    int potencia = Main.input.nextInt();

                    vehicle.motor.setPotencia(potencia);
                    vehicle.motor.setTipus(tipusMotor);
                    break;
                case 6:
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
