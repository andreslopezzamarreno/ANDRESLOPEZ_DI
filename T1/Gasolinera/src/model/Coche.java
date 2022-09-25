package model;

public class Coche {
    //variables
    private String tipoGasolina;
    private int litrosDeposito;

    //constructores
    public Coche(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
    }

    //metodos
    //todo: terminar este metodo
    public void ponerGasolina(Surtidor surtidor,int cantidadLitros){
        if(surtidor.getCapacidadActual() == 0 || surtidor.getCapacidadActual()<cantidadLitros){

        } else if (surtidor.isFuncionando()) {
            surtidor.quitarGasolina(cantidadLitros);
        }else {
            System.out.println("Surtidor roto");
        }
    }

    //getter y setter
    public String getTipoGasolina() {
        return tipoGasolina;
    }

    public void setTipoGasolina(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
    }

    public int getLitrosDeposito() {
        return litrosDeposito;
    }

    public void setLitrosDeposito(int litrosDeposito) {
        this.litrosDeposito = litrosDeposito;
    }
}
