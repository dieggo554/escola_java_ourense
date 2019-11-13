/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

/**
 *
 * @author pc
 */
public class HilosSencillos {

    static int contadorCompartido = 0;

    HiloA hiloA1, hiloA2;
    HiloB hiloB1, hiloB2;

    public HilosSencillos() {
        hiloA1 = new HiloA();
        hiloB1 = new HiloB();
        hiloA2 = new HiloA();
        hiloB2 = new HiloB();
    }

    class HiloA implements Runnable {

        @Override
        public void run() {
            // El contador principal, j, en variable local
            for (int i = 0; i < 500000; i++) {
                contadorCompartido++;
                if ( i % 1000 == 0 )
                    System.out.println("Instrucción A:   " + i
                            + " - contador = " + contadorCompartido);
            }
        }
    }

    class HiloB implements Runnable {

        @Override
        public void run() {
            for (int j = 0; j < 500000; j++) {
                contadorCompartido++;
                if ( j % 1000 == 0 )
                    System.out.println("-> Ins B:" + j
                            + ", c = " + contadorCompartido);
            }
        }
    }

    public void ejecutarHilosStartABenParalelo() {
        System.out.println("\n*** THREAD - START ***\n");
        
        Thread threadHiloA1 = new Thread(hiloA1);
        Thread threadHiloB1 = new Thread(hiloB1);
//        Thread threadHiloA2 = new Thread(hiloA2);
//        Thread threadHiloB2 = new Thread(hiloB2);
        
        threadHiloA1.start();
        threadHiloB1.start();
//        threadHiloA2.start();
//        threadHiloB2.start();
        while (threadHiloA1.isAlive() || threadHiloB1.isAlive() );
//                || threadHiloA2.isAlive() || threadHiloB2.isAlive());
        
        System.out.println("\n*** END - START ***\n");
    }
    
    public void ejecutarHilosRunABenSerie() {
        System.out.println("\n--- THREAD - RUN ---\n");
        // SIN HILOS, ejecutamos uno detrás de otro
        hiloA1.run();
        hiloB1.run();
//        hiloA2.run();
//        hiloB2.run();
        
        System.out.println("\n--- END - RUN ---\n");
        
    }
}
