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
    public Usuario crear(Usuario nuevoUsuario) {
        listaUsuarios.add(nuevoUsuario);
        return nuevoUsuario;
    }
    
    @Override
    public Usuario crear(String nombre, int edad) {
        return crear(new Usuario(nombre, edad));
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
        if (index < listaUsuarios.size())
            return listaUsuarios.get(index);
        else
            return null;
    }

    @Override
    public Usuario modificar(int index, Usuario usuarioExistente) {
        Usuario usuario = listaUsuarios.get(index);
        usuario.setEdad(usuarioExistente.getEdad());
        usuario.setNombre(usuarioExistente.getNombre());
        return usuario;
    }

    @Override
    public void eliminar(int index) {
        listaUsuarios.remove(index);
    }

    @Override
    public void eliminar(Usuario ursExistente) {
        listaUsuarios.remove(ursExistente);
    }
}
