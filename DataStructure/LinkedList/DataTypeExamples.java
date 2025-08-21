/**
 * Autor: Armando Betancourt Esparza
 * Fecha: 20/08/2025
 * Descripción: Esta clase sirve para probar todos los tipos de datos con comandos de pila y cola de procesos
 * Ahora los elementos se insertan en orden de izquierda a derecha, como nodos conectados
 */

package DataStructure.LinkedList;

import DataStructure.Queue.Queue;
import DataStructure.Stack.Stack;

public class DataTypeExamples {


    /** Llena la pila de comandos con datos de ejemplo
     * @param stack */
    public static void testStack(Stack<String> stack) {
        stack.push("mkdir carpeta");
        stack.push("pythonc miprograma.py");
        stack.push("javac tareaestructuras.java");
    }

    /** Llena la cola de procesos con datos de ejemplo
     * @param queue */
    public static void testQueue(Queue<String> queue) {
        queue.enqueue("Opera GX");
        queue.enqueue("Apple Music");
        queue.enqueue("GitHub Desktop");
    }
}
