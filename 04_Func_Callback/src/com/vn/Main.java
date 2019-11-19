/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn;

import com.vn.liboperaarrays.OperarArrays;
import com.vn.liboperaarrays.OperarArrays.FunCallbackOperarArrays;
import com.vn.liboperaarrays.OperarArraysObject;
import java.io.PrintStream;
import java.util.Arrays;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] array_A = {1, 2, 3, 4, 5};
        double[] array_B = {2, 3, 4, 5, 6};
        // Desde Java 8 permite las funciones callback
        // Vincula el método suma con el método operar del la interfaz
        double[] arraySumaAB = OperarArrays.operarArarys(array_A, array_B, Main::suma);
        double[] arrayMultiAB = OperarArrays.operarArarys(array_A, array_B, Main::multiplica);

        arrayEnTabla(System.out, arraySumaAB);
        arrayEnTabla(System.out, arrayMultiAB);

        FunCallbackOperarArrays divide = (double x, double y) -> {
            return x / y;
        };
        double[] arrayDivAB
                = OperarArrays.operarArarys(array_A, array_B, divide);

        arrayEnTabla(System.out, arrayDivAB);

        // Más utilizada
        double[] arrayRestaAB
                = OperarArrays.operarArarys(
                        array_A,
                        array_B,
                        (double x, double y) -> {
                            return x - y;
                        }
                );
        arrayEnTabla(System.out, arrayRestaAB);
    }

    public static double suma(double x, double y) {
        return x + y;
    }

    public static double multiplica(double x, double y) {
        return x * y;
    }

    public static void arrayEnTabla(PrintStream salida, double[] array) {

        String tabla = "<table border=2><tr>\n";
        for (int i = 0; i < array.length; i++) {
            final double element = array[i];
            tabla += "<td>&Nbsp; " + element + " &nbsp;</td>\n";
        }
        salida.println(tabla + "</tr></table>");
    }
}
