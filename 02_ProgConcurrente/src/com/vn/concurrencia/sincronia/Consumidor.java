package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {

    private Contenedor contenedor;

    public Consumidor(Contenedor c) {
        contenedor = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = 0;
            value = contenedor.get();
            System.out.println("Consumidor. GET: " + value);
        }
    }
}
