package model;

public class Surtidor {

    //variables
    private int capacidadTotal;
    private int capacidadActual;
    private String tipo;
    private boolean funcionando;

    //constructores
    public Surtidor(int capacidadTotal, String tipo) {
        this.capacidadTotal = capacidadTotal;
        this.capacidadActual = capacidadTotal;
        this.tipo = tipo;
        this.funcionando = true;
    }

    public Surtidor(String tipo) {
        this.tipo = tipo;
    }

    //metodos
    public void arreglar() {
        setFuncionando(true);
    }

    public void rellenar(int cantidad) {
        capacidadActual += cantidad;
        capacidadTotal += cantidad;
    }

    public void quitarGasolina(int cantidad) {
        capacidadTotal -= cantidad;
    }

    //getter setter
    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isFuncionando() {
        return funcionando;
    }

    public void setFuncionando(boolean funcionando) {
        this.funcionando = funcionando;
    }
}
