/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.sistdeplaz;

import com.vn.introjava.poo.interfaces.Desplazable;

/**
 *
 * @author pc
 */
public class Monopatin implements Desplazable {

    public void andar(float metros) {
        System.out.println("El monopatín anda " + metros + "m!");
    }
    
    public void rodar(float metros) {
        System.out.println("El monopatín rueda " + metros + "m!");
    }
    
    // podemos cambiar el nombre que tiene el parámetro de la interfaz
    // no debemos cambiarle el "sentido"
    @Override
    public void mover(float m) {
        if (m > 4)
            rodar(m);
        else
            andar(m);
    }
    
}
