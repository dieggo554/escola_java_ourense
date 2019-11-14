package com.vn.concurrencia.sincronia;

public class Contenedor {
    // Normalmente será un array, lista, bb.dd., 
    // mapa, fichero, DAO, servicio web, cualquier recurso compartido...
    int dato;
    
    public int get() {
        return dato;
    }
    public void put(int valor) {
        dato = valor;
    }
}
