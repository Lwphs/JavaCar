package org.JavaCar.Usuaris;
import org.JavaCar.GestorLloguers;
import org.JavaCar.LogVehicle;
import org.JavaCar.Main;
import org.JavaCar.Vehicle;

import java.util.ArrayList;

import static org.JavaCar.GestorLloguers.*;

public class Client extends Usuari {

    /**
     * Permet al client llogar un vehicle, amb la possibilitat de filtrar per preu.
     * Demana si vol filtrar els vehicles per preu i mostra les opcions disponibles.
     */
    public static void alquilarVehicle() {

        //Demanem si vol filtrar per preu o no
        System.out.println("Vols filtrar els vehicles per preu? (1: Sí | 2: No)");
        int filtrar = Main.comprovarInput(1, 2);


        if (filtrar == 1) {
            System.out.print("Introdueix el preu per al qual vols filtrar: ");
            double preu = Main.input.nextDouble();
            Main.input.nextLine(); // Evitar problemes d'entrada

            ArrayList<Vehicle> vehiclesFiltrats = (ArrayList<Vehicle>) GestorLloguers.filtrarPerPreu(GestorLloguers.llistaVehicles, preu);
            System.out.println("Vehicles disponibles amb un preu màxim de " + preu + "€:");

            // Filtra els vehicles per preu i mostra'ls
            if (vehiclesFiltrats.isEmpty()) {
                System.out.println("No hi ha vehicles disponibles en aquest rang de preus.");
            } else {
                int i = 0;
                for (Vehicle v : vehiclesFiltrats) {
                    i++;
                    System.out.println(i + " - " + v);
                }
                // Permet seleccionar un vehicle de la llista filtrada
                seleccionarVehicle(vehiclesFiltrats);

            }
        }
        else{
            // Mostra tots els vehicles disponibles per llogar
            GestorLloguers.llistaVehiclesPerAlquilar();
            seleccionarVehicle(GestorLloguers.llistaVehicles);
        }
    }

    /**
     * Permet al client seleccionar un vehicle de la llista de vehicles disponibles.
     * També sol·licita el nombre de dies per a llogar-lo i afegeix el vehicle als logs de lloguer.
     * @param vehicles Llista de vehicles disponibles per llogar.
     */
    public static void seleccionarVehicle(ArrayList<Vehicle> vehicles) {
        int opcio;

        opcio = Main.comprovarInput(0, llistaVehicles.size()) - 1;
        System.out.print("Quants dies vols alquilar el vehicle?? ");
        int dies = Main.comprovarInput(1,60);

        if (!vehicles.get(opcio).isLlogat()) {
            vehicles.get(opcio).setLlogat(true);
            System.out.println("Has alquilat " + vehicles.get(opcio));
            GestorLloguers.logsVehiclesAlquitlats.add(new LogVehicle(vehicles.get(opcio), dies));
            GestorLloguers.logsVehiclesAlquitlats.get(GestorLloguers.logsVehiclesAlquitlats.size() - 1).mostrarFactura();
        } else {
            System.out.println("El vehicle ja està alquilat.");
        }
    }

    /**
     * Permet al client retornar un vehicle llogat.
     * Sol·licita al client que esculli quin vehicle vol retornar i actualitza el seu estat.
     */
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

    public static void imprimirMenu() {
        System.out.println("""
                Has escollit Client.
                1 - Alquilar un vehicle.
                2 - Retornar un vehicle.
                3 - Enrere.""");
    }

}
