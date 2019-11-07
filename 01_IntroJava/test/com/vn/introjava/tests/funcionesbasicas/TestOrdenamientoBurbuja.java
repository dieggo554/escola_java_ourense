/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.funcionesbasicas;

import com.vn.introjava.funcionesbasicas.Ordenamiento;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestOrdenamientoBurbuja {
    
    public TestOrdenamientoBurbuja() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /** Probar ordenamiento de sistema humano (buscar más pequeño y meter en otro array)
     * 
     * @param array             Array que queremos ordenar
     * @param arrayOrdenadoOk   Array que sabemos que es correcto
     */
//    @Test
     private void probarOrdenamientoSistemaHumano(int[] array, int[] arrayOrdenadoOk) {
//         int[] array = { 4,2,3,1,5,9,7,8,6 };
//         int[] arrayOrdenadoOk = { 1,2,3,4,5,6,7,8,9 };
         int[] arrayOrdPorFuncion = Ordenamiento.ordenarArrayConBurbuja(array);
         assertArrayEquals(arrayOrdenadoOk, arrayOrdPorFuncion);
     }
     
     
    
     @Test
     public void probarOrdenamSistHum_Array_5() {
         probarOrdenamientoSistemaHumano(
                 new int[] { 4,2,3,1 },
                 new int[] { 1,2,3,4 });
     }
     
     @Test
     public void probarOrdenamSistHum_Array_1() {
         int[] array = { 1 };
         int[] arrayOrdenadoOk = { 1 };
         probarOrdenamientoSistemaHumano(array, arrayOrdenadoOk);
     }
     
     @Test
     public void probarOrdenamSistHum_Array_9() {
         int[] array = { 4,2,3,1,5,9,7,8,6 };
         int[] arrayOrdenadoOk = { 1,2,3,4,5,6,7,8,9 };
         probarOrdenamientoSistemaHumano(array, arrayOrdenadoOk);
     }
     
     @Test
     public void probarOrdenamSistHum_Array_2() {
         probarOrdenamientoSistemaHumano(
                new int[] { 2,1 },
                new int[] { 1,2 });
     }
     
     @Test
     public void probarOrdenamSistHum_Negativos() {
         probarOrdenamientoSistemaHumano(
                new int[] { 4,-2,3,1,5,9,7,8,6 },
                new int[] { -2,1,3,4,5,6,7,8,9 });
     }
     
     @Test
     public void probarOrdenamSistHum_Repetidos() {
         probarOrdenamientoSistemaHumano(
                new int[] { 4,2,2,1,5,9,2,8,6 },
                new int[] { 1,2,2,2,4,5,6,8,9 });
     }
     
     @Test
     public void probarOrdenamSistHum_Maximo() {
         probarOrdenamientoSistemaHumano(
                new int[] { 4,2,Integer.MAX_VALUE,1,5,9,2,8,6 },
                new int[] { 1,2,2,4,5,6,8,9,Integer.MAX_VALUE });
     }
     
     @Test
     public void probarOrdenamSistHum_Minimo() {
         probarOrdenamientoSistemaHumano(
                new int[] { 4,2,Integer.MIN_VALUE,1,5,9,2,8,6 },
                new int[] { Integer.MIN_VALUE,1,2,2,4,5,6,8,9 });
     }
     
     @Test
     public void probarOrdenamSistHum_Vacio() {
         probarOrdenamientoSistemaHumano(
                new int[] {},
                new int[] {});
     }
     
     @Test
     public void probarOrdenamSistHum_Nulo() {
         probarOrdenamientoSistemaHumano(
                null,
                new int[] {});
     }
     
     @Test
     public void probarOrdenamSistHum_Ordenado() {
         probarOrdenamientoSistemaHumano(
                 new int[] { 1,2,3,4 },
                 new int[] { 1,2,3,4 });
     }
     
//     @Test
//     public void probar_MAL() {
//         assertEquals(10, 11); // Si este falla sale y no pasa al siguiente
//         assertTrue(5.5f == 5.05f);
//     }
}
