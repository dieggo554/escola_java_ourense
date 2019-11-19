/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn;

import com.vn.liboperaarrays.OperarArraysObject;
import java.io.PrintStream;

/**
 *
 * @author pc
 */
public class MainObj {
    
    public static void main(String[] args) {
        Double[] array_obj_A = {1d, 2d, 3d, 4d, 5d};
        Double[] array_obj_B = {2., 3., 4., 5., 6.};
        
        Object[] cadenaPuntos
                = OperarArraysObject.operarArarysObjects(
                        array_obj_A, 
                        array_obj_B, 
                        (Object x, Object y) -> {
                            String resultado = "( " + x + ", " + y + " )";
                            return resultado;
                });
        arrayEnTabla(System.out, cadenaPuntos);
    }
    
    public static void arrayEnTabla(PrintStream salida, Object[] array) {

        String tabla = "<table border=2><tr>\n";
        for (int i = 0; i < array.length; i++) {
            tabla += "<td>&Nbsp; " + array[i] + " &nbsp;</td>\n";
        }
        salida.println(tabla + "</tr></table>");
    }
}
