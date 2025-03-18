package org.JavaCar;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static Scanner input = new Scanner(System.in);
    static ArrayList<Vehicle> llistaVehicles = new ArrayList<>();

    public static void main(String[] args) {
        Roda[] rodesCotxe = {new Roda("Michelin", 17), new Roda("Michelin", 17), new Roda("Michelin", 17), new Roda("Michelin", 17)};
        Roda[] rodesMoto = {new Roda("Michelin", 17), new Roda("Michelin", 17)};

        Motor motorCotxe = new Motor("Gasolina", 120);
        Motor motorMoto = new Motor("Diesel", 80);

        llistaVehicles.add(new Moto("5678DEF", "Yamaha", "R3", 25, 300, motorCotxe, rodesCotxe));
        llistaVehicles.add(new Cotxe("2222DEF", "Ford", "Focus", 28, 5, motorMoto, rodesMoto));

        menuUsuari();
    }

    private static void menuUsuari() {
        int option;

        do {
            System.out.println("""
                ---Benvingut a JavaCar!---
                1 - Alquilar vehicle
                2 - Retornar vehicle
                3 - Sortir
                """);

            option = input.nextInt();

            switch (option) {
                case 1:
                    alquilarVehicle();
            }

        } while (option != 3);
    }

    private static void alquilarVehicle() {
        System.out.println("Selecciona quin vehicle vols alquilar");
        for (int i = 0; i < llistaVehicles.size(); i++) {
            if (!llistaVehicles.get(i).isLlogat())
                System.out.println(llistaVehicles.get(i).toString());;
        }
    }
}