package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
		
		private Connection conectar = null;
		private final String url = "jdbc:mysql://localhost/garaje";
		private final String usuario = "root";
		private final String password = "";
		
		public Connection conectar() {
			
			try {
				conectar = DriverManager.getConnection(url, usuario, password);
			} catch (SQLException ex) {
				System.out.println("Error al abrir Conexión: " + ex.getMessage());
			}
			
			return conectar;
		}
		
}
