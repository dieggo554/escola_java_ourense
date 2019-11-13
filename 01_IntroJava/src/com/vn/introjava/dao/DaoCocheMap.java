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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public Coche crear(Coche cocheNuevo) {
        mapaCoches.put(cocheNuevo.getMarca(), cocheNuevo);
        indiceMapaCoches.put(ultimoIndex, cocheNuevo);
        ultimoIndex++;
        return cocheNuevo;
    }

    public Coche crear(String marca) throws Exception {
        return crear(FabricaCoches.crear(marca));
//        Mejoramos:
//        Coche coche = FabricaCoches.crear(marca);
//        mapaCoches.put(marca, coche);
//        indiceMapaCoches.put(ultimoIndex++, coche);
    }

    @Override
    public Coche obtenerPorMarca(String marca) {
        return mapaCoches.get(marca);
    }

    @Override
    public Coche obtenerPorIndice(int index) {
        return indiceMapaCoches.get(index);
    }

    // No cambiamos el indice al modificar, podría dar problemas
    @Override
    public Coche modificar(int index, Coche cocheExistente) {
        try {
            Coche cocheViejoIndex = indiceMapaCoches.get(index);
            cocheViejoIndex.arrancar(cocheExistente.isArrancado() ? 4 : 1);
            cocheViejoIndex.setMarca(cocheExistente.getMarca());
//            cocheViejoIndex.setTipo(cocheExistente.getTipo());
            return cocheViejoIndex;
        } catch (Exception ex) {
            Logger.getLogger(DaoCocheMap.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void eliminar(int index) {
        eliminar(index, obtenerPorIndice(index).getMarca());
    }

    @Override
    public void eliminar(Coche objExistente) {
        for (Map.Entry<Integer, Coche> indexYcoche : indiceMapaCoches.entrySet()) {
            if (indexYcoche.getValue() == objExistente) {
                eliminar(indexYcoche.getKey(), objExistente.getMarca());
                break;
            }
        }
    }

    private void eliminar(int index, String marca) {
        mapaCoches.remove(marca);
        indiceMapaCoches.remove(index);
    }
}
