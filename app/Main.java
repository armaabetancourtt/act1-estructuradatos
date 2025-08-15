/**
* Autor: Armando Betancourt Esparza
* Fecha: 14/08/2025
* Descripción: Esta clase principal tiene como función mostrar la interfaz del menú en consola,
* donde se puede probar listas de distintos tipos de datos: Enteros, Cadenas y Objetos complejos (Contactos)
* Además permite interactuar con las listas mediante operaciones de inserción, eliminación, búsqueda y visualización de elementos.
**/

package app;
import listas.*;
import java.util.Scanner;

public class Main {

    /**
     * Método principal que inicia el programa y muestra el menú principal al usuario.
     * Permite elegir el tipo de lista a probar o salir del programa.
     * 
     * @param args Argumentos de línea de comandos (no se usan en este programa).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            // Menú principal
            System.out.println("\n-----| Menú / Escribe el número de una opción |-----");
            System.out.println("1.- Prueba la lista de enteros");
            System.out.println("2.- Prueba la lista de cadenas");
            System.out.println("3.- Prueba la lista de objetos complejos (contactos)");
            System.out.println("4.- Salir");
            System.out.print("Elige una opción: ");
            String input = sc.nextLine();

            // Validación de la entrada
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Alerta de error: Debe ingresar un número de las opciones del menú");
                opcion = -1;
            }

            // Llamada al método correspondiente según la opción
            switch (opcion) {
                case 1 -> seleccionarTipoListaEnteros(sc);
                case 2 -> seleccionarTipoListaStrings(sc);
                case 3 -> seleccionarTipoListaContactos(sc);
                case 4 -> System.out.println("Gracias por usar el programa :)...");
                default -> {
                    if (opcion != -1)
                        System.out.println("Alerta de error: Debe ingresar un número de las opciones del menú");
                }
            }

        } while (opcion != 4);

        sc.close(); // Cerrar el Scanner al finalizar
    }

    /**
     * Permite al usuario seleccionar el tipo de lista de enteros (simple, doble o circular)
     * y luego ejecutar pruebas de inserción, eliminación y búsqueda en esa lista
     * 
     * @param sc Scanner para recibir entradas del usuario
     */
    private static void seleccionarTipoListaEnteros(Scanner sc) {
        int tipo = -1;
        do {
            System.out.println("Selecciona el tipo de lista:");
            System.out.println("1.- Simple");
            System.out.println("2.- Doble");
            System.out.println("3.- Circular");
            try {
                tipo = Integer.parseInt(sc.nextLine());
                if (tipo < 1 || tipo > 3) {
                    System.out.println("Debes ingresar un número entre 1 y 3.");
                    tipo = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un número válido.");
            }
        } while (tipo == -1);

        boolean isDoubly = tipo == 2;
        boolean isCircular = tipo == 3;

        LinkedList<Integer> list = new LinkedList<>(isDoubly, isCircular);
        DataTypeExamples.testIntegers(list); // Ejecuta pruebas predeterminadas con enteros
        interactuarConLista(list, sc, Integer.class); // Menú interactivo para el usuario
    }

    /**
     * Permite al usuario seleccionar el tipo de lista de cadenas (simple, doble o circular)
     * y luego ejecutar pruebas de inserción, eliminación y búsqueda en dicha lista
     * 
     * @param sc Scanner para recibir entradas del usuario
     */
    private static void seleccionarTipoListaStrings(Scanner sc) {
        int tipo = -1;
        do {
            System.out.println("Selecciona el tipo de lista:");
            System.out.println("1.- Simple");
            System.out.println("2.- Doble");
            System.out.println("3.- Circular");
            try {
                tipo = Integer.parseInt(sc.nextLine());
                if (tipo < 1 || tipo > 3) {
                    System.out.println("Debes ingresar un número entre 1 y 3.");
                    tipo = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un número válido.");
            }
        } while (tipo == -1);

        boolean isDoubly = tipo == 2;
        boolean isCircular = tipo == 3;

        LinkedList<String> list = new LinkedList<>(isDoubly, isCircular);
        DataTypeExamples.testStrings(list); // Ejecuta pruebas predeterminadas con cadenas
        interactuarConLista(list, sc, String.class); // Menú interactivo para el usuario
    }

    /**
     * Permite al usuario seleccionar el tipo de lista de contactos (simple, doble o circular)
     * y luego ejecutar pruebas de inserción, eliminación y búsqueda en dicha lista
     * Cada contacto requiere nombre, dirección y teléfono, con validación de datos
     * 
     * @param sc Scanner para recibir entradas del usuario
     */
    private static void seleccionarTipoListaContactos(Scanner sc) {
        int tipo = -1;
        do {
            System.out.println("Selecciona el tipo de lista:");
            System.out.println("1.- Simple");
            System.out.println("2.- Doble");
            System.out.println("3.- Circular");
            try {
                tipo = Integer.parseInt(sc.nextLine());
                if (tipo < 1 || tipo > 3) {
                    System.out.println("Debes ingresar un número entre 1 y 3.");
                    tipo = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un número válido.");
            }
        } while (tipo == -1);

        boolean isDoubly = tipo == 2;
        boolean isCircular = tipo == 3;

        LinkedList<Contacto> list = new LinkedList<>(isDoubly, isCircular);
        DataTypeExamples.testComplexObjects(list); // Ejecuta pruebas predeterminadas con contactos
        interactuarConLista(list, sc, Contacto.class); // Menú interactivo para el usuario
    }

    /**
     * Menú interactivo para realizar operaciones sobre cualquier lista 
     * Soporta inserción al inicio o al final, eliminación, búsqueda y mostrar lista
     * Para contactos valida nombre, dirección y teléfono al insertarlos
     * 
     * @param list Lista genérica sobre la que se operará
     * @param sc Scanner para recibir entradas del usuario
     * @param tipoDato Clase del tipo de dato almacenado en la lista (Integer, String, Contacto)
     */
    private static <E> void interactuarConLista(LinkedList<E> list, Scanner sc, Class<E> tipoDato) {
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
                    E data = null;
                    if (tipoDato == Contacto.class) {
                        // Solicitar datos completos para un contacto
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
                        data = (E) new Contacto(nombre, direccion, telefono);
                    } else {
                        // Insertar dato simple (String o Integer)
                        System.out.print("Ingresa el elemento: ");
                        data = (E) sc.nextLine();
                    }

                    if (opcion == 1) list.insertAtFirstPosition(data);
                    else list.insertAtLastPosition(data);
                }

                case 3 -> {
                    E data = null;
                    if (tipoDato == Contacto.class) {
                        System.out.print("Ingresa el nombre del contacto a eliminar: ");
                        String nombre = sc.nextLine();
                        data = (E) new Contacto(nombre, "", ""); // Solo nombre para buscar
                    } else {
                        System.out.print("Elemento a eliminar: ");
                        data = (E) sc.nextLine();
                    }

                    if (list.remove(data)) System.out.println("Elemento eliminado");
                    else System.out.println("No se encontró el elemento");
                }

                case 4 -> {
                    E data = null;
                    if (tipoDato == Contacto.class) {
                        System.out.print("Ingresa el nombre del contacto a buscar: ");
                        String nombre = sc.nextLine();
                        data = (E) new Contacto(nombre, "", ""); // Solo nombre para buscar
                    } else {
                        System.out.print("Elemento a buscar: ");
                        data = (E) sc.nextLine();
                    }

                    System.out.println(list.contains(data) ? "Elemento encontrado" : "Elemento no encontrado");
                }

                case 5 -> list.show(); // Muestra todos los elementos de la lista
            }

        } while (opcion != 6); // Repetir hasta que el usuario decida salir
    }
}
