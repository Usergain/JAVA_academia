package net.cipsa.mensajeria.modelo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Datasource {
	private String cadenaConexion;
	private Connection con = null;

	public Datasource() throws Exception {
		String host;
		String user;
		String pass;
		String bd;
		// Apertura del fichero de configuracion
		InputStream isr = Datasource.class.getResourceAsStream("/configMensajeria.properties");
		Properties props = new Properties();
		props.load(isr);
		isr.close();
		// Obtencion de parametros
		host = (String) props.get("host");
		user = (String) props.get("user");
		pass = (String) props.get("pass");
		bd = (String) props.get("bd");
		// Creacion de la cadena de conexion
		cadenaConexion = "jdbc:mysql://" + host + "/" + bd + "?user=" + user + "&password=" + pass
				+ "&serverTimezone=UTC";
	}

	public Connection getConnection() {
		return con;
	}

	public void abrirConexion() throws SQLException {
		if (con != null)
			con.close();
		con = DriverManager.getConnection(cadenaConexion);
	}

	public void cerrarConexion() {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (SQLException ex) {
		}
	}

	public Mensajes getMensajes() {
		return new Mensajes(this);
	}
	
	public Usuarios getUsuarios() {
		return new Usuarios(this);
	}
}