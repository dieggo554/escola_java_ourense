/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

/**
 *
 * @author pc
 */
public interface IDaoUsuario {
    
    void crear(String nombre, int edad);
    Usuario obtenerPorNombre(String nombre);
    Usuario obtenerPorEdad(int edad);
    Usuario obtenerPorIndice(int index);
}
