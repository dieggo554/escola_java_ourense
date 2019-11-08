/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.sistdeplaz;

import com.vn.introjava.poo.interfaces.Desplazable;
import com.vn.introjava.poo.interfaces.Electrico;

/**
 *
 * @author pc
 */
public class BicicletaElectrica implements Electrico, Desplazable {

    @Override
    public void cargarBateria(double voltios) {
        System.out.println("La batería de la bicicleta se carga " + voltios + " voltios");
    }

    @Override
    public void mover(float metros) {
        System.out.println("La bicicleta se mueve " + metros + " metros");
    }
    
}
