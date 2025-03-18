package org.JavaCar;

public class Administrador extends Usuari {

    public Administrador(String nom, String cognom, String telefon, String email) {
        super(nom, cognom, telefon, email);
    }

    public Administrador() {}

    @Override
    public void imprimirMenu() {
        System.out.println("""
                Has escollit Administrador.
                1 - Calcular Ingressos Totals.
                2 - Administrar vehicles llogats.
                3 - Enrere.
                """);
    }
}
