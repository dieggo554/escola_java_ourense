/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import org.junit.Test;

/**
 *
 * @author pc
 */
public class ProbarClaseInterfazGenericaYAnidada {

    // Clase anidada, static para usarla en cualquier parte
    // puede ser privada default protected o publica
    public static class ClasePequePos<T> {

        T x, y;

        public ClasePequePos(T x, T y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() { return "x=" + x + ", y=" + y; }
    }

    @Test
    public void probarClaseGenericaAnidada() {
        ClasePequePos unPunto2D = new ClasePequePos(3f, 5f); // Aquí infiere el tipo
        System.out.println("PUNTO 2D: " + unPunto2D.toString());
        
        ClasePequePos<String> otroPunto2D = new ClasePequePos<String>("3", "5");
        System.out.println("PUNTO 2D: " + otroPunto2D.toString());
    }
}
