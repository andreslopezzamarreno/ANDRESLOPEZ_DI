package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
    //variables
    Scanner sc = new Scanner(System.in);
    private ArrayList<Carta> mano;
    private String nombre;
    private int puntos;

    //constructores
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
        this.puntos = 0;
    }

    //metodos
    public void descartarse(ArrayList<Carta> nuevasCartas) {
        int posicion;
        if (nuevasCartas.size() <= 3) {
            for (Carta nuevaCarta : nuevasCartas) {
                System.out.println("Descartarte de carta");
                ordenarCartas();
                posicion = sc.nextInt();
                getMano().remove(posicion);
                getMano().add(nuevaCarta);
            }
        } else {
            System.out.println("No te puedes descartar de mas de tres cartas");
        }
    }

    public void robar(Jugador elotro) {
        int numeroCartas;
        int eliminarCarta;
        int aleatorio;
        System.out.println("Cuantas cartas quieres robar");
        numeroCartas = sc.nextInt();
        if (numeroCartas <= 3) {
            for (int j = 0; j < numeroCartas; j++) {
                aleatorio = (int) (Math.random() * 10);
                System.out.println("Que carta quieres borrar (indicar posicion 0-9)");
                ordenarCartas();
                eliminarCarta = sc.nextInt();
                elotro.getMano().add(getMano().get(eliminarCarta));
                getMano().remove(eliminarCarta);
                getMano().add(elotro.getMano().get(aleatorio));
                elotro.getMano().remove(aleatorio);
            }
        } else {
            System.out.println("No puedes robar mas de 3 cartas");
        }
    }

    public void mostrarMano() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + mano.get(i).getNombre());
        }
    }

    public void ordenarCartas() {
        System.out.println("Cartas " + getNombre());
        Carta aux;
        for (int i = 0; i < getMano().size(); i++) {
            for (int j = i + 1; j < getMano().size(); j++) {
                if (getMano().get(i).getPalo().equalsIgnoreCase(getMano().get(j).getPalo())) {
                    aux = getMano().get(i + 1);
                    getMano().set(i + 1, getMano().get(j));
                    getMano().set(j, aux);
                }
                if (getMano().get(i).getPalo().equalsIgnoreCase(getMano().get(i + 1).getPalo()) &&
                        getMano().get(i).getValor() > getMano().get(i + 1).getValor()) {
                    aux = getMano().get(i);
                    getMano().set(i, getMano().get(i + 1));
                    getMano().set(i + 1, aux);
                }
            }
        }
        mostrarMano();
    }

    public int calcularPuntos() {
        int max = 0;
        int contador = 0;
        for (int i = 0; i < getMano().size() - 1; i++) {
            if (getMano().get(i).getPalo().equalsIgnoreCase(getMano().get(i + 1).getPalo()) &&
                    getMano().get(i).getValor() == getMano().get(i + 1).getValor() - 1) {
                contador += 1;
                if (contador >= max) {
                    max = contador;
                }
            } else {
                contador = 0;
            }
        }
        return max + 1;
    }

    //getter y setter
    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}