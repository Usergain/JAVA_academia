package net.cipsa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

	public static void main(String[] args) {
		Datasource ds = null;
		try {
			ds = new Datasource();
			ds.abrirConexion();
			Connection con = ds.getConnection();
			// Operaciones contra el origen de datos
			// ---------------------------------------------
			// 2.- Crear objeto Statement

			Statement st = con.createStatement();

			// 3. Ejecutar SQL
			// Consultar:
			//ResultSet miResultset = st.executeQuery("SELECT* FROM PRODUCTOS");
			//Insertar:
			//String instruccionSql="INSERT INTO PRODUCTOS (C�DIGOART�CULO, NOMBREART�CULO, PRECIO) VALUES ('AR77', 'PANTAL�N', 25.35)";
			// Modificar:
			//String instruccionSql="UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE C�DIGOART�CULO='AR77'";
			//Borrar:
			String instruccionSql="DELETE FROM PRODUCTOS WHERE C�DIGOART�CULO='AR77'";
			st.executeUpdate(instruccionSql);
			// 4.- Recorrer el Resultset--> En el caso de consulta

			/*while (miResultset.next()) {

				System.out.println(
						miResultset.getString("C�DIGOART�CULO") + "--->" + miResultset.getString("NOMBREART�CULO")
								+ "---> " + miResultset.getDouble("PRECIO") + "--->" + miResultset.getDate("FECHA"));
			}*/
			System.out.println("OK");
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} finally {
			if (ds != null)
				ds.cerrarConexion();
		}
	}
}
