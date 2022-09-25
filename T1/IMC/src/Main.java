import model.Persona;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre,sexo;
        int edad, peso, altura;

        System.out.println("Cual es tu nombre");
        nombre = sc.next();
        System.out.println("Cual es tu edad");
        edad = sc.nextInt();
        System.out.println("Cual es tu sexo (H/M)");
        sexo = sc.next();
        System.out.println("Cual es tu peso");
        peso = sc.nextInt();
        System.out.println("Cual es tu altura");
        altura = sc.nextInt();


        Persona persona1 = new Persona();
        Persona persona2 = new Persona();
        Persona persona3 = new Persona();

        

    }
}
