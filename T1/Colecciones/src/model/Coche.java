package model;

public class Coche {

    //VARIABLES - PROPIEDAD
    //protected --> herencia
    private String matricula ;
    private String marca, modelo;
    private int velocidad, bastidor;
    private double km;


    //CONSTRUCTORES
    public Coche() {
    }

    public Coche(String marca, String modelo,int bastidor) {
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
    }

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    //METODOS

    public void acelerar(int velocidad){
        this.velocidad += velocidad;
        this.km += velocidad;
    }

    public void decelerar(int velocidad){
        this.velocidad -= velocidad;
    }

    public void frenar(){
        for (int i = velocidad; i > 0;i-=10); {
            velocidad -=10;
            System.out.println("Reduciendo velocidad: " + velocidad);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Coche frenado");
    }


    //GETTER  SETTER  TOSTRING
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

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

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidad=" + velocidad +
                ", bastidor=" + bastidor +
                ", km=" + km +
                '}';
    }
}
