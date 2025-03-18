package org.JavaCar.Usuaris;

public class Usuari  {
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

    public void imprimirMenu() {
        System.out.println("""
                Si us plau, indiqueu quin tipus d'usuari sou.
                1 - Administrador
                2 - Client
                3 - Sortir""");
    }
}
