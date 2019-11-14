/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author pc
 */
public class SetHilos {

    private final Set<Runnable> HILOS_AB = new HashSet<>();
    // No se puede usar por que una vez terminados los hilos no se pueden
    // reutilizar, debemos crearlos nuevamente
//    private final Set<Thread> THREADS = new HashSet<>();

    public void crearHilos(int numHilos, int numIteraciones) {
        for (int i = 0; i < numHilos; i++)
            HILOS_AB.add(new HiloA(i, numIteraciones));
    }

    public void ejecutarConHilos() throws InterruptedException {
        Set<Thread> threads = new HashSet<>();
        for (Runnable hiloAB : HILOS_AB) 
            threads.add(new Thread(hiloAB));
        
        for (Thread hilo : threads) 
            hilo.start();
        
        // Une la ejecución al hilo principal
//        for (Thread hilo : threads) 
//            hilo.join();

        for (Thread thread : threads)
            while (thread.isAlive());
        
    }

    public void ejecutarSinHilos() {
        for (Runnable hilo : HILOS_AB)
            hilo.run();
    }

    class HiloA implements Runnable {

        private int id;
        private int iteraciones;

        public HiloA(int id, int iteraciones) {
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
    
    class HiloB implements Runnable {

        private int id;
        private int iteraciones;

        public HiloB(int id, int iteraciones) {
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
