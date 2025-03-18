package org.JavaCar;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final public static Scanner input = new Scanner(System.in);
    final static Usuari usuari = new Usuari();
    final static Client client = new Client();
    final static Administrador administrador = new Administrador();
    
    static ArrayList<Vehicle> llistaVehicles = new ArrayList<>();

    public static void main(String[] args) {
        creacioVehicles();
        usuari.imprimirMenu();
        client.imprimirMenu();
    }

    private static void creacioVehicles() {
        Roda[] rodesCotxe = {new Roda("Michelin", 17), new Roda("Michelin", 17), new Roda("Michelin", 17), new Roda("Michelin", 17)};
        Roda[] rodesMoto = {new Roda("Michelin", 17), new Roda("Michelin", 17)};

        Motor motorCotxe = new Motor("Gasolina", 120);
        Motor motorMoto = new Motor("Diesel", 80);

        llistaVehicles.add(new Moto("5678DEF", "Yamaha", "R3", 25, 300, motorCotxe, rodesCotxe));
        llistaVehicles.add(new Cotxe("2222DEF", "Ford", "Focus", 28, 5, motorMoto, rodesMoto));
        llistaVehicles.add(new Moto("5678DEF", "Yamaha", "R3", 25, 300, motorCotxe, rodesCotxe));
        llistaVehicles.add(new Cotxe("2222DEF", "Ford", "Focus", 28, 5, motorMoto, rodesMoto));
        llistaVehicles.add(new Moto("1234ABC", "Honda", "CBR500R", 23, 320, motorMoto, rodesMoto));
        llistaVehicles.add(new Cotxe("3333GHI", "Toyota", "Corolla", 30, 5, motorCotxe, rodesCotxe));
        llistaVehicles.add(new Moto("9999XYZ", "Ducati", "Panigale V2", 27, 280, motorMoto, rodesMoto));
        llistaVehicles.add(new Cotxe("7777JKL", "Volkswagen", "Golf", 26, 5, motorCotxe, rodesCotxe));
        llistaVehicles.add(new Moto("5555MNO", "Kawasaki", "Ninja 650", 24, 290, motorMoto, rodesMoto));

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
                    break;
                    case 2:
                        retornarVehicle();


            }

        } while (option != 3);
    }

    private static void retornarVehicle() {
        System.out.println("Qui vol retornar el vehicle?");
    }

    private static void alquilarVehicle() {
        System.out.println("Selecciona quin vehicle vols alquilar");
        int i = 0;
        for (Vehicle vehicle : llistaVehicles) {
            if (!vehicle.isLlogat()) {
                i++;
                System.out.println(i + " " + vehicle.toString());
            }
        }
    }
}