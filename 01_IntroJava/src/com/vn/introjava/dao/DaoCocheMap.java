/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pc
 */
public class DaoCocheMap implements IDaoCoche {

    private final Map<String, Coche> mapaCoches;
    // Creamos un indice (como marcar un campo para indexar en una BD)
    private final Map<Integer, Coche> indiceMapaCoches;
    private int ultimoIndex;
    

    public DaoCocheMap() {
        mapaCoches = new HashMap<>();
        indiceMapaCoches = new HashMap<>();
        ultimoIndex = 0;
    }
    
    @Override
    public void crear(Coche objeto) {
        mapaCoches.put(objeto.getMarca(), objeto);
        indiceMapaCoches.put(ultimoIndex++, objeto);
    }

    public void crear(String marca) throws Exception {
        Coche coche = FabricaCoches.crear(marca);
        mapaCoches.put(marca, coche);
        indiceMapaCoches.put(ultimoIndex++, coche);
    }

    @Override
    public Coche obtenerPorMarca(String marca) {
        return mapaCoches.get(marca);
    }

    @Override
    public Coche obtenerPorIndice(int index) {
        return indiceMapaCoches.get(index);
    }
}
