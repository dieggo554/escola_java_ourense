/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.patrones;

import com.vn.introjava.poo.vehiculos.Coche;

/**
 *
 * @author pc
 */
public class CocheEspecialUnico extends Coche {
    
    public static CocheEspecialUnico unicoCocheEsp;

    private CocheEspecialUnico() {
        super();
    }
    
    public static CocheEspecialUnico getInstancia() throws Exception {
        if (CocheEspecialUnico.unicoCocheEsp != null) {
            return CocheEspecialUnico.unicoCocheEsp;
        } else {
            CocheEspecialUnico.unicoCocheEsp = new CocheEspecialUnico();
            CocheEspecialUnico.unicoCocheEsp.setMarca("UNICO COCHE 1");
            return CocheEspecialUnico.unicoCocheEsp;
        }
    }
}
