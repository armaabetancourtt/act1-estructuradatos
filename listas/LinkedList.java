/**
* Autor: Armando Betancourt Esparza
* Fecha: 14/08/2025
* Descripción: La clase LinkedList es la que gestionará las operaciones en la lista como consulta de datos (métodos como isEmpty)
* el agregar, eliminar y ver en consola, en otras palabras, gestiona lo de las lista entrelazada.
**/

package listas;

    /**
     * Constructores, Definición de clase LinkedList y Encapsulamiento
     * @param firstNode Primer nodo de la lista
     * @param isDoubly true si la lista es doblemente enlazada, false si es simple
     * @param isCircular true si la lista es circular, false si no lo es
    */
public class LinkedList <E> {
    private Node<E> firstNode;
    private boolean isDoubly;
    private boolean isCircular;
    
    public LinkedList(boolean isDoubly, boolean isCircular) {
        this.firstNode=null;
        this.isDoubly = isDoubly;
        this.isCircular = isCircular;
    }
    
    /**
     * Getter
     * @return firstNode.
    */
    public Node<E> getFirstNode() {
        return firstNode;
    }
    
    /**
     * Verifica (booleano) si la lista está vacía
     * @return true si no hay, false si se detecta uno o más
    */
    public boolean isEmpty() {
        return firstNode == null;
    }
    
    /**
     * Poner un valor en la posición inicial
     * @param data (dato) por insertar
    */
    public void insertAtFirstPosition(E data) {
    Node<E> newNode = new Node<>(data);
    if (isEmpty()) {
        firstNode = newNode;
        if (isDoubly) firstNode.setPrev(null);
        if (isCircular) newNode.setNext(firstNode);
    } else {
        newNode.setNext(firstNode);
        if (isDoubly) firstNode.setPrev(newNode);
        firstNode = newNode;

        if (isCircular) {
            Node<E> tail = firstNode;
            while (tail.getNext() != null && tail.getNext() != firstNode) tail = tail.getNext();
            tail.setNext(firstNode);
        }
    }
}

    /**
     * Poner un valor en la posición final
     * @param data (dato) por insertar
    */
    public void insertAtLastPosition(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            insertAtFirstPosition(data);
            return;
        }

        Node<E> currentNode = firstNode;
        while (currentNode.getNext() != null && (!isCircular || currentNode.getNext() != firstNode)) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(newNode);
        if (isDoubly) newNode.setPrev(currentNode);
        if (isCircular) newNode.setNext(firstNode);
    }
    

    
    /**
     * Es el método que permite mostrar en el output o consola la lista
    */
    
     public void show() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        Node<E> currentNode = firstNode;
        do {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        } while (currentNode != null && (!isCircular || currentNode != firstNode));

        System.out.println(isCircular ? "(vuelve al inicio)" : "null");
    }

    
    /**
     * Remueve la primera aparición de un dato en la lista
     * @param data (dato) a eliminar
     * @return true si se pudo eliminar o false si no se encontro y por ende no fue eliminado
    */
    public boolean remove(E data) {
        if (firstNode == null) return false; // Para lista vacía

        if (firstNode.getData().equals(data)) {
            if (isCircular && firstNode.getNext() == firstNode) {
                firstNode = null;
            } else {
                firstNode = firstNode.getNext();
                if (isDoubly && firstNode != null) firstNode.setPrev(null);
                if (isCircular) {
                    Node<E> tail = firstNode;
                    while (tail.getNext() != null && tail.getNext() != firstNode) tail = tail.getNext();
                    if (tail != null) tail.setNext(firstNode);
                }
            }
            return true;
        }

        Node<E> current = firstNode;
        while (current.getNext() != null && (!isCircular || current.getNext() != firstNode)) {
            if (current.getNext().getData().equals(data)) {
                Node<E> toDelete = current.getNext();
                current.setNext(toDelete.getNext());
                if (isDoubly && toDelete.getNext() != null) toDelete.getNext().setPrev(current);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    /**
     * Verifica si un dato está en la lista
     * @param data (dato) es lo que se esta bucando
     * @return true si el dato se encontró, false si el dato no se encontró
    */
    public boolean contains(E data) {
        if (isEmpty()) return false;
        Node<E> current = firstNode;
        do {
            if (current.getData().equals(data)) return true; //Para no encontrado
            current = current.getNext();
        } while (current != null && (!isCircular || current != firstNode));
        return false;
    }

}
