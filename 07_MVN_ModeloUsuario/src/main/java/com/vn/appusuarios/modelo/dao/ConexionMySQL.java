/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * static final de los elementos necesarios para hacer la conexion (url,
 * usuario, contraseña)
 *
 * @author alberto
 */
public class ConexionMySQL {

	private static final String URL = "jdbc:mysql://localhost:3306/db_usuarios";
	private static final String USER = "root";
	private static final String PASS = "abc123.";
	private static boolean driversCargados = false;

	public static Connection getConexion() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Connection con = null;

		if (!driversCargados) {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			driversCargados = true;
		}
		con = DriverManager.getConnection(URL, USER, PASS);

		return con;
	}

	private static void crearDBusuarios() throws SQLException {
		Connection conex = DriverManager.getConnection(URL, USER, PASS);
		Statement stmt = conex.createStatement();
		String createTableSQL = "CREATE TABLE usuario (" + 
				"	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY " + 
				"		(START WITH 1, INCREMENT BY 1)," + 
				"	email VARCHAR(255) NOT NULL," + 
				"	password VARCHAR(50) NOT NULL," + 
				"	nombre VARCHAR(50) NOT NULL," + 
				"	age INTEGER NOT NULL," + 
				"	CONSTRAINT primary_key PRIMARY KEY(id)," + 
				"	CONSTRAINT unique_email UNIQUE(email)" + 
				")";
		stmt.executeUpdate(createTableSQL);
	}
}
