/**
 * Autor: Armando Betancourt Esparza
 * Fecha: 20/08/2025
 * Descripción: Esta clase sirve que gestione un historial de comandos ejecutados, permitiendo revisar o deshacer el último comando
*/
package DataStructure.Stack;
import DataStructure.LinkedList.LinkedList;
/**
 *
 * @author abeta
 */
/**
 * Autor: abeta
 * Pila genérica usando LinkedList
 */
public class Stack<E> {
    private LinkedList<E> list;

    public Stack() {
        list = new LinkedList<>(false, false); // simple
    }

    /** Agrega un elemento al tope */
    public void push(E data) {
        list.insertAtFirstPosition(data);
    }

    /** Elimina y retorna el elemento del tope */
    public E pop() {
        if (!isEmpty()) {
            return list.removeFirst(); // <--- cambio aquí
        }
        throw new IllegalStateException("La pila está vacía.");
    }

    /** Retorna el elemento del tope sin eliminar */
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("La pila está vacía.");
        return list.iterator().next();
    }

    /** Verifica si la pila está vacía */
    public boolean isEmpty() {
        return !list.iterator().hasNext();
    }

    /** Muestra la pila */
    public void show() {
        list.show();
    }
}
