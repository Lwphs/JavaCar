package org.JavaCar.Usuaris;

public abstract class Usuari  {

    public Usuari() {}

    public static void imprimirMenu() {
        System.out.println("""
                Si us plau, indiqueu quin tipus d'usuari sou.
                1 - Administrador
                2 - Client
                3 - Sortir""");
        System.out.print("Quin usuari sou? ");
    }
}
