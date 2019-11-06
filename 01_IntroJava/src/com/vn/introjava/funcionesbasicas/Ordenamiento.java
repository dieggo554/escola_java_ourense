/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.funcionesbasicas;

/**
 *
 * @author pc
 */
public class Ordenamiento {
    
    public static int[] ordenarArray(int[] array) {
        int[] arrOrd = {};
        if (array != null && array.length > 0) {
            arrOrd = new int[ array.length ];

            int inicio = 0;
            int menor, posMenor; // -Integer.MAX_VALUE; podríamos inicializarlo al valor máximo
            do {
                menor = array[inicio];
                posMenor = inicio;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] < menor) {
                        menor = array[i];
                        posMenor = i;
                    }
                }
                array[posMenor] = Integer.MAX_VALUE;
                arrOrd[inicio] = menor;
                inicio++;
                System.out.println("Menor: " + menor);
            } while (inicio < array.length);
        }
        return arrOrd;
    }
    
    public static int[] ordenarArrayConBurbuja(int array[]) {
        // Declarar array enteros
        // Programa todo lo que haga falta para ordenarlo
        
        if (array == null) return new int[] {};
        
        int num;
        int iterations = 0;
//        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            for (int y = 0; y < array.length; y++){
                iterations += 1;
                if (array[i] < array[y]) {
                    num = array[i];
                    array[i] = array[y];
                    array[y] = num;
//                    contador++;
                }
            }
        }
        return array;
    }
    
    public static int[] ordenarArrayConBurbujaOptimizada(int array[]) {
        if (array == null) return new int[] {};
        int num;
        for (int i = array.length -1; i > 0; i--) {
            for (int y = 0; y < i; y++){
                if (array[y] > array[y+1]) {
                    num = array[y];
                    array[y] = array[y+1];
                    array[y+1] = num;
                }
            }
        }
        mostrarArray(array, -1);
        return array;
    }

    public static void mostrarArray(int[] array, int iterations) {
        for (int i : array)
            System.out.print(i + " ");
        System.out.println("- Iteraciones: " + iterations);
    }
}
