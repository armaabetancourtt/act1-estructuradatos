/**
* Autor: Armando Betancourt Esparza
* Fecha: 14/08/2025
* Descripción: Clase que representa objetos de contacto, donde se almacena la información y definen constructores.
**/

package DataStructure.LinkedList;

/**
 * Clase Contacto que representa un contacto con nombre, dirección y teléfono.
 * Esta clase sirve como ejemplo de objeto complejo para probar la LinkedList.
 */
public class Contacto {
        String nombre;
        String direccion;
        String telefono;
            
        /**
        * Constructor que inicializa un contacto con su nombre, dirección y teléfono.
        * @param nombre Nombre del contacto.
        * @param direccion Dirección del contacto.
        * @param telefono Teléfono del contacto.
        */

        public Contacto(String nombre, String direccion, String telefono) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.telefono = telefono;
        }

        // Getters y Setters
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getDireccion() { return direccion; }
        public void setDireccion(String direccion) { this.direccion = direccion; }

        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }

        @Override
        public String toString() {
            return nombre + " , " + direccion + " , " + telefono;
        }
}
