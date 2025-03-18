package org.JavaCar.Usuaris;

public class Administrador extends Usuari {

    @Override
    public void imprimirMenu() {
        System.out.println("""
                Has escollit Administrador.
                1 - Calcular Ingressos Totals.
                2 - Administrar vehicles llogats.
                3 - Enrere.
                4 - Modificar vehicle.
                5 - Afegir vehicle.
                6 - Descatalogar vehicle.""");
    }
}
