/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pc
 */
public class SetHilos {

    private final Set<Thread> HILOS = new HashSet<>();

    public void crearHilos(int numHilos, int numIteraciones) {
        for (int i = 0; i < numHilos; i++)
            HILOS.add(new Thread(new Hilo(i, numIteraciones)));
    }

    public void ejecutarConHilos() throws InterruptedException {
        for (Thread hilo : HILOS) 
            hilo.start();
        
        // Esperamos a que terminen todos los hilos
//        for (Thread hilo : HILOS) 
//            hilo.join();

        for (Thread thread : HILOS)
            while (thread.isAlive());
        
    }

    public void ejecutarSinHilos() {
        for (Thread hilo : HILOS)
            hilo.run();
    }

    class Hilo implements Runnable {

        private int id;
        private int iteraciones;

        public Hilo(int id, int iteraciones) {
            this.id = id;
            this.iteraciones = iteraciones;
        }

        @Override
        public void run() {
                for (int i = 0; i < iteraciones; i++) {
                    if (i % 10 == 0) 
                        System.out.println(this + " iteración " + i);
            }
        }

        @Override
        public String toString() {
            return "Soy el hilo " + id;
        }
    }
}
