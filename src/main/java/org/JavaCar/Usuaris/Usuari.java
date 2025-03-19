package org.JavaCar.Usuaris;

public class Usuari  {

    public Usuari() {}

    public void imprimirMenu() {
        System.out.println("""
                Si us plau, indiqueu quin tipus d'usuari sou.
                1 - Administrador
                2 - Client
                3 - Sortir""");
        System.out.print("Quin usuari sou? ");
    }
}
