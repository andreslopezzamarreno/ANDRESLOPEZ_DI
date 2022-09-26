package model;

import java.util.ArrayList;

public final class Medico extends Persona{
    private int nColegiado;
    private String especialidad;
    private ArrayList<CitaMedico>citas;

    public Medico(String nombre, String apellido, int dni, int nColegiado, String especialidad) {
        super(nombre, apellido, dni);
        this.nColegiado = nColegiado;
        this.especialidad = especialidad;
        citas = new ArrayList<>();
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("numero colegiado: " + nColegiado);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Citas");
        if(citas.size()!=0){
            for (CitaMedico cita:citas) {
                cita.mostrarDatos();
            }
        }else{
            System.out.println("El medico no tiene citas");
        }
    }

    public int getnColegiado() {
        return nColegiado;
    }

    public void setnColegiado(int nColegiado) {
        this.nColegiado = nColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<CitaMedico> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<CitaMedico> citas) {
        this.citas = citas;
    }
}
