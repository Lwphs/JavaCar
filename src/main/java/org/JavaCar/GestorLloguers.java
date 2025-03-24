package org.JavaCar;
import java.util.ArrayList;
import java.util.List;

public abstract class GestorLloguers {

    // Llista de vehicles disponibles
    public static ArrayList<Vehicle> llistaVehicles = new ArrayList<>();

    // Llista de logs dels vehicles llogats
    public static ArrayList<LogVehicle> logsVehiclesAlquitlats = new ArrayList<>();


    /**
     * Calcula els ingressos totals per un conjunt de vehicles i un nombre de dies de lloguer.
     * @param vehicles Llista de vehicles llogats.
     * @param dies Nombre de dies de lloguer.
     * @return Els ingressos totals per al lloguer dels vehicles durant els dies indicats.
     */
    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies){
        double total = 0;
        for (Vehicle element : vehicles){
            total += element.calcularPreu(dies);
        } return total;
    }

    /**
     * Filtra els vehicles que tenen un preu base inferior o igual a un límit màxim i que no estan llogats.
     * @param vehicles Llista de vehicles a filtrar.
     * @param preuMax El preu màxim per al filtratge dels vehicles.
     * @return Una llista de vehicles que compleixen les condicions.
     */
    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        ArrayList<Vehicle> vehiclesFiltrats = new ArrayList<>();
        for (Vehicle vehicle : vehicles ){
            if (vehicle.getPreuBase() <= preuMax && !vehicle.isLlogat()){
                vehiclesFiltrats.add(vehicle);
            }
        }
        return vehiclesFiltrats;
    }

    /**
     * Mostra una llista dels vehicles disponibles per al lloguer.
     * Només es mostren els vehicles que no estan llogats.
     */
    public static void llistaVehiclesPerAlquilar() {
        int i = 0;
        System.out.println("-------Vehicles disponibles------");

        for (Vehicle vehicle : llistaVehicles) {
            i++;
            if (!vehicle.isLlogat()) {
                System.out.println(i + " - " + vehicle);
            }
        } System.out.print("Selecciona quin vehicle vols alquilar: ");
    }

    /**
     * Mostra una llista dels vehicles que estan llogats.
     */
    public static void vehiclesLlogats() {
        int count = 0;

        for (Vehicle vehicle : llistaVehicles) {
            count++;
            if (vehicle.isLlogat()) {
                System.out.println(count + " - " + vehicle);
            }
        }
    }

    /**
     * Mostra tots els vehicles registrats, tant llogats com no llogats.
     */
    public static void mostraVehicles() {
        int i = 0;

        for (Vehicle vehicle : llistaVehicles) {
            i ++;
            System.out.println(i + " - " + vehicle);
        }
    }

    /**
     * Calcula els ingressos totals de tots els vehicles llogats basant-se en els logs de lloguer.
     * @return El total d'ingressos per tots els vehicles llogats.
     */
    public static double calculIngresos() {
        double ingresos = 0;
        for (LogVehicle vehicle : logsVehiclesAlquitlats) {
            ingresos += vehicle.mostrarFactura();
        }
        return ingresos;
    }
}


