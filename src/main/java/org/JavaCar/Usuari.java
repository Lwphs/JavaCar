package org.JavaCar;

import java.util.Scanner;

public class Usuari implements Menu {
    protected String nom;
    protected String cognom;
    protected String telefon;
    protected String email;

    public Usuari(String nom, String cognom, String telefon, String email) {
        this.nom = nom;
        this.cognom = cognom;
        this.telefon = telefon;
        this.email = email;
    }

    public Usuari() {}

    @Override
    public void imprimirMenu() {
        System.out.println("""
                ---Benvingut a JavaCar!---
                Si us plau, indiqueu quin tipus d'usuari sou.
                1 - Administrador
                2 - Client
                3 - Sortir
                """);
    }
}
