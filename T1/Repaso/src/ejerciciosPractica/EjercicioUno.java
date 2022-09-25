package ejerciciosPractica;

import java.util.Calendar;
import java.util.Scanner;

public class EjercicioUno {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar calendario = Calendar.getInstance();
        String nombre;
        String saludo;
        String opcion;

        String frase = "%s %s son las %d:%d del %d de %s del %d";
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int dia= calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int anio = calendario.get(Calendar.YEAR);
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","junio","julio","Agosto","Septiembre","Octubre","Nomviembre","Diciembre"};
        String mes2 = meses[mes];
        System.out.println("Por favor introduce tu nombre");
        nombre = sc.next();

        do{
            if(hora>=6 && hora<=12 ){
                saludo = "Buenos dias";
            }else if(hora>12 && hora<20) {
                saludo = "Buenas tardes";
            }else{
                saludo = "Buenas noches";
            }

            System.out.printf(frase,saludo,nombre,hora,minutos,dia,mes2,anio);
            System.out.println("\n¿Quieres volver a comprobar la hora?: S/N");
            opcion = sc.next();
        }while (opcion == "N");

        System.out.println("Que tengas " + saludo);
    }
}
