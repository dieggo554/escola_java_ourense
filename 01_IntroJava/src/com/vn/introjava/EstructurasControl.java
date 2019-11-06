/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

/**
 *
 * @author pc
 */
public class EstructurasControl {
    
    public static void ejecutarBucles() {
        char arrayChar[] = {'a', 'B', '8', '*'};
        int index = 0;
        while (index < arrayChar.length) {
            System.out.println("Index = " + index + ", char " + arrayChar[index]);
            index++;
        }

        for (/* ini */ index = 0;/* cond */ index < arrayChar.length;/* inc */ index++) 
            System.out.println("Index = " + index + ", char " + arrayChar[index]);
        

        index = 0;
        do {
            System.out.println("Index = " + index + ", char " + arrayChar[index]);
            index++;
        } while (index < arrayChar.length);

        for (char caracter : arrayChar) {
            System.out.println("Char " + caracter);
        }
    }

    public static void ejecutarCondiciones() {
        // Condicional simple
        if ("Palabra".length() > 5) {
            System.out.println("Palabra larga");
        }

        //Codicionales compuestos
        if ("Texto".length() > 5) {
            System.out.println("Por aquí no entra");
        } else {
            System.out.println("Palabra corta");
        }
        
        if ("En un lugar de la mancha...".contains("LUGAR")) 
            System.out.println("Tiene LUGAR");
        else if ("En un lugar de la mancha...".contains("MANCHA")) {
            // Bloque vacío
        } else if ("En un lugar de la mancha...".contains("OTRO")) {
            System.out.println("Tiene OTRO");
        } else {
            System.out.println("No tiene ninguno porque estan en mayúsculas");
        }
        
        int numeroPeq = 0;
        switch (numeroPeq + 5 - 5) /* numeros, enumerados y cadena de txt */ {
            case 0:
                System.out.println("Num peq vale cero.");
                break;
            case 1:
                System.out.println("Num peq vale uno.");
                break;
            case 2:
            case 3:
            case 4:
                System.out.println("Num peq vale dos, tres o cuatro.");
                break;
            default:
                System.out.println("Es otro número (< 0 o > 4).");
        }
    }
}
