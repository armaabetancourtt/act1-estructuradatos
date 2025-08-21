/**
 * Autor: Armando Betancourt Esparza
 * Fecha: 20/08/2025
 * Descripción: Clase principal que muestra el menú de gestión de listas.
 * Permite probar listas entrelazadas para simulación de Sistema Operativo (OS)
 * 
 * Nota: Mantuve los metodos y atributos en ingles para tener un solo formato,
 * ademas de que asi vienen declarados los metodos en el tema 1.
 */

package app;

import DataStructure.LinkedList.DataTypeExamples;
import DataStructure.Stack.Stack;
import DataStructure.Queue.Queue;
import java.util.Scanner;

/**
 *  Simulador básico de sistema operativo
 *  Permite ejecutar comandos, agregar procesos, ver historial y procesar procesos
 */
public class Main {

    /**
     * Método principal del programa.
     * Muestra un menú y permite al usuario interactuar con el simulador de sistema operativo
     * @param args argumentos de línea de cmds
     */
    public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);

    // Crear estructuras de datos
    Stack<String> commandHistory = new Stack<>(); // PILA - historial de comandos
    Queue<String> processQueue = new Queue<>();   // COLA - procesos en orden de llegada
    int opcion;

    // Llenar con datos iniciales para pruebas usando DataTypeExamples
    DataTypeExamples.testStack(commandHistory); // llena la pila con comandos de ejemplo
    DataTypeExamples.testQueue(processQueue);   // llena la cola con procesos de ejemplo

    do {
        System.out.println("\n-----| Menú Principal |-----");
        System.out.println("1.- Agregar comando al historial (PILA - LIFO)");
        System.out.println("2.- Ver historial de comandos (PILA)");
        System.out.println("3.- Ejecutar último comando (PILA - Pop)");
        System.out.println("4.- Agregar proceso a la cola (COLA - FIFO)");
        System.out.println("5.- Procesar siguiente proceso (COLA - Dequeue)");
        System.out.println("6.- Ver cola de procesos (COLA)");
        System.out.println("7.- Salir");
        System.out.print("Elige una opción: ");

        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar un número válido.");
            opcion = -1;
        }

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingresa el comando: ");
                String cmd = sc.nextLine().trim();
                if (!cmd.isEmpty()) {
                    commandHistory.push(cmd); // LIFO
                    System.out.println("Comando agregado al historial.");
                } else {
                    System.out.println("Comando vacío, no se agregó.");
                }
            }
            case 2 -> {
                System.out.println("Historial de comandos (PILA - LIFO):");
                commandHistory.show();
            }
            case 3 -> {
                if (!commandHistory.isEmpty()) {
                    String cmd = commandHistory.pop(); // ejecuta el último comando ingresado
                    System.out.println("Ejecutando comando: " + cmd);
                } else {
                    System.out.println("No hay comandos en el historial.");
                }
            }
            case 4 -> {
                System.out.print("Ingresa el nombre del proceso: ");
                String proc = sc.nextLine().trim();
                if (!proc.isEmpty()) {
                    processQueue.enqueue(proc); // FIFO
                    System.out.println("Proceso agregado a la cola.");
                } else {
                    System.out.println("Proceso vacío, no se agregó.");
                }
            }
            case 5 -> {
                if (!processQueue.isEmpty()) {
                    String proc = processQueue.dequeue(); // procesa el primer proceso agregado
                    System.out.println("Procesando: " + proc);
                } else {
                    System.out.println("No hay procesos en la cola.");
                }
            }
            case 6 -> {
                System.out.println("Cola de procesos (COLA - FIFO):");
                processQueue.show();
            }
            case 7 -> System.out.println("Gracias por usar el simulador :)...");
            default -> {
                if (opcion != -1)
                    System.out.println("Opción no válida, ingresa un número del menú.");
            }
        }

    } while (opcion != 7);

    sc.close();

    }
}
