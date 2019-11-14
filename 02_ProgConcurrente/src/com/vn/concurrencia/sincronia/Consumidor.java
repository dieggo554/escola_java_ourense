package com.vn.concurrencia.sincronia;

public class Consumidor {

    private Contenedor contenedor;

    public Consumidor(Contenedor c) {
        contenedor = c;
    }

    public void consumir() {
        int value = 0;
        
        value = contenedor.get();
        
        System.out.println("Consumidor. GET: " + value);
    }
}
