/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia.sincronia;

/**
 *
 * @author pc
 */
public class Productor {

    private Contenedor contenedor;

    public Productor(Contenedor c) {
        contenedor = c;
    }

    public void producir() {
        
        int i = 9;
        contenedor.put(i);
        
        System.out.println("Productor. PUT: " + i);
    }
}
