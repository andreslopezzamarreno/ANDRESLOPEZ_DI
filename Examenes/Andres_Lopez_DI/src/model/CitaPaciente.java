package model;

public class CitaPaciente {
    private int dia, mes;
    private String comentario;
    private Medico medico;

    public CitaPaciente(int dia, int mes, Medico medico, String comentario) {
        this.dia = dia;
        this.mes = mes;
        this.medico = medico;
        this.comentario = comentario;
    }

    public void mostrarDatos() {
        System.out.println("cita: " + dia + "/" + mes);
        System.out.println("Medico: dr." + medico.getApellido());
        System.out.println("Comentario: " + comentario);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
