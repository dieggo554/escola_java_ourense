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
public class ConexionDerby {

//     private static final String URL = "jdbc:derby://localhost:1527/06_ModeloUsuariosBBDD";
	private static final String URL = "jdbc:derby:memory:06_ModeloUsuariosBBDD;create=true";
	private static final String USER = "root";
	private static final String PASS = "abc123.";
	private static boolean driversCargados = false;

//    public Connection ConexionDerby(){
//        
//    }

	public static Connection getConexion() throws ClassNotFoundException, SQLException {
		Connection con = null;

		if (!driversCargados) {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
//			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			crearDBusuarios();
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
