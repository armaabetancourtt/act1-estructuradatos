# Instrucciones de Ejecución de los Paquetes de Java

Este README contiene las instrucciones para ejecutar el simulador de sistema operativo desarrollado en Java, utilizando estructuras de datos de **pila** (para historial de comandos) y **cola** (para ejecución de procesos) con listas ligadas.

---

## Paquete App - Simulador de Sistema Operativo

Este paquete contiene el programa principal que simula un sistema operativo básico:

- **Comandos → PILA** → historial de comandos (LIFO, último en entrar, primero en salir).  
- **Procesos → COLA** → ejecución en orden de llegada (FIFO, primero en entrar, primero en salir).

### Archivos
- `Main.java` → Programa principal con menú interactivo.

### Compilación
Abre una terminal en la carpeta `App` y ejecuta todos los siguientes archivos:

```bash
javac Main.java DataTypeExamples.java Stack.java Queue.java LinkedList.java
```
---
#(Los siguientes paquetes son de caracter informativo)
## Paquete DataStructure.LinkedList - Listas Enlazadas y Datos de Prueba
Este paquete contiene las clases de listas enlazadas y ejemplos de datos para inicializar pilas y colas.

### Archivos
- `LinkedList.java` → Implementación genérica de listas enlazadas.

- `DataTypeExamples.java` → Agrega datos de ejemplo a pilas (comandos) y colas (procesos).



---
## Paquete DataStructure.Stack - Pila (Stack)
Este paquete implementa la pila utilizada para el historial de comandos.

### Archivos
- `Stack.java` → Implementa una pila genérica usando LinkedList.


---

###Paquete DataStructure.Queue - Cola (Queue)
Este paquete implementa la cola utilizada para la ejecución de procesos.

## Archivos
- `Queue.java` → Implementa una cola genérica usando LinkedList.



