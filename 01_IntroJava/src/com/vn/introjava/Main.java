/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import static com.vn.introjava.funcionesbasicas.DatosBasicos.*;
import static com.vn.introjava.funcionesbasicas.Ordenamiento.*;
import com.vn.introjava.poo.Coche;
import com.vn.introjava.poo.FabricaCoches;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal del proyecto Ejemplos Java
 *
 * @author pc
 */
public class Main {

    /**
     * Función que se ejecuta al arrancar el programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        mostrarTiposDatos();
//        EstructurasControl.ejecutarBucles();
//        EstructurasControl.ejecutarCondiciones();
//        probarOperadores();
//        int[] array = { 4,2,3,1};
//        ordenarArrayConBurbuja(array);
//        ordenarArrayConBurbujaOptimizada(array);
//        ordenarArray(array);
        
        Coche c;
        try {
            c = FabricaCoches.crear("Seat");
            c.mostrarEstado();
//            c = FabricaCoches.crear(null); // tira excepcion
            c.mostrarEstado();
        } catch (Exception ex) {
            System.err.println(">> LOG: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
