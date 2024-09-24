package net.cipsa2;

import java.sql.*;

public class App5_UpdateInsertarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Datasource2 ds = null;
		try {
			ds = new Datasource2();
			ds.abrirConexion();
			Connection con = ds.getConnection();
			Statement st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("SELECT USUARIO, CLAVE, ADMINISTRADOR FROM USUARIOS WHERE FALSE");
			rs.moveToInsertRow(); // Posicion en registro de inserción
			// Asignación de valores a campos de nuevo registro
			rs.updateString("USUARIO", "Petrov1");
			rs.updateString("CLAVE", "5556");
			rs.updateBoolean("ADMINISTRADOR", false); // Guardado de nuevo registro
			rs.insertRow();
			
			System.out.println("ok");

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} finally {
			if (ds != null)
				ds.cerrarConexion();
		}

	}

}
