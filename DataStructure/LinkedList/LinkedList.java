/**
 * Autor: Armando Betancourt Esparza
 * Fecha: 14/08/2025
 * Descripción: LinkedList sirve para almacenar datos, gestionar elementos contados en nodos, 
 * además de ser la clase que permite las operaciones como insertar en ult o primera posición
 * 
 */
package DataStructure.LinkedList;

import DataStructure.Node;

/**
* LinkedList genérica (simple / doble / circular)
*/
public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private boolean isDoubly;
    private boolean isCircular;

    public LinkedList(boolean isDoubly, boolean isCircular) {
        this.isDoubly = isDoubly;
        this.isCircular = isCircular;
        head = null;
        tail = null;
    }

    /** Comparador interno: si son Contacto compara por nombre (ignorando mayúsculas/espacios),
    *  si no, usa equals normal. */
    private boolean dataEquals(E a, E b) {
        if (a == b) return true;           // misma referencia o ambos null
        if (a == null || b == null) return false;
        if (a instanceof Contacto && b instanceof Contacto) {
            String na = ((Contacto) a).getNombre().trim().toLowerCase();
            String nb = ((Contacto) b).getNombre().trim().toLowerCase();
            return na.equals(nb);
        }
        return a.equals(b);
    }

    /** Inserta al inicio */
    public void insertAtFirstPosition(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) { // lista vacía
            head = tail = newNode;
            if (isCircular) {
                head.setNext(head);
                if (isDoubly) head.setPrev(head);
            }
            return;
        }

        if (isCircular) {
            newNode.setNext(head);
            if (isDoubly) {
                newNode.setPrev(tail);
                head.setPrev(newNode);
                tail.setNext(newNode);
            } else {
                tail.setNext(newNode);
            }
            head = newNode;
        } else {
            newNode.setNext(head);
            if (isDoubly) head.setPrev(newNode);
            head = newNode;
        }
    }

    /** Inserta al final */
    public void insertAtLastPosition(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
            if (isCircular) {
                head.setNext(head);
                if (isDoubly) head.setPrev(head);
            }
            return;
        }

        if (isCircular) {
            newNode.setNext(head);
            if (isDoubly) {
                newNode.setPrev(tail);
                tail.setNext(newNode);
                head.setPrev(newNode);
            } else {
                tail.setNext(newNode);
            }
            tail = newNode;
        } else {
            tail.setNext(newNode);
            if (isDoubly) newNode.setPrev(tail);
            tail = newNode;
        }
    }

    /** Elimina un elemento */
    public boolean remove(E data) {
        if (head == null) return false;
        Node<E> current = head;
        Node<E> prevNode = null;

        do {
            if (dataEquals(current.getData(), data)) {
                if (current == head && current == tail) {
                    head = tail = null;
                    return true;
                }
                if (current == head) {
                    head = head.getNext();
                    if (isDoubly && head != null) head.setPrev(isCircular ? tail : null);
                    if (isCircular && tail != null) tail.setNext(head);
                    return true;
                }
                if (current == tail) {
                    tail = prevNode;
                    if (tail != null) tail.setNext(isCircular ? head : null);
                    if (isDoubly && head != null) head.setPrev(isCircular ? tail : null);
                    return true;
                }
                prevNode.setNext(current.getNext());
                if (isDoubly && current.getNext() != null) current.getNext().setPrev(prevNode);
                return true;
            }
            prevNode = current;
            current = current.getNext();
        } while ((isCircular && current != head) || (!isCircular && current != null));

        return false;
    }

    /** Verifica si contiene un elemento */
    public boolean contains(E data) {
        return indexOf(data) != -1;
    }

    /**
     * Devuelve la posición (0-based) de un elemento en la lista.
     * Si no lo encuentra, regresa -1.
     */
    public int indexOf(E data) {
        if (head == null) return -1;
        Node<E> current = head;
        int index = 0;
        do {
            if (dataEquals(current.getData(), data)) {
                return index;
            }
            current = current.getNext();
            index++;
        } while ((isCircular && current != head) || (!isCircular && current != null));
        return -1;
    }

    /** Muestra la lista */
    public void show() {
        if (head == null) {
            System.out.println("Lista vacía");
            return;
        }

        System.out.print("De izquierda a derecha: ");
        Node<E> current = head;
        if (isCircular) {
            do {
                System.out.print(current.getData() + " -> ");
                current = current.getNext();
            } while (current != head);
            System.out.println("(vuelve a inicio)");
        } else {
            while (current != null) {
                System.out.print(current.getData() + " -> ");
                current = current.getNext();
            }
            System.out.println("null");
        }

        if (isDoubly) {
            System.out.print("De derecha a izquierda: ");
            current = tail;
            if (isCircular) {
                do {
                    System.out.print(current.getData() + " <- ");
                    current = current.getPrev();
                } while (current != tail);
                System.out.println("(vuelve a fin)");
            } else {
                while (current != null) {
                    System.out.print(current.getData() + " <- ");
                    current = current.getPrev();
                }
                System.out.println("null");
            }
        }
    }
}
