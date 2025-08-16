/**
 * Autor: Armando Betancourt Esparza
 * Fecha: 14/08/2025
 * Descripción: Nodo para listas enlazadas, su función es ser la base para la construcción de las listas entrelazadas
 * 
 */
package DataStructure;

public class Node<E> {
    /** Dato almacenado en el nodo y referencias al siguiente y previo nodo */
    private E data;
    Node<E> next;
    Node<E> prev;

    /**
     * Constructor que inicializa un nodo con un dato
     * Las referencias al siguiente y al anterior nodo inician en en null
     *
     * @param data El dato que guardará el nodo.
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * Obtiene el dato guardado en el nodo
     *
     * @return El dato del nodo
     */
    public E getData() {
        return data;
    }

    /**
     * Establece o actualiza el dato almacenado en el nodo
     *
     * @param data - El nuevo dato a almacenar
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Obtiene la referencia al siguiente nodo
     *
     * @return El nodo siguiente, o null si no existe.
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Establece la referencia al siguiente nodo
     *
     * @param next El nodo siguiente
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**
     * Obtiene la referencia al nodo anterior (solo aplica para listas dobles)
     *
     * @return El nodo anterior, o da como resultado null si no exist
     */
    public Node<E> getPrev() {
        return prev;
    }

    /**
     * Establece (Set) la referencia al nodo anterior (solo para listas dobles)
     *
     * @param prev El nodo anterior
     */
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
