/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class DaoCocheList implements IDaoCoche {
    
    private final List<Coche> listaCoches; // la lista es muy lenta al no estar ordenada
    
    public DaoCocheList() {
        listaCoches = new ArrayList<>();
    }
    
    @Override
    public void crear(Coche cocheNuevo) {
        listaCoches.add(cocheNuevo);
    }
    
    public void crear(String marca) throws Exception {
        crear(FabricaCoches.crear(marca));
        // Es lo mismo
//        listaCoches.add(FabricaCoches.crear(marca));
    }
    @Override
    public Coche obtenerPorIndice(int index) {
        return listaCoches.get(index);
    }
    
    @Override
    public Coche obtenerPorMarca(String marca) {
        for (Coche coche : listaCoches) {
            if (coche.getMarca().equals(marca)) {
                return coche;
            }
        }
        return null;
    }

    @Override
    public void modificar(int index, Coche cocheExistente) {
        try {
            Coche coche = listaCoches.get(index);
            coche.setMarca(cocheExistente.getMarca());
        } catch (Exception ex) {
            Logger.getLogger(DaoCocheList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int index) {
        listaCoches.remove(index);
    }

    @Override
    public void delete(Coche cocheExistente) {
        listaCoches.remove(cocheExistente);
    }
}
