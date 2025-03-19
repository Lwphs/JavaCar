package org.JavaCar.Usuaris;
import org.JavaCar.GestorLloguers;
import org.JavaCar.Main;
import org.JavaCar.Vehicle;

import java.util.ArrayList;

import static org.JavaCar.GestorLloguers.llistaVehicles;

public class Client extends Usuari {

    private ArrayList<Vehicle> vehiclesAlquitlats = new ArrayList<>();

    public static void alquilarVehicle() {
        int opcio;

        GestorLloguers.llistaVehiclesPerAlquilar();
        opcio = Main.comprovarInput();

        if (!llistaVehicles.get(opcio-1).isLlogat()) {
            llistaVehicles.get(opcio-1).setLlogat(true);
            System.out.println("El vehículo ha sido alquilado con éxito.");
        } else {
            System.out.println("El vehículo ya está alquilado.");
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
