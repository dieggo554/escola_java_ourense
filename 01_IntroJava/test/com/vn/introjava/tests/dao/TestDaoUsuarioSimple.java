/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoUsuarioList;
import com.vn.introjava.dao.IDaoUsuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestDaoUsuarioSimple {
    
    @Test
    public void testDaoUsuarioList() throws Exception {
        IDaoUsuario daoUsuario = new DaoUsuarioList();
        daoUsuario.crear("Usuario A", 10);
        daoUsuario.crear("Usuario B", 20);
        daoUsuario.crear("Usuario C", 30);
        assertEquals(daoUsuario.obtenerPorIndice(2).getNombre(), "Usuario C");
        assertEquals(daoUsuario.obtenerPorIndice(1).getEdad(), 20);
        assertEquals(daoUsuario.obtenerPorEdad(20).getNombre(), "Usuario B");
        assertEquals(daoUsuario.obtenerPorIndice(0).getNombre(), "Usuario A");
    }
}
