package com.example.pizeria.model;

import java.util.ArrayList;

public class Pizza {
    private String nombre,tamanio;
    private ArrayList<Ingrediente> ingredientes ;
    private int precio;

    public Pizza(String nombre, ArrayList<Ingrediente> ingredientes ) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList<Ingrediente>();
    }

    public Pizza(String nombre, String tamanio, ArrayList<Ingrediente> ingredientes, int precio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.ingredientes = ingredientes;
        this.precio = precio;
    }

    public void mostrarDatos(){
        System.out.println("PIZZA: " +nombre);
        System.out.println("TAMAÑO: " +tamanio);
        System.out.println("INGREDIENTES:");
        for (int i = 0; i < ingredientes.size(); i++) {
            System.out.println("\t- " + ingredientes.get(i).getNombre());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Ingrediente> getIngrdientes() {
        return ingredientes;
    }

    public void setIngrdientes(ArrayList<Ingrediente> ingrdientes) {
        this.ingredientes = ingrdientes;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pizza " + nombre;
    }
}
