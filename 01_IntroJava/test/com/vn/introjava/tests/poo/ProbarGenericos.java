/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarGenericos {
    
    @Test
    public void testearClaseAnidada() {
        //Las clases anidadas generan su propio fichero bytecode (.class)
        ProbarClaseInterfazGenericaYAnidada.ClasePequePos c;
        c = new ProbarClaseInterfazGenericaYAnidada.ClasePequePos(1f, 2f);
    }
    
    // En cuanto un elemento indica el tipo y todos los demas deven coincidir
    @Test
    public void testearMetodosGenericos() {
        ArrayList<Integer> listaInt = new ArrayList<>();
        int tres = 3, cinco = 5;
        insertarDosVeces(listaInt, tres);
        insertarDosVeces(listaInt, cinco);
        for (Integer integer : listaInt) {
            System.out.println(" - " + integer);
        }
        
        ArrayList<String> listaStr = new ArrayList<>();
        insertarDosVeces(listaStr, "tres");
        insertarDosVeces(listaStr, "cinco");
        for (String string : listaStr) {
            System.out.println("** " + string);
        }
        
        ArrayList<Coche> listaCoches = new ArrayList<>();
        insertarDosVeces(listaCoches, new Coche("Subaru"));
        insertarDosVeces(listaCoches, new Coche("Seat"));
        for (Coche coche : listaCoches) {
            System.out.println("++ " + coche);
        }
        
        System.out.println("mostrarYDevolver devuelve: " + mostrarYDevolverUltimo(listaCoches));
        
        Integer ultInt = mostrarYDevolverUltimo(listaInt);
        assertEquals((int) ultInt, 5);
    }
    
    // Entre < y > ponemos el nombre del tipo genérico
    // Esto convierte el método en un "METODO GENERICO"
    static <Tipo> void insertarDosVeces(ArrayList<Tipo> listaGenerica, Tipo objeto) {
        listaGenerica.add(objeto);
        listaGenerica.add(objeto);
        System.out.println(objeto + " añadido dos veces");
        if (objeto instanceof Integer) {
            Integer i = (Integer) objeto; // Conversión explicita
            i = i + 2;
        }
    }
    
    // Método genérico que reciba un ArrayList<Tipo>, que lo muestre (foreach) y que devuelva el último valor

    // Por convención el primer tipo se llama "T"
    static <T> T mostrarYDevolverUltimo(ArrayList<T> listaGenerica) {
        System.out.println("mostrarYDevolver");
        // lamda
        listaGenerica.forEach((tipo) -> {
            System.out.println("# " + tipo);
        });
        if (listaGenerica.size() > 0)
            return listaGenerica.get(listaGenerica.size() -1);
        else
            return null;
    }
    
    /* METODOS NO GENERICOS!

    @Test
    public void testearMetodosNoGenericos() {
        // Referencia al objeto listaInt
        // una variable instanciada son 64bits de memoria
        // Luego se utiliza para almacenar un tipo primitivo <= 8 bytes
        // o para apuntar una direccion de memoria para un objeto
        ArrayList<Integer> listaInt = new ArrayList<Integer>();
        int tres = 3, cinco = 5;
        insertarIntegerDosVeces(listaInt, tres);
        insertarIntegerDosVeces(listaInt, cinco);
        System.out.println("Tres sigue siendo " + tres);
        for (Integer integer : listaInt) {
            System.out.println(" - " + integer);
        }
        
        // Inferir: Inferir, deduce el tipo por su declaración
        ArrayList<String> listaStr = new ArrayList<>();
        insertarIntegerDosVeces(listaStr, "tres");
        insertarIntegerDosVeces(listaStr, "cinco");
        for (String str : listaStr) {
            System.out.println("** " + str);
        }
    }
    
    // recibe los 64bits que hay en listaInt, no a lo que apunta
    static void insertarIntegerDosVeces(ArrayList<Integer> listaInt, int i) { // Se pasan por valor las direcciones de memoria
        // Otra referencia a listaInt
        listaInt.add(i);
        listaInt.add(i);
        System.out.println(i + " añadido dos veces");
        i = i + 10;
        // Ponemos a null la segunda referencia, la referencia local
        listaInt = null;
    }
    
    static void insertarStringDosVeces(ArrayList<String> listaStr, String str) { // Se pasan por valor las direcciones de memoria
        // Otra referencia a listaInt
        listaStr.add(str);
        listaStr.add(str);
        System.out.println(str + " añadido dos veces");
        // Esto no afecta fuera del método
        str = str + "10";
        listaStr = null;
    }
*/
}
