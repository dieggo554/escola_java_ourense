/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoUsuarioList;
import com.vn.introjava.dao.IDaoUsuario;
import com.vn.introjava.dao.Usuario;
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
        testDaoUsuarioList(daoUsuario);
    }
    
    public void testDaoUsuarioList(IDaoUsuario daoUsuario) throws Exception {
        daoUsuario.crear(new Usuario("Juan", 30));
        daoUsuario.crear(new Usuario("Ana", 31));
        daoUsuario.crear(new Usuario("Bea", 32));
        daoUsuario.crear(new Usuario("Luis", 29));
        assertEquals("Ana", daoUsuario.obtenerPorIndice(1).getNombre());
        assertEquals(32, daoUsuario.obtenerPorNombre("Bea").getEdad());
        
        daoUsuario.modificar(1, new Usuario("Ana Modif", 21));
        assertEquals("Ana Modif", daoUsuario.obtenerPorIndice(1).getNombre());
        assertEquals(21, daoUsuario.obtenerPorIndice(1).getEdad());
        
        daoUsuario.eliminar(daoUsuario.obtenerPorIndice(0));
        daoUsuario.eliminar(1);
        // El 1 ahora es Luis
        assertEquals("Luis", daoUsuario.obtenerPorIndice(1).getNombre());
    }
}
