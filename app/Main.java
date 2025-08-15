/**
* Autor: Armando Betancourt Esparza
* Fecha: 14/08/2025
* Descripción: Esta clase principal tiene como función mostrar la interfaz del menú en consola, donde puedes probar la lista de
* primitivos - enteros, cadenas, objetos complejos como contactos y cerrar el scanner (salir del programa).
**/

package act1estructuradatos;
import java.util.Scanner;
import listas.*;

public class Main {
    
    /**
     * Método principal que inicia todo lo referente al programa
     * Muestra un menú al usuario con do y llama a los métodos de prueba
     * correspondientes de la clase que tiene todos los datos: DataTypeExamples
     * 
     * @param args Argumentos de línea de comandos (no se usan en este programa).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion=-1;

        do {
            System.out.println("\n-----| Menú / Escribe el número de una opcion |-----");
            System.out.println("1.- Prueba la lista (LinkedList) de enteros");
            System.out.println("2.- Prueba la lista (LinkedList) de cadenas");
            System.out.println("3.- Prueba la lista (LinkedList) de objetos complejos");
            System.out.println("4.- Salir");
            System.out.print("Elige una opción: ");
            String input = sc.nextLine();
            
            //Validar la entrada
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Alerta de error: Debe ingresar un número de las opciones del menú");
                opcion = -1; //Reiniciar la opción
            }
            //Switch con opciones
            switch (opcion) {
                case 1 -> DataTypeExamples.testIntegers();
                case 2 -> DataTypeExamples.testStrings();
                case 3 -> DataTypeExamples.testComplexObjects();
                case 4 -> System.out.println("Gracias por usar el programa :)...");
                default -> {
                     if (opcion != -1) System.out.println("Alerta de error: Debe ingresar un número de las opciones del menú");
                }
            }

        } while (opcion != 4); //Se repite hasta que el usuario decida salir

        sc.close();
    }
}
