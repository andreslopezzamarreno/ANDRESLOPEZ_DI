import java.util.Scanner;

public class Main {


    //atributos propiedades
    private static String nombre = "Andrés"; // null por defecto
    public static int edad; // 0 por defecto
    // las variables "siempre" son privadas o protected
    public static boolean comienzo = true; // false



    //metodos y funciones

    // constructor

    public static void main(String[] args) {

        //System.out.println("Ejemplo inicial de repaso");
        //System.out.println(nombre); //con nombre static
        //System.out.print(new Main().nombre);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la edad");
        edad = scanner.nextInt();
        System.out.println("Introduce nombre");
        nombre = scanner.next();

        System.out.println(nombre);
        System.out.println(edad);

        //aritmeticos
        //+ - / %
        //asignacion
        //=
        //aritmeticos - asignacion
        //+=  -=  /=  %=
        //unarios
        //++ --
        //ligicos
        //&& (AND) -->V cuando las n condiciones sean V
        //|| (OR) -->V cuando una de las condiciones sea V
        //comparación
        //> >= < <= != ==
        //ternario
        //condicion ? cuando es true : cuando es false
        //condicion & cuando es true

        //Estructuras de control
        if (false){

        } else if (false) {

        } else {

        }

        //
        int numero=7;
        switch (numero){
            case 1|5|6|7:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }

        //ejecuciones 0-n veces
        numero = 10;
        while (numero<10) {
            System.out.println("Ejecucion");

            numero--;

        }

        //ejecuciones 1-n veces
        do{

        }while(numero<=10);


        //for -foreach
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        //recorridos completos
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*11);
        }
        for ( int item : numeros ) {
            System.out.println(item);
        }


    }


    //getter y setter
    //no obligatorios pero casi siempre hay que crearlos
    //encapsulamiento

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static boolean isComienzo() {
        return comienzo;
    }

    public static void setComienzo(boolean comienzo) {
        Main.comienzo = comienzo;
    }
}

