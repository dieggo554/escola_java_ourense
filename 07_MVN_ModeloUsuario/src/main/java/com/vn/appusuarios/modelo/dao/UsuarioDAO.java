/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.dao;

import com.vn.appusuarios.modelo.Usuario;
import com.vn.appusuarios.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Modificado principalmente por Alberto
 *
 * @author Equipo 1
 */
public class UsuarioDAO implements IDaoUsuario {

    @Override
    public Usuario obtenerPorEmail(String email) throws Exception {
        try (Connection con = ConexionDerby.getConexion()) {
            Usuario nuevo = null;
            String sqlQuery = "SELECT ID, EMAIL, PASSWORD, NOMBRE, AGE FROM Usuario WHERE EMAIL=?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, email);
            ResultSet resultado = sentenciaSQL.executeQuery();
            while (resultado.next()) {
                Integer id = resultado.getInt(1);
                String password = resultado.getString(3);
                String nombre = resultado.getString(4);
                Integer age = resultado.getInt(5);
                nuevo = new Usuario(id, email, password, nombre, age);
            }
            return nuevo;
        }

    }

    @Override
    public Usuario modificar(int id, String email, String password, String nombre, int age) throws Exception {
        try (Connection con = ConexionDerby.getConexion()) {
            String sqlQuery = "UPDATE Usuario "
                    + "SET EMAIL=?, PASSWORD=?, NOMBRE=?, AGE=? "
                    + "WHERE ID = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, email);
            sentenciaSQL.setString(2, password);
            sentenciaSQL.setString(3, nombre);
            String edad = ((Integer) age).toString();
            sentenciaSQL.setString(4, edad);
            String strId = ((Integer) id).toString();
            sentenciaSQL.setString(5, strId);
            sentenciaSQL.executeUpdate();
            Usuario objConDatosNuevo = obtenerPorIndice(id);
            return objConDatosNuevo;
        }
    }

    @Override
    public boolean eliminarPorEmail(String email) throws Exception {
        return eliminar(obtenerPorEmail(email).getId());
    }

    @Override
    public Usuario crear(Usuario objetoNuevo) throws Exception {
        try (Connection con = ConexionDerby.getConexion()) {
            String sqlQuery = "INSERT INTO Usuario(EMAIL, PASSWORD, NOMBRE, AGE) VALUES (?,?,?,?)";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, objetoNuevo.getEmail());
            sentenciaSQL.setString(2, objetoNuevo.getPassword());
            sentenciaSQL.setString(3, objetoNuevo.getNombre());
            String edad = ((Integer) objetoNuevo.getEdad()).toString();
            sentenciaSQL.setString(4, edad);
            sentenciaSQL.executeUpdate();
            objetoNuevo.setId(obtenerPorEmail(objetoNuevo.getEmail()).getId());
            return objetoNuevo;
        }
    }

    @Override
    public HashMap<Integer, Usuario> obtenerTodos() throws Exception {
        try (Connection con = ConexionDerby.getConexion()) {
            HashMap hashUsuarios = new HashMap();
            String sqlQuery = "SELECT ID, EMAIL, PASSWORD, NOMBRE, AGE FROM USUARIO";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            ResultSet resultado = sentenciaSQL.executeQuery();
            while (resultado.next()) {
                Integer id = resultado.getInt(1);
                String email = resultado.getString(2);
                String password = resultado.getString(3);
                String nombre = resultado.getString(4);
                Integer edad = resultado.getInt(5);
                Usuario nuevo = new Usuario(id, email, password, nombre, edad);
                hashUsuarios.put(id, nuevo);
            }
            return hashUsuarios;
        }
    }

    @Override
    public Usuario obtenerPorIndice(int index) throws Exception {
        try (Connection con = ConexionDerby.getConexion()) {
            Usuario nuevo = null;
            String id = ((Integer) index).toString();
            String sqlQuery = "SELECT ID, EMAIL, PASSWORD, NOMBRE, AGE FROM Usuario WHERE ID=?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, id);
            ResultSet resultado = sentenciaSQL.executeQuery();
            while (resultado.next()) {
                String email = resultado.getString(2);
                String password = resultado.getString(3);
                String nombre = resultado.getString(4);
                Integer age = resultado.getInt(5);
                nuevo = new Usuario(index, email, password, nombre, age);
            }
            return nuevo;
        }
    }

    @Override
    public Usuario modificar(Usuario objConDatosNuevo) throws Exception {

        try (Connection con = ConexionDerby.getConexion()) {
            String sqlQuery = "UPDATE Usuario "
                    + "SET EMAIL=?, PASSWORD=?, NOMBRE=?, AGE=? "
                    + "WHERE ID = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, objConDatosNuevo.getEmail());
            sentenciaSQL.setString(2, objConDatosNuevo.getPassword());
            sentenciaSQL.setString(3, objConDatosNuevo.getNombre());
            String edad = ((Integer) objConDatosNuevo.getEdad()).toString();
            sentenciaSQL.setString(4, edad);
            String id = ((Integer) objConDatosNuevo.getId()).toString();
            sentenciaSQL.setString(5, id);
            sentenciaSQL.executeUpdate();
            objConDatosNuevo = obtenerPorIndice(objConDatosNuevo.getId());
            return objConDatosNuevo;
        }
    }

    @Override
    public boolean eliminar(int index) throws Exception {
        try (Connection con = ConexionDerby.getConexion()) {
            boolean eliminado = false;
            String id = ((Integer) index).toString();
            String sqlQuery = "DELETE FROM Usuario WHERE ID=?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, id);
            sentenciaSQL.executeUpdate();
            eliminado = true;
            return eliminado;
        }
    }

    @Override
    public HashMap<Integer, Usuario> obtenerTodos(String nombre) throws Exception {
        try (Connection con = ConexionDerby.getConexion()) {
            HashMap hashUsuarios = new HashMap();

            if (nombre != "") {
                String sqlQuery = "SELECT ID, EMAIL, PASSWORD, NOMBRE, AGE FROM Usuario WHERE NOMBRE=?";
                PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
                sentenciaSQL.setString(1, nombre);
                ResultSet resultado = sentenciaSQL.executeQuery();
                while (resultado.next()) {
                    Integer id = resultado.getInt(1);
                    String email = resultado.getString(2);
                    String password = resultado.getString(3);
                    Integer edad = resultado.getInt(5);
                    Usuario nuevo = new Usuario(id, email, password, nombre, edad);
                    hashUsuarios.put(id, nuevo);
                }
            } else {
                hashUsuarios = obtenerTodos();
            }
            return hashUsuarios;
        }
    }
}
