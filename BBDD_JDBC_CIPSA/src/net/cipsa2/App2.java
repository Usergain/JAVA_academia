package net.cipsa2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Datasource2 ds = null;

		try {

			ds = new Datasource2();
			ds.abrirConexion();
			Connection con = ds.getConnection();

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("SELECT IDMENSAJES, USUARIO_ORIGEN, USUARIO_DESTINO, ASUNTO, TEXTO, LEIDO, FECHA FROM MENSAJES");

			while (rs.next()) {
				
				System.out.println("ID_MENSAJE: " + rs.getInt("IDMENSAJES"));
				System.out.println("USUARIO ORIGEN: " + rs.getString("USUARIO_ORIGEN"));
				System.out.println("USUARIO DESTINO: " + rs.getString("USUARIO_DESTINO"));
				System.out.println("ASUNTO: " + rs.getString("ASUNTO"));
				System.out.println("CONTENIDO: " + rs.getString("TEXTO"));
				System.out.println("LEIDO: " + rs.getBoolean("LEIDO"));
				Date dt = new Date(rs.getTimestamp("FECHA").getTime());
				System.out.println("FECHA: " + DateFormat.getDateInstance().format(dt));
				
				System.out.println("Datos introducidos correctamente");
			}

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} finally {
			if (ds != null)
				ds.cerrarConexion();
		}
		
	}

}
