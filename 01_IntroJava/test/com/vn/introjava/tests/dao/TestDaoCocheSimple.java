/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoCocheList;
import com.vn.introjava.dao.DaoCocheMap;
import com.vn.introjava.dao.IDaoCoche;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author pc
 */
public class TestDaoCocheSimple {
    
    @Test
    public void testDaoCocheList() throws Exception {
        testInterfaceDaoCoche(new DaoCocheList());
    }
    
    @Test
    public void testDaoCocheMap() throws Exception {
        testInterfaceDaoCoche(new DaoCocheMap());
    }
    
    void testInterfaceDaoCoche (IDaoCoche daoCoche) throws Exception {
        daoCoche.crear("Coche A");
        daoCoche.crear("Coche B");
        Coche cc = daoCoche.crear("Coche C");
        
        Assert.assertEquals("Coche B", daoCoche.obtenerPorIndice(1).getMarca());
        Assert.assertEquals("Coche C", daoCoche.obtenerPorMarca("Coche C").getMarca());
        Assert.assertEquals("Coche C", daoCoche.obtenerPorIndice(2).getMarca());
        
        Coche modificar = new Coche("Coche B ahora X");
        daoCoche.modificar(1, modificar);
        Assert.assertEquals("Coche B ahora X", daoCoche.obtenerPorIndice(1).getMarca());
        Assert.assertEquals("Coche B ahora X", daoCoche.obtenerPorMarca("Coche B ahora X").getMarca());
        
        
        modificar = new Coche("Coche C");
        modificar.arrancar();
        daoCoche.modificar(2, modificar); // El nº2 es cc, debe ser arrancado aquí dentro
        Assert.assertEquals(modificar.isArrancado(), cc.isArrancado());
        
        daoCoche.eliminar(1); // Elimina el B
        daoCoche.eliminar(daoCoche.obtenerPorMarca("Coche A"));
        Assert.assertNull(daoCoche.obtenerPorIndice(1));
        Assert.assertNull(daoCoche.obtenerPorMarca("Coche A"));
        
        if (daoCoche instanceof DaoCocheList)
            Assert.assertEquals("Coche C", daoCoche.obtenerPorIndice(0).getMarca()); // El índice baja
        else
            Assert.assertEquals("Coche C", daoCoche.obtenerPorIndice(2).getMarca()); // El ínidice no cambia
    }
}
