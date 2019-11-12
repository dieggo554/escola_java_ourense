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
    public void crear(Coche cocheNuevo) {
        mapaCoches.put(cocheNuevo.getMarca(), cocheNuevo);
        indiceMapaCoches.put(ultimoIndex++, cocheNuevo);
    }

    public void crear(String marca) throws Exception {
        crear(FabricaCoches.crear(marca));
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

    @Override
    public void modificar(int index, Coche cocheExistente) {
        Coche cocheViejo = indiceMapaCoches.get(index);
        mapaCoches.remove(cocheViejo.getMarca());
        mapaCoches.put(cocheExistente.getMarca(), cocheExistente);
        indiceMapaCoches.put(index, cocheExistente);
    }

    @Override
    public void delete(int index) {
        delete(index, obtenerPorIndice(index).getMarca());
    }

    @Override
    public void delete(Coche objExistente) {
        int key = -1;
        for (Map.Entry<Integer, Coche> entry : indiceMapaCoches.entrySet()) {
            if (entry.getValue().getMarca().equals(objExistente.getMarca())) {
                key = entry.getKey();
                break;
            }
        }
        delete(key, objExistente.getMarca());
    }
    
    private void delete(int index, String marca) {
        mapaCoches.remove(marca);
        indiceMapaCoches.remove(index);
    }
}
