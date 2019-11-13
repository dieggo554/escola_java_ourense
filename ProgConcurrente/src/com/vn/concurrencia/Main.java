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
public class Main {
    public static void main(String[] args) {
        // Con dos hilos es igual a no crear hilos, con más, es más LENTO (PC Clase)
        HilosSencillos hs = new HilosSencillos();
        
        long timeInt = System.currentTimeMillis();
        hs.ejecutarHilosRunABenSerie();
        String m1 = calcularTiempo(timeInt, "Run en Serie ha tardado: ");
        
        timeInt = System.currentTimeMillis();
        hs.ejecutarHilosStartABenParalelo();
        String m2 = calcularTiempo(timeInt, "Run en Paralelo ha tardado: ");
        
        System.out.println(m1);
        System.out.println(m2);
    }
    
    static String calcularTiempo (long timeInicial, String mensaje) {
        // Primero hacemos la resta para trabajar con numeros pequeños
        // para poder convertirlo en double sin perder precisión desde el long
        // double = 1bit signo + 11 bits expontente + 52 mantisa
        // long =   1bit signo + 53 mantisa
        double tiempoTotal = (double)(System.currentTimeMillis() - timeInicial) / 1000f;
        String mensajeRet = mensaje + tiempoTotal;
        return mensajeRet;
    }
}
