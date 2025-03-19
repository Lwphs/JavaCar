package org.JavaCar.Usuaris;

import org.JavaCar.*;
import org.JavaCar.Vehicle;

import static org.JavaCar.GestorLloguers.llistaVehicles;

public class Administrador extends Usuari {

    public Administrador() { super(); }
    public static void modificarVehicle() {
        int i = 0;
        Vehicle vehicleModificar;

        System.out.println("Selecciona el vehicle que vols modificar.");
        for (Vehicle vehicle : llistaVehicles) {
            i++;
            System.out.println(i + " - " + vehicle);
        }
        try {
            vehicleModificar = llistaVehicles.get(Main.comprovarInput() - 1);
            Menu.menuModificar(vehicleModificar);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Va jefe, para de liar-la.\n");
        }
    }

    public static void afegirVehicle() {
        Vehicle vehicle = tipusVehicle();
        Main.input.nextLine();

        System.out.println("Si us plau entra el nom de la Matrícula");
        String matricula = Main.input.nextLine();
        vehicle.setMatricula(matricula);

        System.out.println("Si us plau entra el nom de la marca.");
        vehicle.setMarca(Main.input.nextLine());

        System.out.println("Si us plau entra el nom del model");

        vehicle.setModel(Main.input.nextLine());
        System.out.println("Si us plau entra un preu base del vehicle.");
        vehicle.setPreuBase(Main.input.nextInt());
        Main.input.nextLine();

        System.out.print("Si us plau entra el tipus de motor: ");
        String tipusMotor = Main.input.nextLine();
        System.out.print("Entra la potència: ");
        int potencia = Main.input.nextInt();
        Main.input.nextLine();

        Motor motor = new Motor(tipusMotor, potencia);
        vehicle.setMotor(motor);

        System.out.print("Si us plau, entra el tipus de rodes: ");
        String tipusRodes = Main.input.nextLine();

        System.out.print("Entra el diàmetre: ");
        double diametreRodes = Main.input.nextDouble();

        Roda roda = new Roda(tipusRodes, diametreRodes);
        Roda[] rodes;

        if (vehicle instanceof Moto) {
            rodes = new Roda[]{roda, roda};
            System.out.print("Si us plau, entra la cilindrada de la moto: ");
            ((Moto) vehicle).setCilindrada(Main.input.nextInt());
        } else if (vehicle instanceof Furgoneta) {
            rodes = new Roda[]{roda, roda, roda, roda};
            System.out.print("Si us plau, entra la capacitat de càrrega de la furgoneta: ");
            ((Furgoneta) vehicle).setCapacitatCarga(Main.input.nextDouble());
        } else
            rodes = new Roda[]{roda, roda, roda, roda};

        vehicle.setRodes(rodes);

        System.out.print("Si us plau, entra l'any de fabricació: ");
        vehicle.setAnyFabricacio(Main.input.nextInt());

        vehicle.calcularEtiqueta();
        llistaVehicles.add(vehicle);
    }

    private static Vehicle tipusVehicle() {
        Moto moto;
        Cotxe cotxe;
        Furgoneta furgoneta;

        System.out.print("""       
                1 - Moto
                2 - Cotxe
                3 - Furgoneta
                """);
        System.out.print("Quin tipus de vehicle vols afegir? ");

        if (Main.comprovarInput() == 1) {
            System.out.println("Has escollit introduir una moto.");
            return moto = new Moto();
        } else if (Main.comprovarInput() == 2) {
            System.out.println("Has escollit introduir un cotxe.");
            return cotxe = new Cotxe();
        } else if (Main.comprovarInput() == 3) {
            System.out.println("Has escollit introduir una furgoneta.");
            return furgoneta = new Furgoneta();
        }
        return null;
    }

    public static void eliminarVehicle() {
        GestorLloguers.mostraVehicles();
        System.out.print("Selecciona quin vehicle vols descatalogar: ");

        llistaVehicles.remove(Main.comprovarInput() - 1);
    }

    @Override
    public void imprimirMenu() {
        System.out.println("""
                Has escollit Administrador.
                1 - Calcular Ingressos Totals.
                2 - Administrar vehicles.
                3 - Enrere.""");
    }
}
