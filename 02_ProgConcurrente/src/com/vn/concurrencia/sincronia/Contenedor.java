package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

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

    public synchronized int get() {
        // Devemos utilizar WHILE por que puede haber
        // un notify o notifyAll que no sea el correspondiente
        while (!hayDato) 
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }

        hayDato = false;            // Marcamos para bloquear el recurso antes de devolver
        System.out.println("GET: " + dato);
        this.notifyAll();

        return dato;                // Devolver el dato
    }

    public synchronized void put(int valor) {

        while (hayDato)
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }

        dato = valor;               // Almacenar el dato
        hayDato = true;             // Marcamos para liberar el recurso
        System.out.println("PUT: " + dato);

        notifyAll();
    }
}