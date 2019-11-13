/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

/**
 *
 * @author pc
 * @param <T>
 */
public interface IGenericDao<T> {
    
    T crear(T objeto);
    T obtenerPorIndice(int index);
    T modificar(int index, T objExistente);
    void eliminar(int index);
    void eliminar(T objExistente);
}
