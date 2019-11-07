/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.Coche;
import com.vn.introjava.poo.FabricaCoches;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class OperacionesBasicasObjetos {

    @Test
    public void creandoObjetos() {
        Coche miCoche = null;

        miCoche = new Coche();
        System.out.println("Texto de coche: " + miCoche.toString());

        Coche miCocheFindes = new Coche();
        assertNotNull(miCoche);
        assertNotNull(miCocheFindes);
        assertNotEquals(miCoche, miCocheFindes);
        
        try {
            // miCoche = "Kia"; No compila
            miCoche.setMarca("Kia");
        } catch (Exception ex) {
            Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            miCocheFindes.setMarca("Hammer");
        } catch (Exception ex) {
            Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("miCoche.marca = " + miCoche.getMarca());
        System.out.println("miCocheFindes.marca = " + miCocheFindes.getMarca());
        assertEquals(miCoche.getMarca(), "Kia");
        assertEquals(miCocheFindes.getMarca(), "Hammer");
        
        miCocheFindes = miCoche;
        assertEquals(miCoche, miCocheFindes);
        try {
            miCoche.setMarca("Hammer Limusina");
        } catch (Exception ex) {
            Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("miCoche.marca = " + miCoche.getMarca());
        System.out.println("miCocheFindes.marca = " + miCocheFindes.getMarca());
        
        // Intro Polimorfismo
        Object refAmiCoche = miCoche;
        // El objeto no es modificado pero no compila si intentamos acceder
        // a una variable de coche por que no tiene la forma de coche
//        System.out.println("miCoche.marca = " + refAmiCoche.getMarca());
        // Si podemos...
        assertTrue(refAmiCoche.equals(miCoche));
        
        // Tira excepcion: Object cannot be cast to ...Coche
//        Object obj = new Object();
//        miCoche = (Coche) obj;
        
        assertEquals(miCoche.getNumRuedas(), 4);

        // Le decimos al Rec. Basura que queremos borrar
        // todos los obj
        miCoche = null;
        miCocheFindes = null;
        // Llamada manual (innecesario al final del bloque)
        System.gc();
    }
    
    @Test
    public void probandoSobrecarga() {
        Coche miCoche = new Coche();
        assertTrue(miCoche.arrancar());
        
        for (int i = -1; i < 6; i++) {
            if (i == 4) 
                assertTrue(miCoche.arrancar(i));
             else 
                assertFalse(miCoche.arrancar(i));
            
        }
    }
    
    @Test (expected = IllegalArgumentException.class, timeout = 1000L /* miliseconds */)
    public void gestionExcepciones() throws Exception {
        Coche c = FabricaCoches.crear("");
    }
    
    @Test // (expected = IllegalArgumentException.class)
    public void gestionExcepciones_2() {
        try {
            Coche c = FabricaCoches.crear("");
        } catch (Exception exception) {
            Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, exception);
            assertTrue(exception instanceof IllegalArgumentException);
        }
    }
    
    /* Como no recibe la excepcion, falla el test
    @Test (expected = IllegalArgumentException.class)
    public void gestionExcepcionesMAL() throws Exception {
        Coche c = FabricaCoches.crear("Marca");
    } */
    
    @Test
    public void usandoConstructoresSobrecargados() {
        Coche c = new Coche("Ferrari");
        assertEquals(c.getMarca(), "Ferrari");
    }
}
