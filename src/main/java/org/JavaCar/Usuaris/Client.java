package org.JavaCar.Usuaris;
import org.JavaCar.GestorLloguers;
import org.JavaCar.Main;

import static org.JavaCar.GestorLloguers.llistaVehicles;

public class Client extends Usuari {

    public static void alquilarVehicle() {
        int opcio;

        GestorLloguers.llistaVehiclesPerAlquilar();
        opcio = Main.comprovarInput(0, llistaVehicles.size());

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

        opcio = Main.comprovarInput(0, llistaVehicles.size());

        if (llistaVehicles.get(opcio-1).isLlogat()){
            llistaVehicles.get(opcio-1).setLlogat(false);
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
