package com.vn.appweb.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.vn.appweb.modelo.ConsultaSQL;
import com.vn.appweb.modelo.DatosPersona;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestConsultaDatosPersona {

    @Test
    public void testSelectSQL() {
        ConsultaSQL conSQl = new ConsultaSQL();

        assertEquals(0, conSQl.leerTabla("Nombre FALSE").size());

        assertEquals(
                "Nombre de prueba",
                conSQl.leerTabla("Nombre de prueba").get(0).getNombre());

        assertEquals("aaa@ooo.yy", conSQl.leerTabla("o").get(0).getEmail());
        
        assertEquals("aaa@ooo.yy", conSQl.leerTabla(" o ").get(0).getEmail());
    }
}
