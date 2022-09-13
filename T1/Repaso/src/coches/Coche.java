package coches;

public class Coche {

    //propiedades --> private o protected
    //dato propio de objeto
    private String marca, modelo, matricula;
    private int cv;
    private double cc;

    //constructores --> siempre uno por defecto (vacio) hasta que se cree un constructor

    public Coche() {
        this.marca="Sin definir";
        this.modelo="Sin definir";
        this.matricula="Sin definir";
    }

    public Coche(String marca, String modelo, String matricula, int cv, double cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
        this.cc = cc;
    }

    public Coche(String marca, String modelo, int cv, double cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.cc = cc;
    }

    //metodos


    //getter y setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    //toString --> {JSON}
    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", cv=" + cv +
                ", cc=" + cc +
                '}';
    }
}
