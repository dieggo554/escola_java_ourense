/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.excepciones;

import com.vn.introjava.excepciones.UsoNormalExcepciones;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbandoExcepciones {

    @Test
    public void gestionarExcepcion() {
        try {
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
            unObj.metodoPeligroso();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Excepcion " + ex.getMessage());
            System.err.println("Pila de llamada "
                    + Arrays.toString(ex.getStackTrace()));
        }
    }
}
