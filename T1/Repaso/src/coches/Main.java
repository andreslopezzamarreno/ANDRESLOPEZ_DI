package coches;

public class Main {

    public static void main(String[] args) {
        Coche[] coches = new Coche[3];
        Coche cocheMercedes;
        cocheMercedes = new Coche("Mercedes","C220",200,2.500);
        Coche cocheMercedesDos = new Coche("Mercedes","C180",200,2.500);
        Coche cocheAudi = new Coche("Audi","A5",200,2.500);

        coches[0] = cocheMercedes;
        coches[1] = cocheMercedesDos;
        coches[0] = cocheAudi;


    }

}
