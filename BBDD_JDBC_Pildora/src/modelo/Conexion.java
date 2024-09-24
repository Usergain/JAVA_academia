package modelo;

import java.sql.*;

public class Conexion {
	
	Connection miConexion=null;
	
	public Conexion() {
		
		
	}

	public Connection dameConexion() {
		
		try {
			
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql","root","");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return miConexion;
	}
}
