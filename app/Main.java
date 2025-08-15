/**
* Autor: Armando Betancourt Esparza
* Fecha: 14/08/2025
* Descripción: Esta clase principal tiene como función mostrar la interfaz del menú en consola, donde puedes probar la lista de
* primitivos - enteros, cadenas, objetos complejos como contactos y cerrar el scanner (salir del programa).
**/

package app;
import listas.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n-----| Menú / Escribe el número de una opción |-----");
            System.out.println("1.- Prueba la lista de enteros");
            System.out.println("2.- Prueba la lista de cadenas");
            System.out.println("3.- Prueba la lista de objetos complejos (contactos)");
            System.out.println("4.- Salir");
            System.out.print("Elige una opción: ");
            String input = sc.nextLine();

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Alerta de error: Debe ingresar un número de las opciones del menú");
                opcion = -1;
            }

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

        sc.close();
    }

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
        DataTypeExamples.testIntegers(list);
        interactuarConLista(list, sc, Integer.class);
    }

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
        DataTypeExamples.testStrings(list);
        interactuarConLista(list, sc, String.class);
    }

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
        DataTypeExamples.testComplexObjects(list);
        interactuarConLista(list, sc, Contacto.class);
    }

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
                        data = (E) new Contacto(nombre, "", "");
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
                        data = (E) new Contacto(nombre, "", "");
                    } else {
                        System.out.print("Elemento a buscar: ");
                        data = (E) sc.nextLine();
                    }

                    System.out.println(list.contains(data) ? "Elemento encontrado" : "Elemento no encontrado");
                }

                case 5 -> list.show();
            }

        } while (opcion != 6);
    }
}
