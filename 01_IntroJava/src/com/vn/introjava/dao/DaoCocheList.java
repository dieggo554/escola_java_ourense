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
    public Coche crear(Coche cocheNuevo) {
        listaCoches.add(cocheNuevo);
        return cocheNuevo;
    }
    
    @Override
    public Coche crear(String marca) throws Exception {
        return crear(FabricaCoches.crear(marca));
        // Es lo mismo
//        listaCoches.add(FabricaCoches.crear(marca));
    }
    @Override
    public Coche obtenerPorIndice(int index) {
        if (index < listaCoches.size())
            return listaCoches.get(index);
        else
            return null;
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
    public Coche modificar(int index, Coche cocheConDatosNuevos) {
        try {
            Coche coche = listaCoches.get(index);
            coche.setMarca(cocheConDatosNuevos.getMarca());
            coche.setTipo(cocheConDatosNuevos.getTipo());
            coche.arrancar(cocheConDatosNuevos.isArrancado() ? 4 : 1);
            return coche;
        } catch (Exception ex) {
            Logger.getLogger(DaoCocheList.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
//    Este substituye, no modifica
//    @Override
//    public void modificar(int index, Coche cocheExistente) {
//        listaCoches.set(index, cocheExistente);
//    }

    @Override
    public void eliminar(int index) {
        listaCoches.remove(index);
//        eliminar(obtenerPorIndice(index)); // mas lento pero puede usarse para otros casos
    }

    @Override
    public void eliminar(Coche cocheExistente) {
        listaCoches.remove(cocheExistente);
    }
}
