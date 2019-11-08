/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import org.junit.Test;

/**
 *
 * @author pc
 */
public class Colecciones {
    
    @Test
    public void testColeciones() {
        // Acceso aleatorio
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Cadena 3");
        arrayList.add("Cadena 1");
        arrayList.add("Cadena 1");
        arrayList.add("Cadena 2");
        
        System.out.println("Bucle ForEach de ArrayList");
        for (String string : arrayList) {
            System.out.println(string);
        }
        
        System.out.println("Bucle For con indice de ArrayList");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i + " - " + arrayList.get(i));
        }
        
        System.out.println("Acceso por indice a ArrayList");
        arrayList.get(2);
        
        // Acceso secuencial
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Cadena 3");
        linkedList.add("Cadena 1");
        linkedList.add("Cadena 1");
        linkedList.add("Cadena 2");
        
        System.out.println("Bucle ForEach de LinkedList");
        for (String string : linkedList) {
            System.out.println(string);
        }
        
        System.out.println("Bucle For con indice de LinkedList");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(i + " - " + arrayList.get(i));
        }
        
        System.out.println("Acceso por indice a linkedList");
        linkedList.get(2);
        
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Clave 3", "Cadena 3");
        hashMap.put("Clave 1", "Cadena 1");
        hashMap.put("Clave 1", "Cadena 1");
        hashMap.put("Clave 2", "Cadena 2");
        
        System.out.println("Bucle For con indice de HashMap");
        for (int i = 0; i < hashMap.size(); i++) {
            System.out.println(i + " - " + arrayList.get(i));
        }
        
        System.out.println("Acceso por clave a HashMap");
        hashMap.get("Clave 1");
        
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("Cadena 3");
        hashSet.add("Cadena 1");
        hashSet.add("Cadena 1");
        hashSet.add("Cadena 2");
        
        System.out.println("Bucle For con indice de HashSet");
        for (int i = 0; i < hashSet.size(); i++) {
            System.out.println(i + " - " + arrayList.get(i));
        }
        
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("Cadena 3");
        treeSet.add("Cadena 1");
        treeSet.add("Cadena 1");
        treeSet.add("Cadena 2");
        
        System.out.println("Bucle ForEach de TreeSet");
        for (String string : treeSet) {
            System.out.println(string);
        }
    }
}
