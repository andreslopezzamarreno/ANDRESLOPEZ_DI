package com.example.entregajson;

public class Nacionalidad {
    private String nacionalidad,probabilidad;

    public Nacionalidad(String nacionalidad, String probabilidad) {
        this.nacionalidad = nacionalidad;
        this.probabilidad = probabilidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(String probabilidad) {
        this.probabilidad = probabilidad;
    }
}
