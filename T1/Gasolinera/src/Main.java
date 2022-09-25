import model.Coche;
import model.Gasolinera;
import model.Surtidor;

public class Main {
    public static void main(String[] args) {
        //Crear tres surtidores. Dos con capacidad total y tipo de gasolina y uno con tipo de gasolina
        Surtidor surtidor1 = new Surtidor(100,"Gasolina 95");
        Surtidor surtidor2 = new Surtidor(100,"Gasolina 98");
        Surtidor surtidor3 = new Surtidor("Gasolina 95");

        //Crear una gasolinera
        Gasolinera gasolinera = new Gasolinera("Repsol");

        //Agregar los tres surtidores a la gasolinera
        gasolinera.getSurtidores().add(surtidor1);
        gasolinera.getSurtidores().add(surtidor2);
        gasolinera.getSurtidores().add(surtidor3);

        //Crear un coche con tipo de gasolina
        Coche coche = new Coche("Gasolina 98");

        //Ejecutar el método ponerGasolina del coche (respotando una cantidad concreta)
        coche.ponerGasolina(surtidor1,40);
    }
}
