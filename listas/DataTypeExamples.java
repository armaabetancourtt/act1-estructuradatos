/**
* Autor: Armando Betancourt Esparza
* Fecha: 14/08/2025
* Descripción: La clase prácticamente sirve para probar todos los datos primitivos indicados en la actividad como
* primitivos (int), cadena (String) y los complejos (los contactos).
**/

package listas;

public class DataTypeExamples {
    
    /**
     * Método que prueba o testea la LinkedList con enteros.
     * Creo una lista y los inserto al final de la misma, también se muestran en consola.
     */
    public static void testIntegers(LinkedList<Integer> list) {
        list.insertAtLastPosition(10);
        list.insertAtLastPosition(333);
        list.insertAtLastPosition(1313);
        list.insertAtLastPosition(2052);
        list.insertAtLastPosition(1989);
        list.insertAtLastPosition(202623);
        list.insertAtLastPosition(85232);
        list.insertAtLastPosition(3256);
        list.insertAtLastPosition(2007);
        list.insertAtLastPosition(223);
        System.out.println("Lista de enteros:");
        list.show();
    }

    /**
     * Método que prueba la LinkedList con Strings.
     * Crea una lista, inserta strings al final y muestra en consola.
     */
    public static void testStrings(LinkedList<String> list) {
        list.insertAtLastPosition("Hola");
        list.insertAtLastPosition("¿Cómo estas :)?");
        list.insertAtLastPosition("¿Bien y tu?");
        list.insertAtLastPosition("También");
        list.insertAtLastPosition("Que bueno");
        System.out.println("Lista de cadenas:");
        list.show();
    }

    /**
     * Método que prueba la LinkedList con objetos complejos (Contactos).
     * Crea varios contactos, los inserta al final de la lista y muestra la lista en consola.
     */
    public static void testComplexObjects(LinkedList<Contacto> list) {
        list.insertAtLastPosition(new Contacto("Armando Betancourt", "Av. Del Valle, SPGG", "8146748463"));
        list.insertAtLastPosition(new Contacto("Karol Torres", "Av. Las Torres, MTY", "8145278536"));
        list.insertAtLastPosition(new Contacto("Andrea Gonzalez", "Paseo de las Americas, GPE", "6136236233"));
        list.insertAtLastPosition(new Contacto("Jose Ortiz", "Paseo de la Reforma, MX", "7543753474"));
        list.insertAtLastPosition(new Contacto("Angela Aguirre", "C. Saltillo, MX", "34547435734"));
        list.insertAtLastPosition(new Contacto("Arturo Conde", "Av. Gomez Morin, MTY", "437345753"));
        list.insertAtLastPosition(new Contacto("Mariana Mercurio", "Av. Constitución, MTY", "347345754"));
        list.insertAtLastPosition(new Contacto("Danna Paola", "Av. Insurgentes, MTY", "2452323223"));
        list.insertAtLastPosition(new Contacto("Ricardo Boone", "Av. McAllen, TX", "34734475453"));
        list.insertAtLastPosition(new Contacto("Gerardo Gonzalez", "Av. Boulevard de la Madrid", "734545453"));
        list.insertAtLastPosition(new Contacto("Gael Perez", "Av. Las Torres, MTY", "26374347"));
        System.out.println("Lista de objetos tipo complejos / CONTACTOS /:");
        list.show();
    }
}
