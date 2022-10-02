import model.Persona;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Entrada entrada = new Entrada();
        String nombre, sexo;
        int edad;
        double peso, altura;

        //Pide por teclado el nombre, la edad, sexo, peso y altura.
        System.out.println("Cual es tu nombre");
        nombre = sc.next();
        System.out.println("Cual es tu edad");
        edad = sc.nextInt();
        System.out.println("Cual es tu sexo (H/M)");
        sexo = sc.next();
        System.out.println("Cual es tu peso");
        peso = sc.nextDouble();
        System.out.println("Cual es tu altura");
        altura = sc.nextDouble();

        //Crea 3 objetos de tipo persona
        //el primer objeto obtendrá las anteriores variables pedidas por teclado
        Persona persona1 = new Persona(nombre, sexo, peso, altura, edad);
        //el segundo objeto obtendrá todos los anteriores menos el peso y la altura
        Persona persona2 = new Persona(nombre, sexo, edad);
        //el último por defecto, para este último utiliza los métodos set para darle a los atributos un valor.
        Persona persona3 = new Persona();
        persona3.setNombre("juan");
        persona3.setEdad(48);
        persona3.setSexo("H");
        persona3.setPeso(150);
        persona3.setAltura(1.69);

        System.out.println(persona2.calcularImc());
        //Para cada objeto, comprobar el imc mostrando un aviso para cada caso Estas en peso ideal, estas en sobrepeso o estás por debajo de peso
        entrada.aviso(persona1.calcularImc());
        entrada.aviso(persona2.calcularImc());
        entrada.aviso(persona3.calcularImc());

        //mostrar la información de cada objeto.
        persona1.mostrarDatos();
        persona2.mostrarDatos();
        persona3.mostrarDatos();
    }

    public void aviso(int imc) {
        switch (imc) {
            case -1 -> System.out.println("Estas por debajo de peso ideal");
            case 0 -> System.out.println("Estas en el peso ideal");
            case 1 -> System.out.println("Estas por encima de peso ideal");
            default -> System.out.println("IMC no calculado");
        }
    }
}
