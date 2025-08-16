/**
 * Autor: Armando Betancourt Esparza
 * Fecha: 15/08/2025
 * Descripción: Esta clase sirve para probar todos los tipos de datos en listas enlazadas:
 * primitivos (int), cadenas (String) y objetos complejos (Contactos)
 * Ahora los elementos se insertan en orden de izquierda a derecha, como nodos conectados
 */

package DataStructure.LinkedList;

public class DataTypeExamples {

    /**
    * Agrega elemntos a la lista con algunos enteros de ejemplo y los muestra por consola
    * @param list lista enlazada de enteros a poblar
    */
    public static void testIntegers(LinkedList<Integer> list) {
        list.insertAtLastPosition(4);
        list.insertAtLastPosition(19);
        list.insertAtLastPosition(27);
        System.out.println("Lista de enteros (IZQ -> DER):");
        list.show();
    }

    /**
     * Agrega elemntos  con objetos complejos de tipo {@link Contacto} y los muestra.
     * Cada contacto incluye nombre, dirección y teléfono.
     * 
     * @param list lista enlazada de objetos Contacto a poblar
     */
    public static void testComplexObjects(LinkedList<Contacto> list) {
        list.insertAtLastPosition(new Contacto("Armando Betancourt", "Av. Del Valle, SPGG", "8146748463"));
        list.insertAtLastPosition(new Contacto("Karol Torres", "Av. Las Torres, MTY", "8145278536"));
        list.insertAtLastPosition(new Contacto("Andrea Gonzalez", "Paseo de las Americas, GPE", "6136236233"));
        System.out.println("Lista de objetos complejos / CONTACTOS / (IZQ -> DER):");
        list.show();
    }
}
