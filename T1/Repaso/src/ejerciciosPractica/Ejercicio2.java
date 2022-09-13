package ejerciciosPractica;

import coches.Main;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        /*
        Crear un array de elementos de tipo integer con 50 posiciones. Crear un menú que tenga las siguientes opciones:
            Rellenar: introducirá números de forma aleatoria (estarán comprendidos entre 1 y 200). En caso de que el array esté
                ya lleno pedirá confirmación.
            Listar: mostrará por pantalla el contenido del array con la sintaxis: Elemento 1: X
            Ordenar: ordenará el array con números de menos a mayor.
            Vaciar: dejará el array vacío
            Salir: terminará la ejecución del programa
         */

        /*
        Agregar al menu las siguientes opciones :
        buscar un elemento: pedir al usuario un elemento a buscar y mostrar la posición en la que se encuentra
        sustutuir elemento: pedira el elemento que quieres sustutuir y por el numero que quieres sustituir
        calcular max y min
        quitar errores de array no relleno
         */
        Scanner sc = new Scanner(System.in);
        int[] numeros = null;

        int opcion;
        int busqueda;
        int posicion = 0;
        int sustitucion;

        do {
            System.out.println("Que quieres hacer? \n1.Rellenar array con aleatorios(1-200)\n2.Listar Array\n" +
                    "3.Ordenar Array\n4.vaciar array\n5.buscar elemento\n6.sustituir elemento\n7.calcular maximo y minimo\n8.salir\n");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    /*
                    Rellenar: introducirá números de forma aleatoria (estarán comprendidos entre 1 y 200). En caso de que el array esté
                ya lleno pedirá confirmación.
                     */
                    if (numeros != null) {
                        System.out.println("Array relleno, rellenar de nuevo (S/N)");
                        String contestacion = sc.next();
                        if (contestacion.equalsIgnoreCase("s")) {
                            numeros = new Ejercicio2().rellenarArray();
                        }
                    } else {
                        numeros = new Ejercicio2().rellenarArray();
                    }

                    System.out.println("Arraylist Relleno");
                    break;
                case 2:
                    /*
                    Listar: mostrará por pantalla el contenido del array con la sintaxis: Elemento 1: X
                     */
                    if (new Ejercicio2().comprobarVacio(numeros)) {
                        for (int i = 0; i < numeros.length; i++) {
                            System.out.println("Elemento " + (i + 1) + ": " + numeros[i]);
                        }
                    } else {
                        System.out.println("arraylist vacio");
                    }
                    break;
                case 3:
                    /*
                    Ordenar: ordenará el array con números de menos a mayor.
                     */
                    if (new Ejercicio2().comprobarVacio(numeros)) {
                        Arrays.sort(numeros);
                        System.out.println("Array ordenado\n");
                    } else {
                        System.out.println("arraylist vacio");
                    }
                    break;
                case 4:
                    /*Vaciar: dejará el array vacío*/
                    numeros = null;
                    System.out.println("vaciado completo ");
                    break;
                case 5:
                    //buscar un elemento (solo el primero)
                    if (new Ejercicio2().comprobarVacio(numeros)) {
                        System.out.println("Que elemento quieres buscar");
                        busqueda = sc.nextInt();
                        if (new Ejercicio2().busqueda(numeros, busqueda) ==-1){
                            System.out.println("Elemento no encontrado");
                        }
                    } else {
                        System.out.println("arraylist vacio");
                    }
                    break;
                case 6:
                    // sustutuir elemento
                    if (new Ejercicio2().comprobarVacio(numeros)) {
                        System.out.println("Que elemento quieres buscar");
                        busqueda = sc.nextInt();
                        System.out.println("Por que elemento lo quieres sustituir");
                        sustitucion = sc.nextInt();
                        while ((posicion = new Ejercicio2().busqueda(numeros, busqueda))!=-1){
                            numeros[posicion] = sustitucion;
                        }
                    } else {
                        System.out.println("arraylist vacio");
                    }
                    break;
                case 7:
                    // calcular max y min
                    if (new Ejercicio2().comprobarVacio(numeros)) {
                        /*int max = -1;
                        int min = 201;
                        for (int item : numeros) {
                            if (item > max) {
                                max = item;
                            }
                            if (item < min) {
                                min = item;
                            }
                        }*/

                        int[] cloneNumeros = numeros.clone();
                        Arrays.sort(cloneNumeros);
                        int max = cloneNumeros[cloneNumeros.length-1];
                        int min = cloneNumeros[0];

                        System.out.println("El maximo es: " + max + "\nEl minimo es: " + min);
                    } else {
                        System.out.println("arraylist vacio");
                    }
                    break;
                case 8:
                    /*
                    Salir: terminará la ejecución del programa
                     */
                    System.out.println("salir");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (opcion != 8);
    }

    public int[] rellenarArray() {
        int[] numerosAux = new int[50];
        for (int i = 0; i < 50; i++) {
            numerosAux[i] = (int) (Math.random() * 200);
        }
        return numerosAux;
    }

    public boolean comprobarVacio(int[] arrayNumeros) {
        if (arrayNumeros != null) {
            return true;
        } else {
            return false;
        }
    }

    public int busqueda(int[] losNumeros, int busqueda) {
        for (int i = 0; i < losNumeros.length; i++) {
            if (busqueda == losNumeros[i]) {
                System.out.println("Elemento encontrado en la posicion " + i + "\n");
                return i;
            }
        }
        return -1;
    }
}
