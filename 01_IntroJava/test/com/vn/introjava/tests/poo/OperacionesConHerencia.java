/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import com.vn.introjava.poo.vehiculos.TipoVehiculo;
import com.vn.introjava.poo.vehiculos.Tractor;
import com.vn.introjava.poo.vehiculos.Vehiculo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class OperacionesConHerencia {

    static CocheRally supra;
    static Coche turismo;

    // Se ejecuta antes de los test (preparación de la clase)
    @BeforeClass
    public static void setUpClass() throws Exception {
        supra = new CocheRally();
        supra.setMarca("Toyota");
    }

    @Test
    public void testSobreescrituraMetodos() throws Exception {
        supra.setRozamiento(7f);
        assertTrue(supra.getRozamiento() == 7f);

        // Usando T.D.D.
        assertTrue(supra.arrancar("arrancar"));
        assertTrue(supra.arrancar("ENCENDER"));
        assertTrue(supra.arrancar("Encender"));
//        supra.mostrarEstadoAntiguo();
        supra.mostrarEstado();
    }

    @Test
    public void testPolimorfismo() {
        supra.setRozamiento(15f);

        turismo = supra;
//        turismo.setRozamiento(15f); // No se puede

        // En Java todos los métodos son VIRTUALES,
        // si un hijo tiene método (sobreescrito) se llama al del hijo
        turismo.mostrarEstado();
    }

    @Test
    public void testEnumerado() {
        supra.setTipo(TipoVehiculo.RALLY);
        // Un enumerado es un int, limitado a la lista de valores indicados
        System.out.println("Tipo: " + supra.getTipo() /* .toString() */);
        // El método .ordinal() nos muestra el número
        System.out.println("Valor tipo: " + supra.getTipo().ordinal());

        Tractor miTractorAmarillo = new Tractor();
        miTractorAmarillo.setTipo(TipoVehiculo.valueOf("TRACTOR")); // fallrá si renombramos
        System.out.println("Valor tipo desde String: "
                + miTractorAmarillo.getTipo());
        // o
        miTractorAmarillo.setTipo(TipoVehiculo.values()[1]); // utlizar siempre entero
        System.out.println("Valor tipo desde int: "
                + miTractorAmarillo.getTipo());
    }
    
    @Test
    public void testClasesAbstractas() {
//        Vehiculo vehDesc = new Vehiculo(); // No se puede, clase abstracta
        Vehiculo dacia = new Coche("Dacia");
        Vehiculo subaru = new CocheRally("Subaru");
        Vehiculo miTractor = new Tractor();
        dacia.avanzar();
        miTractor.avanzar();
        assertEquals(((CocheRally)subaru).getMarca(), "Subaru");
        
        Vehiculo[] misVehiculos = new Vehiculo[] {
            dacia,
            miTractor,
            new Coche("Tesla"),
            subaru
        };
        
        System.out.println("----------");
        for (Vehiculo miVehiculo : misVehiculos) {
            miVehiculo.mostrarEstado();
        }
        System.out.println("----------");
        for (Vehiculo miVehiculo : misVehiculos) {
            System.out.println(miVehiculo);
        }
        System.out.println("----------");
    }
}
