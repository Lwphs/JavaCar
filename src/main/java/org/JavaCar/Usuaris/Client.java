package org.JavaCar.Usuaris;
import org.JavaCar.GestorLloguers;
import org.JavaCar.LogVehicle;
import org.JavaCar.Main;

import static org.JavaCar.GestorLloguers.llistaVehicles;
import static org.JavaCar.LogVehicle.logsVehiclesAlquitlats;

public class Client extends Usuari {

    public static void alquilarVehicle() {
        int opcio;

        GestorLloguers.llistaVehiclesPerAlquilar();
        opcio = Main.comprovarInput(0, llistaVehicles.size()) - 1;
        System.out.print("Quants dies vols alquilar el vehicle?? ");
        int dies = Main.comprovarInput(1,60);

        if (!llistaVehicles.get(opcio).isLlogat()) {
            llistaVehicles.get(opcio).setLlogat(true);
            System.out.println("Has alquilat " + llistaVehicles.get(opcio));
            logsVehiclesAlquitlats.add(new LogVehicle(llistaVehicles.get(opcio), dies));
            logsVehiclesAlquitlats.get(logsVehiclesAlquitlats.size() - 1).calcularPreu();
        } else {
            System.out.println("El vehicle ja està alquilat.");
        }
    }

    public static void retornarVehicle() {
        int opcio;

        System.out.println("Selecciona quin vehicle vols tornar.");
        GestorLloguers.vehiclesLlogats();

        opcio = Main.comprovarInput(0, llistaVehicles.size()) - 1;

        if (llistaVehicles.get(opcio).isLlogat()){
            llistaVehicles.get(opcio).setLlogat(false);
            System.out.println("Has retornat el vehicle correctament");
        }
        else{
            System.out.println("El vehicle no està llogat");
        }
    }

    @Override
    public void imprimirMenu() {
        System.out.println("""
                Has escollit Client.
                1 - Alquilar un vehicle.
                2 - Retornar un vehicle.
                3 - Enrere.""");
    }

}
