/**
* Autor: Armando Betancourt Esparzaa
* Fecha: 14/08/2025
* Descripción: Esta clase representa un nodo de listas entrelazadas, a mi propio razionamiento es una manera 
* más eficiente que estoy usando para guardar cualquier tipo de dato (Gracias a <E>), formando una lista de nodos,
* donde si next es nulo el programa interpreta que es el último de la lista de nodos, uso constructores para crear
* un nodo con dato y así asignarlo a otro (como una cadena de nodos o "vagones" de tren) e integro métodos para
* devolver o cambiar el número o dato que esta guardando el nodo.
**/

package act1estructuradatos;

/**
 * Constructor que crea un nodo con un dato y una referencia al siguiente nodo.
 * @param data Valor que se almacenará en el nodo.
 * @param next Referencia al siguiente nodo de la lista (puede ser null).
 */

//Definición de clase Node: Es un nodo en una lista entrelazada

public class Node <E> {
    //Atributos
    private E data;
    Node next;
    
    //Constructores
    public Node (E data, Node next) {
        this.data=data;
        this.next=next;
    }
    
    public Node (E data) {
        this.data=data;
        this.next=null;
    }
    //Getter
    public E getData() {
        return data;
    }
    //Setters
    public void setData (E data){
        this.data=data;
    }
    public Node<E> next() {
        return next;
    }

    public void setNext (Node<E> next) {
        this.next=next;
    }
}

