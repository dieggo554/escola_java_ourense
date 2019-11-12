/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoCocheList;
import com.vn.introjava.dao.DaoCocheMap;
import com.vn.introjava.dao.IDaoCoche;
import org.junit.Assert;
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
        daoCoche.crear("Coche C");
        Assert.assertEquals(daoCoche.obtenerPorIndice(1).getMarca(), "Coche B");
        Assert.assertEquals(daoCoche.obtenerPorMarca("Coche C").getMarca(), "Coche C");
    }
}
