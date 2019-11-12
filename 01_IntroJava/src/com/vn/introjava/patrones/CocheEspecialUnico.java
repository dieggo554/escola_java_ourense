/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.patrones;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.Random;

/**
 *
 * @author pc
 */
public class CocheEspecialUnico extends Coche {

    // Debe ser privada para que no se pueda poner a null, lo que crearia una
    // nueva estancia
    private static CocheEspecialUnico unicoCocheEsp;

    private CocheEspecialUnico() {
        super();
    }

    public static CocheEspecialUnico getInstancia() throws Exception {
        if (CocheEspecialUnico.unicoCocheEsp == null) {
            CocheEspecialUnico.unicoCocheEsp = new CocheEspecialUnico();
            CocheEspecialUnico.unicoCocheEsp.setMarca("UNICO COCHE " + (new Random().nextInt()));
        }
        return CocheEspecialUnico.unicoCocheEsp;
    }
}
