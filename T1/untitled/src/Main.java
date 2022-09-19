import model.Carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main =new Main();
        ArrayList<Carta> baraja = main.baraja();
        int opcion;

        for (int i = 0; i < 2; i++) {
            System.out.println("Descartarse entre 1-3 cartas (1)\n" +
                    "Robar entre 1-3 cartas al rival (2)\n" +
                    "Pasar (Cualquier numero)");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("opcion 1");
                    break;
                case 2:
                    System.out.println("opcion 2");
                    break;
                default:
                    System.out.println("Pasar turno");
                    break;

            }
        }

    }

    public ArrayList<Carta> baraja(){
        String[] palos = new String[]{"Oros","Copas","Espadas","Bastos"};
        int[] numeros = new int[]{1,2,3,4,5,6,7,10,11,12};
        ArrayList<Carta> baraja = new ArrayList<>();
        for (String palo : palos) {
            for (int numero : numeros) {
                baraja.add(new Carta(numero, palo, numero + " de " + palo));
            }
        }
        Collections.shuffle(baraja);
        return baraja;
    }


    public void repartirCartas(){

    }

    public void descartarse(){

    }

    public void robar(){

    }

}
