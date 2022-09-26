package model;

import java.util.ArrayList;

public final class Paciente extends Persona {
    private int nss;
    private ArrayList<CitaPaciente> citas;

    public Paciente(String nombre, String apellido, int dni, int nss) {
        super(nombre, apellido, dni);
        this.nss = nss;
        this.citas = new ArrayList<>();
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("NSS: " + nss);
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public ArrayList<CitaPaciente> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<CitaPaciente> citas) {
        this.citas = citas;
    }
}
