/**
 * Autor: Armando Betancourt Esparza
 * Fecha: 15/08/2025
 * Descripción: Clase principal que muestra el menú de gestión de listas.
 * Permite probar listas de contactos (simples, dobles, circulares) y
 * ejecutar ejemplos de listas de enteros usando DataTypeExamples
 * 
 * Nota: Mantuve los metodos y atributos en ingles para tener un solo formato,
 * ademas de que asi vienen declarados los metodos en el tema 1.
 */

package app;

import DataStructure.LinkedList.Contacto;
import DataStructure.LinkedList.DataTypeExamples;
import DataStructure.LinkedList.LinkedList;
import java.util.Scanner;

public class Main {

    /** Lista simple de contactos */
    private static LinkedList<Contacto> simpleContactList = null;
    /** Lista doble de contactos */
    private static LinkedList<Contacto> doublyContactList = null;
    /** Lista circular de contactos */
    private static LinkedList<Contacto> circularContactList = null;

    /**
     * Método principal del programa.
     * Muestra un menú y permite al usuario interactuar con distintas listas enlazadas
     * @param args argumentos de línea de cmds
     */
    public static void main(String[] args) {
        int opcion;
        try (Scanner sc = new Scanner(System.in)) {

            do {
                System.out.println("\n-----| Menú Principal |-----");
                System.out.println("Importante: Cada lista (simple, doble y circular) es independiente de la otra");
                System.out.println("-----| Escribe el número de la opción |-----");
                //Cada lista  es un sistema de gestión propio, es decir son diferentes "bibliotecas de contactos"
                System.out.println("1.- Lista Simple: Gestión de Contactos");
                System.out.println("2.- Lista Doble: Gestión de Contactos");
                System.out.println("3.- Lista Circular: Gestión de Contactos");
                System.out.println("4.- Ejemplo de Lista Simple (Enteros)");
                System.out.println("5.- Ejemplo de Lista Doble (Enteros)");
                System.out.println("6.- Ejemplo de Lista Circular (Enteros)");
                System.out.println("7.- Salir");
                System.out.print("Elige una opción: ");

                try {
                    opcion = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Debes ingresar un número válido.");
                    opcion = -1;
                }

                switch (opcion) {
                    case 1 -> manageContacts(sc, false, false);
                    case 2 -> manageContacts(sc, true, false);
                    case 3 -> manageContacts(sc, true, true);
                    case 4 -> examplesInt(sc, false, false);
                    case 5 -> examplesInt(sc, true, false);
                    case 6 -> examplesInt(sc, true, true);
                    case 7 -> System.out.println("Gracias por usar el programa :)...");
                    default -> {
                        if (opcion != -1)
                            System.out.println("Opción no válida, ingresa un número del menú.");
                    }
                }

            } while (opcion != 7);

        }
    }

    /**
     * Crea y gestiona una lista de {@link Contacto} según el tipo de lista elegido
     * @param sc Scanner para entrada del usuario
     * @param isDoubly true si la lista debe ser doblemente enlazada
     * @param isCircular true si la lista debe ser circular
     */
    private static void manageContacts(Scanner sc, boolean isDoubly, boolean isCircular) {
        LinkedList<Contacto> list;
        if (!isDoubly && !isCircular) {
            if (simpleContactList == null) {
                simpleContactList = new LinkedList<>(false, false);
                DataTypeExamples.testComplexObjects(simpleContactList);
            }
            list = simpleContactList;
        } else if (isDoubly && !isCircular) {
            if (doublyContactList == null) {
                doublyContactList = new LinkedList<>(true, false);
                DataTypeExamples.testComplexObjects(doublyContactList);
            }
            list = doublyContactList;
        } else {
            if (circularContactList == null) {
                circularContactList = new LinkedList<>(true, true);
                DataTypeExamples.testComplexObjects(circularContactList);
            }
            list = circularContactList;
        }

        interactWithList(list, sc, Contacto.class);
    }

    /**
     * Crea y gestiona una lista de enteros según el tipo de lista elegido.
     *
     * @param sc  Scanner para que el usuario interactue
     * @param isDoubly  true si la lista debe ser doblemente enlazada
     * @param isCircular true si la lista debe ser circular
     */
    private static void examplesInt(Scanner sc, boolean isDoubly, boolean isCircular) {
        LinkedList<Integer> list = new LinkedList<>(isDoubly, isCircular);
        DataTypeExamples.testIntegers(list);
        interactWithList(list, sc, Integer.class);
    }

    /**
     * Permite al usuario realizar operaciones sobre una lista enlazada
     *
     * @param list lista enlazada genérica
     * @param sc Scanner para entrada del usuario
     * @param tipoDato  tipo de dato de la lista (Contacto o Integer)
     * @param <E> tipo que guarda varios tipos de dato
     */
    private static <E> void interactWithList(LinkedList<E> list, Scanner sc, Class<E> tipoDato) {
        int opcion = -1;
        do {
            System.out.println("\nOperaciones disponibles:");
            System.out.println("1.- Insertar al inicio");
            System.out.println("2.- Insertar al final");
            System.out.println("3.- Eliminar elemento");
            System.out.println("4.- Buscar elemento");
            System.out.println("5.- Mostrar lista");
            System.out.println("6.- Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un número.");
                continue;
            }

            switch (opcion) {
                case 1, 2 -> {
                    E data = requestData(sc, tipoDato);
                    if (opcion == 1) list.insertAtFirstPosition(data);
                    else list.insertAtLastPosition(data);
                }
                case 3 -> {
                    E data = requestDataToRemove(sc, tipoDato);
                    if (list.remove(data)) System.out.println("Elemento eliminado");
                    else System.out.println("Elemento no encontrado");
                }
                case 4 -> {
                    E data = requestDataToRemove(sc, tipoDato);
                    int pos = list.indexOf(data);
                    if (pos != -1) {
                        System.out.println("Elemento encontrado en la posición " + pos);
                    } else {
                        System.out.println("Elemento no encontrado");
                    }
                }
                case 5 -> list.show();
            }

        } while (opcion != 6);
    }

    /**
     * Solicita al usuario un nuevo dato para insertar en la lista.
     * Si es un contacto pedirá nombre, dirección y su telefono
     * Si es un Integer forzará al usuario a introducir un número en bucle hasta que lo haga
     *
     * @param sc Scanner para entrada del usuario
     * @param tipoDato  clase del tipo de dato
     * @param <E> tipo que guarda datos
     * @return dato que ingresa el usuario
     */
    private static <E> E requestData(Scanner sc, Class<E> tipoDato) {
        if (tipoDato == Contacto.class) {
            String nombre, direccion, telefono;
            do {
                System.out.print("Ingresa el nombre: ");
                nombre = sc.nextLine().trim();
            } while (nombre.isEmpty());
            do {
                System.out.print("Ingresa la dirección: ");
                direccion = sc.nextLine().trim();
            } while (direccion.isEmpty());
            do {
                System.out.print("Ingresa el teléfono: ");
                telefono = sc.nextLine().trim();
                if (!telefono.matches("\\d+")) {
                    System.out.println("El teléfono debe ser solo números.");
                    telefono = "";
                }
            } while (telefono.isEmpty());
            return (E) new Contacto(nombre, direccion, telefono);
        } else {
            System.out.print("Ingresa el elemento: ");
            String input = sc.nextLine();
            if (tipoDato == Integer.class) return (E) Integer.valueOf(input);
            else return (E) input;
        }
    }

    /**
     * Solicita al usuario un dato para eliminar o buscar en la lista.
     * Para {@link Contacto} solo pide el nombre, ya que es suficiente para identificarlo.
     *
     * @param sc  Scanner para entrada del usuario
     * @param tipoDato  clase del tipo de dato
     * @param <E>   tipo que guarda dato
     * @return dato con la información necesaria para eliminar/buscar
     */
    private static <E> E requestDataToRemove(Scanner sc, Class<E> tipoDato) {
        if (tipoDato == Contacto.class) {
            System.out.print("Ingresa el nombre del contacto: ");
            String nombre = sc.nextLine().trim();
            return (E) new Contacto(nombre, "", "");
        } else {
            System.out.print("Ingresa el elemento: ");
            String input = sc.nextLine();
            if (tipoDato == Integer.class) return (E) Integer.valueOf(input);
            else return (E) input;
        }
    }
}
