package net.cipsa2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;

public class App4_UpdateModificarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Datasource2 ds = null;
		try {
			ds = new Datasource2();
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(
					"SELECT USUARIO, CLAVE, ADMINISTRADOR " + "FROM USUARIOS WHERE USUARIO = ?",
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			st.setString(1, "Fermin"); // Asignacion de valor para parametro.
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				// Campo modificado
				rs.updateString("CLAVE", "9876");
				// Modificación de registro confirmada.
				rs.updateRow();
				// rs.deleteRow(); Para borrar registro
			}
			System.out.println("OK");
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} finally {
			if (ds != null)
				ds.cerrarConexion();
		}
	}

}


