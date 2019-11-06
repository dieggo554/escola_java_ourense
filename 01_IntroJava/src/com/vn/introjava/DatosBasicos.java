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
public class DatosBasicos {
    
    public static void mostrarTiposDatos() {
        System.out.println("Tipos de datos");

        byte unByte = -128;
        System.out.println("Byte: " + unByte); // (-129,0,127)

        int unEntero = 2000000000; // 4 bytes
        long enteroLargo = 300000000L; // 8 bytes
        System.out.println("Entero: " + unEntero); // -2000000000 o -2^-31,2000000000 o 2^31 aprox.
        System.out.println("Entero Largo: " + enteroLargo); // (-2^-63, 2^63)

        float unDecimal = 1.23456789f; // 4 bytes
        float otroDecimal = 123456789123456789f;
        double decimalDoblePrec = 3.3d; // 8 bytes
        System.out.println("Decimal: " + unDecimal); // redondea, perdemos precisión, 1 byte para exponente, -129 a 127 y 3 bytes para mantisa, aprox. 7 u 8 difras mantisa
        System.out.println("Otro Decimal: " + otroDecimal);
        System.out.println("Decimal doble precisión: " + decimalDoblePrec); // aprox. 15 ó 16 cifras mantisa

        boolean condicion = true; // 1 byte, se pueden guardar varios en un mismo byte
        System.out.println("Condicion: " + condicion);

        char unCaracter = 'A'; // 2 bytes por el formato UNICODE
        char unCharEntero = 2001; // coge el código ASCII/UNICODE
        System.out.println("Carácter en nº: " + (int) unCaracter);
        System.out.println("Carácter en char: " + unCharEntero);

        String unTexto = "Que esto es un txt";
        System.out.println("Cadena: " + unTexto);
        System.out.println("Concatenado: " + unTexto.concat(" concatenado"));
        System.out.println("En mayúsculas: " + unTexto.toUpperCase());
    }
    
    public static void probarOperadores(){
        // Operadores unarios (se ejecuta sobre UNA expresión):
        System.out.println("Negación: " + ! true);
        System.out.println("Negativo: " + - (10 + 5));
        //  Conversiones explícitas
        System.out.println("Casting: " + (float) 3.34343434343434); // Perdemos precisión adrede
        System.out.println("Casting: " + (int) 334343434343434L);
        int contador /*;
        contador */ = 10;
        System.out.println("Incremento: " + contador++); //Primero se evalua la expresión
        System.out.println("Incremento: " + ++contador); //Primero se evalua el incremento
        
        // Operadores binarios (dos operados)
        //  Parentesis, suma y conversión implícita
        System.out.println("Suma y div: " + (6 + 5) / 2); // Trunca y devulve un valor entero
        System.out.println("Suma y div: " + (6 + 5) / /*(float)*/ 2f); // Convirtiendo cualquiera a float/double ya no lo hace
        System.out.println("Resto div entera: " + 11 % 3);
        
        // Operadores booleanos
        System.out.println("Es cierto?: " + (true && true)); // AND
        System.out.println("Es cierto?: " + (true || true)); // OR
        // Igualdad y similares
        System.out.println("Es cierto?: " + (5 == 5 || 5 > 9)); // OR
        System.out.println("Es cierto?: " + (5 != 5 && 5 <= 9)); // Operador distinto
        
        // Operaciones bit a bit
        //  00010101 = 21
        //  00000111 =  7
        //  --------
        //  00000101 =  5   AND
        //  00010111 = 23   OR
        //  00010010 = 18   XOR
        System.out.println("Op. binario 21 AND 7: " + (21 & 7));
        System.out.println("Op. binario 21 OR 7: " + (21 | 7));
        System.out.println("Op. binario 21 XOR 7: " + (21 ^ 7));
    }
}
