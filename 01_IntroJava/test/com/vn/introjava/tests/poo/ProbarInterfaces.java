/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.interfaces.Desplazable;
import com.vn.introjava.poo.interfaces.Electrico;
import com.vn.introjava.poo.sistdeplaz.Avion;
import com.vn.introjava.poo.sistdeplaz.BicicletaElectrica;
import com.vn.introjava.poo.sistdeplaz.Monopatin;
import com.vn.introjava.poo.sistdeplaz.MonopatinElectrico;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheElectrico;
import com.vn.introjava.poo.vehiculos.CocheRally;
import com.vn.introjava.poo.vehiculos.Vehiculo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarInterfaces {
    
     @Test
     public void creandoDesplazablesAvion() {
         Avion miAvionDeLosLunes = new Avion();
         miAvionDeLosLunes.volar(50.1f);
         miAvionDeLosLunes.rodar(5f);
         
         Desplazable d1 = new Avion();
         d1.mover(9f);
         
         Avion avionD1 = (Avion) d1; // es obligatorio el casteo
         avionD1.volar(0f);
         assertTrue(d1 instanceof Avion);
     }
     
     @Test
     public void creandoDesplazablesMonopatin() {
         Monopatin miMonopatinDeLosLunes = new Monopatin();
         miMonopatinDeLosLunes.andar(10f);
         miMonopatinDeLosLunes.rodar(2f);
         
         Desplazable d1 = new Monopatin();
         d1.mover(9f);
         assertTrue(d1 instanceof Monopatin);
         
         Monopatin monopatinD1 = (Monopatin) d1; // es obligatorio el casteo
         monopatinD1.andar(10f);
         assertTrue(d1 instanceof Monopatin);
     }
     
     @Test
     public void creandoDesplazablesVehiculos() {
         CocheRally cocheRally = new CocheRally("COCHE RALLY PROPIO 3D");
         // Facetas polimorfismo:
         Coche cocheR = cocheRally;
         Vehiculo vehiculoR = cocheRally;
         Desplazable desplazableR = cocheRally;
         cocheR.arrancar();
         vehiculoR.mostrarEstado();
         desplazableR.mover(10f);
         assertTrue(desplazableR instanceof CocheRally);
         
         if (desplazableR instanceof CocheRally) {
             ((CocheRally) desplazableR).setRozamiento(10f);
             assertEquals(((CocheRally) desplazableR).getRozamiento(), 10f, 0.001f);
         }
     }
     
     @Test
     public void creandoDesplazablesElectricos() {
         Electrico[] electricos = { new CocheElectrico(),new MonopatinElectrico(), new BicicletaElectrica() };
         
         for (Electrico electrico : electricos) {
             if (electrico instanceof CocheElectrico)
                electrico.cargarBateria(100d);
             else
                 electrico.cargarBateria(10d);
         }
         
         if (electricos.length != 3)
//             fail():
             fail("No tiene tres elementos");
     }
}
