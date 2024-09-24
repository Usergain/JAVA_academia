package net.cipsa2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;

public class App3_CampoNull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Datasource2 ds = null;

		try {

			ds = new Datasource2();
			ds.abrirConexion();
			Connection con = ds.getConnection();

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("SELECT USUARIO, CLAVE, ADMINISTRADOR FROM USUARIOS");
			while (rs.next()) {
				System.out.println("USUARIO: " + rs.getString("USUARIO"));
				// El campo clave es nulo?
				if (rs.getObject("CLAVE") != null)
					System.out.println("CLAVE:" + rs.getString("CLAVE")); // NO es nulo
				else
					System.out.println("USUARIO ANONIMO"); // Si es nulo
				System.out.println("ADMINISTRADOR: " + rs.getBoolean("ADMINISTRADOR"));
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} finally {
			if (ds != null)
				ds.cerrarConexion();
		}

	}

}
