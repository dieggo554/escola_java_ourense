/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import com.vn.introjava.excepciones.UsoNormalExcepciones;
import static com.vn.introjava.funcionesbasicas.DatosBasicos.*;
import static com.vn.introjava.funcionesbasicas.Ordenamiento.*;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.dsig.TransformException;

/**
 * Clase principal del proyecto Ejemplos Java
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) {
        /* Error no capturado, se detiene el programa
        while (args.length > -1)
            ((Object) null).equals(args); */
        try {
            Coche c = FabricaCoches.crear("Seat");
            c.mostrarEstado();
            //            return;
//            c = FabricaCoches.crear(null); // IllegalArgumentException
            c = FabricaCoches.crear("Un Coche");
            c.mostrarEstado();

            // Segundo error
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
//            unObj.metodoPeligroso(); // RuntimeException

            throw new TransformException("Optimus prime se ha quedado sin batería");

            // Tercer error
//            Object objNulo = null;
//            System.out.println("Fallará: " + objNulo.toString()); // NullPointerException
        } // Se pueden anidar los catch
         catch (IllegalArgumentException ex) {
            System.out.println("ARGUMENTO INVÁLIDO. DECIRLE AL USUARIO LO QUÉ: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RuntimeException ex) {
            System.out.println("Cualquier tipo de Runtime Exception");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            // Captura cualquier excepción cuyo tipo sea indicado en el catch
            // o CUALQUIERA de sus clases HIJAS que NO haya sido GESTIONADAS
            System.out.println("Cualquier tipo de excepción");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Siempre se ejecuta, incluso antes que un return
            System.out.println(">>> FIN DE TRY - CATCH");
        }
        System.out.println("**** FIN DE PROGRAMA");
    }

    /**
     * Función que se ejecuta al arrancar el programa
     *
     * @param args the command line arguments
     */
    public static void mainTryCatchProSeparado(String[] args) {
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
            c = FabricaCoches.crear(null); // tira excepcion
            c.mostrarEstado();
        } catch (Exception ex) {
            System.err.println(">> LOG: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
            unObj.metodoPeligroso();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Excepcion " + ex.getMessage());
            System.err.println("Excepcion " + ex.toString());
            System.err.println("Pila de llamada "
                    + Arrays.toString(ex.getStackTrace()));
        }

        try {
            Object objNulo = null;
            System.out.println("Fallará: " + objNulo.toString());
        } catch (NullPointerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
