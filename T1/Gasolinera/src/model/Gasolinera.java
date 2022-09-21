package model;

import java.util.ArrayList;

public class Gasolinera {
    //variables
    private String nombre;
    private ArrayList<Surtidor> surtidores;
    private int gananias;

    //constructores
    public Gasolinera(String nombre) {
        this.nombre = nombre;
    }

    //metodos
    public int obtenerNanancias(){
        return gananias;
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
        return gananias;
    }

    public void setGananias(int gananias) {
        this.gananias = gananias;
    }
}
