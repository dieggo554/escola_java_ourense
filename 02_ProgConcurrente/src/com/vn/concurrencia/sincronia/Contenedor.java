package com.vn.concurrencia.sincronia;

/** 
 * El sistema de bloqueo lo tiene que gestionar el recurso compartido.
 * 
 * @author pc
 */
public class Contenedor {
    // Normalmente será un array, lista, bb.dd., 
    // mapa, fichero, DAO, servicio web, cualquier recurso compartido...
    int dato;
    // Semáforo: false no se puede usar el recurso
    //           true si se puede usar
    boolean hayDato = false;
    
    public int get() {
        while (!hayDato) {          // Esperamos a que se produzca algún dato
            System.out.println("GET: Esperando, hay dato = " + hayDato);
        }         
        hayDato = false;            // Marcamos para bloquear el recurso antes de devolver
        return dato;                // Devolver el dato
    }
    public void put(int valor) {
        dato = valor;               // Almacenar el dato
        while (hayDato) {           // Esperamos a que se consuma el dato
            System.out.println("PUT: Esperando, hay dato = " + hayDato);
        }
        hayDato = true;             // Marcamos para liberar el recurso
    }
}
