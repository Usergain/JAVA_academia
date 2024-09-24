package net.cipsa2;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Datasource2 {

	private String cadenaConexion;
	private Connection con = null;

	public Datasource2() throws Exception {
		String host;
		String user;
		String pass;
		String bd;
		// Apertura del fichero de configuracion
		InputStream isr = Datasource2.class.getResourceAsStream("/config2.properties");
		Properties props = new Properties();
		props.load(isr);
		isr.close();
		// Obtencion de parámetros
		host = (String) props.get("host");
		user = (String) props.get("user");
		pass = (String) props.get("pass");
		bd = (String) props.get("bd");
		// Creacion de la cadena de conexion
		cadenaConexion = "jdbc:mysql://" + host + "/" + bd + "?user=" + user + "&password=" + pass;
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
}


