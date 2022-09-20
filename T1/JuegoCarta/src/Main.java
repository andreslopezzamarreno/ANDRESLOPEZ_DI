import model.Carta;
import model.Jugador;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Variables
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean turno = true;
        String[] palos = new String[]{"Oros", "Copas", "Espadas", "Bastos"};
        int[] numeros = new int[]{1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
        ArrayList<Carta> baraja = new ArrayList<>();

        System.out.println("Nombre jugador 1");
        Jugador jugador1 = new Jugador(sc.next());
        System.out.println("Nombre jugador 2");
        Jugador jugador2 = new Jugador(sc.next());

        //Crear y barajar baraja
        for (String palo : palos) {
            for (int numero : numeros) {
                baraja.add(new Carta(numero, palo, numero + " de " + palo));
            }
        }
        Collections.shuffle(baraja);

        //Repartir cartas
        for (int i = 0; i < 10; i++) {
            jugador1.getMano().add(baraja.get(0));
            baraja.remove(0);
            jugador2.getMano().add(baraja.get(0));
            baraja.remove(0);
        }

        //dinamica del juego
        Jugador jugador;
        Jugador elotro;

        for (int i = 0; i < 4; i++) {
            //variacion del turno (1º)
            if (turno) {
                jugador = jugador1;
                elotro = jugador2;
            } else {
                jugador = jugador2;
                elotro = jugador1;
            }

            System.out.println("Turno de " + jugador.getNombre());
            jugador.ordenarCartas();
            System.out.println("""
                    Descartarse entre 1-3 cartas y robar del mazo (1)
                    Robar entre 1-3 cartas al rival (2)
                    Pasar (Cualquier numero)""");
            opcion = sc.nextInt();
            switch (opcion) {
                //Descartarse
                case 1 -> {
                    int numeroCartas;
                    ArrayList<Carta> nuevasCartas = new ArrayList<>();
                    System.out.println("Cuantas cartas quieres descartarte (1-3)");
                    //todo: controlar que no pueda descartarse de mas de 3
                    numeroCartas = sc.nextInt();
                    for (int j = 0; j < numeroCartas; j++) {
                        nuevasCartas.add(baraja.get(0));
                        baraja.remove(0);
                    }
                    jugador.descartarse(nuevasCartas);
                }
                //Robar
                case 2 -> jugador.robar(elotro);
                default -> System.out.println("Pasar turno");
            }

            //variacion del turno (2º)
            turno = !turno;
        }

        jugador1.ordenarCartas();
        jugador2.ordenarCartas();

        System.out.println(jugador1.getNombre() + " tiene " + jugador1.calcularPuntos() + " puntos");
        System.out.println(jugador2.getNombre() + " tiene " + jugador2.calcularPuntos() + " puntos");

        if (jugador1.calcularPuntos() > jugador2.calcularPuntos()) {
            System.out.println("Gana " + jugador1.getNombre());
        } else if (jugador1.calcularPuntos() == jugador2.calcularPuntos()) {
            System.out.println("Empate");
        } else {
            System.out.println("Gana " + jugador2.getNombre());
        }
    }
}
