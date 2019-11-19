/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.liboperaarrays;

/**
 *
 * @author pc
 */
public class OperarArraysObject {
    
    @FunctionalInterface
    public interface FunCallbackOperarArraysObjects {
        // Sólo podemos declarar 1 método
        Object operar(Object x, Object y);
    }
    
    public static Object[] operarArarysObjects(
            Object[] arrX,
            Object[] arrY,
            OperarArraysObject.FunCallbackOperarArraysObjects operaCllbk)
    {
        Object[] arrayResult = null;
        if (arrX.length == arrY.length) {
            arrayResult = new Object[arrX.length];
            for (int i = 0; i < arrX.length; i++) {
                arrayResult[i] = operaCllbk.operar(arrX[i], arrY[i]);
            }
        }
        return arrayResult;
    }
}
