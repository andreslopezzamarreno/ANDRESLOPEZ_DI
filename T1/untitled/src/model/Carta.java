package model;

public class Carta {

    //VARIABLES
    private int valor;
    private String palo;

    private String nombre;

    //CONSTRUCTORES
    public Carta(int valor, String palo,String nombre) {
        this.valor = valor;
        this.palo = palo;
        this.nombre = nombre;
    }

    //METODOS


    //GETTER SETTER TOSTRING
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "valor=" + valor +
                ", palo='" + palo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
