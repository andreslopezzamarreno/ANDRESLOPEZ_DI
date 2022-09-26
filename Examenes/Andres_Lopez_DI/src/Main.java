import model.CentroSalud;
import model.Medico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CentroSalud centroSalud = new CentroSalud();
        int opcion;

        Medico nick_Rivera = new Medico("Nick", "Rivera", 1, 1, "Traumatologia");
        Medico hannibal_Lecter = new Medico("Hannibal", "Lecter", 2, 2, "Digestivo");
        Medico sam_Owens = new Medico("Sam", "owens", 3, 3, "piquiatria");
        Medico martin_Brenner = new Medico("martin", "brenner", 4, 4, "general");
        Medico stephen_Strange = new Medico("Stephen", "Strange", 5, 5, "cirugía");

        centroSalud.añadirMedico(nick_Rivera);
        centroSalud.añadirMedico(hannibal_Lecter);
        centroSalud.añadirMedico(sam_Owens);
        centroSalud.añadirMedico(martin_Brenner);
        centroSalud.añadirMedico(stephen_Strange);

        do {
            System.out.println("""
                    \nQue quieres hacer:\s
                    1.registrar paciente
                    2.pedir cita
                    3.listar medicos por especialidad
                    4.listar citas del paciente
                    5.salir
                    """);
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> centroSalud.registrarPaciente();
                case 2 -> centroSalud.pedirCita();
                case 3 -> centroSalud.listarMedicos();
                case 4 -> centroSalud.listarCitas();
                case 5 -> System.out.println("Salir");
                default -> System.out.println("Opcion no valida");
            }
        } while (opcion != 5);
    }
}
