package net.cipsa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AppSentParam {
	
	public static void main(String[] args) {
		Datasource ds = null;
		try {
			ds = new Datasource();
			ds.abrirConexion();
			Connection con = ds.getConnection();
			
			// Operaciones contra el origen de datos
			// ---------------------------------------------

			PreparedStatement st = con.prepareStatement("INSERT INTO " + "CLIENTES ( CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN, POBLACIÓN, TELÉFONO, RESPONSABLE, HISTORIAL)"
			+ "VALUES ( ?, ?, ?, ?, ?, ?, ?)");
			
			 
			 st.setString(1,"CT41");
			 st.setString(2,"ARGAZ");
			 st.setString(3, "C/Meliton Perez 1");
			 st.setString(4, "Castro");
			 st.setInt(5, 607305440);
			 st.setString(6, "Administrador");
			 st.setString(7, null); 
			 
			 int regs = st.executeUpdate(); 
			 System.out.println("Registros modificados: " + regs);

		
			System.out.println("OK");
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		} finally {
			if (ds != null)
				ds.cerrarConexion();
		}
	}
}
