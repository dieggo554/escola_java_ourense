/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import java.io.Serializable;

/**
 *
 * @author pc
 */
public interface IDaoUsuario extends IGenericDao<Usuario> {
/* Se puede sobreescribir, pero no es necesario
    @Override
    void crear(Usuario nuevoUsuario);
    
    @Override
    Usuario obtenerPorIndice(int index);
*/
    Usuario crear(String nombre, int edad);
    
    Usuario obtenerPorNombre(String nombre);

    Usuario obtenerPorEdad(int edad);
}
