import model.Coche;
import model.Gasolinera;
import model.Surtidor;

public class Main {
    public static void main(String[] args) {
        //Crear tres surtidores. Dos con capacidad total y tipo de gasolina y uno con tipo de gasolina
        Surtidor surtidor1 = new Surtidor(100, "Gasolina 95");
        Surtidor surtidor2 = new Surtidor(100, "Gasolina 98");
        Surtidor surtidor3 = new Surtidor("Gasolina 95");

        //Crear una gasolinera
        Gasolinera gasolinera = new Gasolinera("Repsol");

        //Agregar los tres surtidores a la gasolinera
        gasolinera.agregarSurtidor(surtidor1);
        gasolinera.agregarSurtidor(surtidor2);
        gasolinera.agregarSurtidor(surtidor3);

        //Crear un coche con tipo de gasolina
        Coche coche = new Coche("Gasolina 98");


        //Ejecutar el método ponerGasolina del coche (respotando una cantidad concreta)
        /*
        //error:Diferente tipo de gasolina
        coche.ponerGasolina(surtidor1,40);
        System.out.println(surtidor1.getCapacidadTotal());
        System.out.println(coche.getLitrosDeposito());
         */
        /*
        //error: no hay suficiente gasolina por la capacidadTotal
        coche.ponerGasolina(surtidor2,400);
        System.out.println(surtidor2.getCapacidadTotal());
        System.out.println(coche.getLitrosDeposito());
        */
        /*
        //error: no hay suficiente gasolina porque no tiene el surtidor
        coche.ponerGasolina(surtidor3,40);
        System.out.println(surtidor3.getCapacidadTotal());
        System.out.println(coche.getLitrosDeposito());
        */
        /*
        //error: El surtidor esta roto
        surtidor3.rellenar(400);
        coche.ponerGasolina(surtidor3,100);
        System.out.println(surtidor3.getCapacidadTotal());
        System.out.println(coche.getLitrosDeposito());
        */

        //funciana perfectamente
        coche.ponerGasolina(surtidor2, 40);
        System.out.println(surtidor2.getCapacidadTotal());
        System.out.println(coche.getLitrosDeposito());

    }
}
