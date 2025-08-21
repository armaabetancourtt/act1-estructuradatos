/**
 * Autor: Armando Betancourt Esparza
 * Fecha: 20/08/2025
 * Descripción: Esta clase sirve que gestione los programas en ejecución asegurando que se procesen en el orden de llegada
*/
package DataStructure.Queue;
import DataStructure.LinkedList.LinkedList;
/**
 *
 * @author abeta
 */
/**
 * Autor: abeta
 * Cola genérica usando LinkedList
 */
public class Queue<E> {
    private LinkedList<E> list;

    public Queue() {
        list = new LinkedList<>(false, false); // simple
    }

    /** Agrega un elemento al final de la cola */
    public void enqueue(E data) {
        list.insertAtLastPosition(data);
    }

    /** Elimina y retorna el primer elemento de la cola */
    public E dequeue() {
        if (!isEmpty()) {
            return list.removeFirst(); // <--- cambio aquí
        }
        throw new IllegalStateException("La cola está vacía.");
    }

    /** Retorna el primer elemento sin eliminar */
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("La cola está vacía.");
        return list.iterator().next();
    }

    /** Verifica si la cola está vacía */
    public boolean isEmpty() {
        return !list.iterator().hasNext();
    }

    /** Muestra la cola */
    public void show() {
        list.show();
    }
}
