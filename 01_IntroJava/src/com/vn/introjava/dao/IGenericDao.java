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
public interface IGenericDao<T> {
    
    void crear(T objeto);
    T obtenerPorIndice(int index);
    void modificar(int index, T objExistente);
    void delete(int index);
    void delete(T objExistente);
}
