/**
* Autor: Armando Betancourt Esparza
* Fecha: 14/08/2025
* Descripción: La clase LinkedList es la que gestionará las operaciones en la lista como consulta de datos (métodos como isEmpty)
* el agregar, eliminar y ver en consola, en otras palabras, gestiona lo de la lista entrelazada.
**/

package listas;

    /**
     * Constructores, Definición de clase LinkedList y Encapsulamiento
     * @param firstNode Primer nodo de la lista
    */
public class LinkedList <E> {
    private Node<E> firstNode;
    
    public LinkedList() {
        this.firstNode=null;
    }
    
    public LinkedList (Node<E> firstNode) {
        this.firstNode = firstNode;
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
        Node nodeToInsert = new Node<>(data);
        nodeToInsert.next = firstNode;
        firstNode = nodeToInsert;
    }
    
    /**
     * Es el método que permite mostrar en el output o consola la lista
    */
    
     public void show() {
        //Es el nodo que recorre la lista
         Node currentNode = this.firstNode;
        //Si no encuentra final, muestra el valor actual del nodo
        while (currentNode != null) {
            System.out.println(currentNode.getData()); // Imprime cada nodo en una línea
            currentNode = currentNode.next();
        }
        System.out.println("null"); //Lo programe para que imprimiera null cuando terminará la lista
    }

    /**
     * Poner un valor en la posición final
     * @param data (dato) por insertar
    */
    public void insertAtLastPosition(E data) {
        if (this.isEmpty()) { //Si la lista está vacía
            insertAtFirstPosition(data);
            return;
        }
        Node<E> currentNode = firstNode;
        while (currentNode.next() != null) {
            currentNode = currentNode.next();
        }
        currentNode.setNext(new Node<>(data));
    }
    
    /**
     * Remueve la primera aparición de un dato en la lista
     * @param data (dato) a eliminar
     * @return true si se pudo eliminar o false si no se encontro y por ende no fue eliminado
    */
    public boolean remove(E data) {
        if (firstNode == null) return false; //Para lista vacia

        if (firstNode.getData().equals(data)) {
            firstNode = firstNode.next();
            return true;
        }
        //El programa busca en el resto de la lista
        Node<E> current = firstNode;
        while (current.next() != null) {
            if (current.next().getData().equals(data)) {
                current.setNext(current.next().next());
                return true;
            }
            current = current.next();
        }
        return false;
    }
    
    /**
     * Verifica si un dato está en la lista
     * @param data (dato) es lo que se esta bucando
     * @return true si el dato se encontró, false si el dato no se encontró
    */
    public boolean contains(E data) {
        Node<E> current = firstNode;
        while (current != null) {
            if (current.getData().equals(data)) return true; //Para encontrado
            current = current.next();
        }
        return false; //Para no encontrado
    }

}
