package model;

import java.util.ArrayList;

public class Gasolinera {
    //variables
    private String nombre;
    private ArrayList<Surtidor> surtidores;
    private int ganancias;

    //constructores
    public Gasolinera(String nombre) {
        surtidores = new ArrayList<>();
        this.nombre = nombre;
    }

    public void agregarSurtidor(Surtidor surtidor) {
        surtidores.add(surtidor);
    }

    //metodos
    public int obtenerNanancias() {
        return ganancias;
    }

    //getter setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Surtidor> getSurtidores() {
        return surtidores;
    }

    public void setSurtidores(ArrayList<Surtidor> surtidores) {
        this.surtidores = surtidores;
    }

    public int getGananias() {
        return ganancias;
    }

    public void setGananias(int gananias) {
        this.ganancias = gananias;
    }
}
