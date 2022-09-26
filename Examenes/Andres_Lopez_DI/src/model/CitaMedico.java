package model;

public class CitaMedico {
    private int dia, mes;

    public CitaMedico(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public void mostrarDatos() {
        System.out.println("\tcita: " + dia + "/" + mes);
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
}
