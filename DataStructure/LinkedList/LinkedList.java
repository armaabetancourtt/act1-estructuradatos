/**
 * Autor: Armando Betancourt Esparza
 * Fecha: 20/08/2025
 * Descripción: LinkedList sirve para almacenar datos en nodos con propiedades dobles y circulares
 */
package DataStructure.LinkedList;

import DataStructure.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedList genérica (simple / doble / circular)
 *
 * @param <E> Tipo de dato a almacenar en la lista
 */
public class LinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private final boolean isDoubly;
    private final boolean isCircular;

    /**
     * Crea una nueva LinkedList.
     *
     * @param isDoubly  true si será doblemente enlazada
     * @param isCircular true si será circular
     */
    public LinkedList(boolean isDoubly, boolean isCircular) {
        this.isDoubly = isDoubly;
        this.isCircular = isCircular;
        head = null;
        tail = null;
    }

    /** Inserta un nodo al inicio de la lista */
    public void insertAtFirstPosition(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) { 
            head = tail = newNode;
            if (isCircular) {
                head.setNext(head);
                if (isDoubly) head.setPrev(head);
            }
            return;
        }

        newNode.setNext(head);
        if (isDoubly) {
            newNode.setPrev(isCircular ? tail : null);
            head.setPrev(newNode);
        }
        if (isCircular) {
            tail.setNext(newNode);
        }
        head = newNode;
    }

    /** Inserta un nodo al final de la lista */
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

        newNode.setPrev(isDoubly ? tail : null);
        if (isCircular) {
            newNode.setNext(head);
            tail.setNext(newNode);
            if (isDoubly) head.setPrev(newNode);
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    /** Elimina un elemento por valor */
    public boolean remove(E data) {
        if (head == null) return false;
        Node<E> current = head;
        Node<E> prevNode = null;

        do {
            if ((current.getData() == null && data == null) || 
                (current.getData() != null && current.getData().equals(data))) {

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
                    if (tail != null) {
                        tail.setNext(isCircular ? head : null);
                        if (isDoubly && isCircular) head.setPrev(tail);
                    }
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

    /** Elimina el primer nodo y devuelve su valor */
    public E removeFirst() {
        if (head == null) throw new IllegalStateException("La lista está vacía");
        E data = head.getData();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            if (isDoubly) head.setPrev(isCircular ? tail : null);
            if (isCircular) tail.setNext(head);
        }
        return data;
    }

    /** Elimina el último nodo y devuelve su valor */
    public E removeLast() {
        if (tail == null) throw new IllegalStateException("La lista está vacía");
        E data = tail.getData();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(isCircular ? head : null);
            }
            if (isDoubly && isCircular) head.setPrev(tail);
        }
        return data;
    }

    /** Verifica si la lista contiene un elemento */
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
            if ((current.getData() == null && data == null) || 
                (current.getData() != null && current.getData().equals(data))) return index;
            current = current.getNext();
            index++;
        } while ((isCircular && current != head) || (!isCircular && current != null));
        return -1;
    }

    /** Muestra la lista por consola */
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

    /** Permite recorrer la lista con for-each */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            private boolean first = true;

            @Override
            public boolean hasNext() {
                if (current == null) return false;
                return isCircular ? first || current != head : current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E data = current.getData();
                current = current.getNext();
                first = false;
                return data;
            }
        };
    }
}
