package org.JavaCar;

import java.util.Scanner;
import static org.JavaCar.GestorLloguers.llistaVehicles;

public class Main {
    final public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        creacioVehicles();
        Menu.menuUsuari();
        input.close();
    }

    static double calculIngresos() {
        System.out.println("Quants dies s'han fet servir els cotxes?");
        int dies = input.nextInt();
        return GestorLloguers.calcularIngressosTotals(llistaVehicles, dies);
    }

    public static int comprovarInput(int min, int max) {
        int x = 0;
        boolean correctValue = false;

        do {
            if (input.hasNextInt()) {
                x = input.nextInt();
                input.nextLine();

                if (x < min || x > max)
                    System.out.println("Escriu un numero entre " + min + " i " + max + "!!!!");
                else
                    correctValue = true;
            } else {
                System.out.println("Escriu un integer!!!");
                input.nextLine();
            }
        } while (!correctValue);
        return x;
    }

    public static void creacioVehicles() {
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

        llistaVehicles.get(1).setLlogat(true);
        llistaVehicles.get(6).setLlogat(true);
    }
}
