/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class DaoUsuarioList implements IDaoUsuario {

    private final List<Usuario> listaUsuarios;

    public DaoUsuarioList() {
        listaUsuarios = new ArrayList<>();
    }

    @Override
    public void crear(Usuario nuevoUsuario) {
        listaUsuarios.add(nuevoUsuario);
    }
    
    public void crear(String nombre, int edad) {
        listaUsuarios.add(new Usuario(nombre, edad));
    }

    @Override
    public Usuario obtenerPorNombre(String nombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public Usuario obtenerPorEdad(int edad) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEdad() == edad) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public Usuario obtenerPorIndice(int index) {
        return listaUsuarios.get(index);
    }
}
