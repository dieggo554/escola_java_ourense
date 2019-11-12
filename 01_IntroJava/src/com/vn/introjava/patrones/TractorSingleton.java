/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.patrones;

import com.vn.introjava.poo.vehiculos.Tractor;
import java.util.Random;

/**
 *
 * @author pc
 */
public class TractorSingleton extends Tractor {

    private static TractorSingleton instance = new TractorSingleton();
    private int modelo;

    private TractorSingleton() {
        super();
        modelo = (new Random().nextInt());
    }

    public static TractorSingleton getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return super.toString() + " modelo: " + modelo;
    }
}
