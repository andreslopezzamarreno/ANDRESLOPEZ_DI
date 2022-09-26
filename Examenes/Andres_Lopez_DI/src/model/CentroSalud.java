package model;

import java.util.ArrayList;
import java.util.Scanner;

public class CentroSalud {
    Scanner sc = new Scanner(System.in);
    private String nombre, apellido, especialidad, comentario;
    private int dni, nss, numero, dia, mes;

    private ArrayList<Medico> medicos;
    private ArrayList<Paciente> pacientes;

    public CentroSalud() {
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
    }

    public void añadirMedico(Medico medico) {
        medicos.add(medico);
    }

    public void registrarPaciente() {
        System.out.println("Nombre del paciente");
        nombre = sc.next();
        System.out.println("Apellido del paciente");
        apellido = sc.next();
        System.out.println("DNI del paciente");
        dni = sc.nextInt();
        System.out.println("NSS del paciente");
        nss = sc.nextInt();
        if (existePaciente(nss) == null) {
            pacientes.add(new Paciente(nombre, apellido, dni, nss));
        } else {
            System.out.println("Ya existe un paciente con el mismo NSS");
        }
    }

    public void pedirCita() {
        Medico medico2 = null;
        Paciente paciente2;
        boolean diaLibre = true;
        System.out.println("Indica nss del paciente");
        nss = sc.nextInt();
        System.out.println("Sobre que especialidad");
        especialidad = sc.next();
        System.out.println("Nº colegiado del medico");
        numero = sc.nextInt();
        System.out.println("Dia");
        dia = sc.nextInt();
        System.out.println("Mes");
        mes = sc.nextInt();
        //todo: añadir BufferedReader a "comentario" para que lea mas de una palabra
        System.out.println("comentario");
        comentario = sc.next();
        for (Medico medico : medicos) {
            if (medico.getnColegiado() == numero && medico.getEspecialidad().equalsIgnoreCase(especialidad)) {
                medico2 = medico;
            }
        }
        if (medico2 != null) {
            paciente2 = existePaciente(nss);
            for (CitaMedico cita : medico2.getCitas()) {
                if (cita.getDia() == dia && cita.getMes() == mes) {
                    System.out.println("Ya tiene una cita ese dia");
                    diaLibre = false;
                }
            }
            if (diaLibre) {
                medico2.getCitas().add(new CitaMedico(dia, mes));
                paciente2.getCitas().add(new CitaPaciente(dia, mes, medico2, comentario));
            }
        } else {
            System.out.println("no hay medico disponible");
        }
    }

    public void listarMedicos() {
        String especialidad;
        System.out.println("De que especialidad quieres ");
        especialidad = sc.next();
        for (Medico medico : medicos) {
            if (especialidad.equalsIgnoreCase(medico.getEspecialidad())) {
                medico.mostrarDatos();
            }
        }
    }

    public void listarCitas() {
        System.out.println("NSS del paciente");
        nss = sc.nextInt();
        if (!pacientes.isEmpty()) {
            if (existePaciente(nss) != null) {
                for (CitaPaciente citaPaciente : existePaciente(nss).getCitas()) {
                    citaPaciente.mostrarDatos();
                }
            }
        } else {
            System.out.println("No hay pacientes registrados");
        }
    }

    private Paciente existePaciente(int nss) {
        Paciente paciente2 = null;
        for (Paciente paciente : pacientes) {
            if (paciente.getNss() == nss) {
                paciente2 = paciente;
            }
        }
        return paciente2;
    }

    //no hago "existeMedico" porque cada vez se busca de una forma
}
