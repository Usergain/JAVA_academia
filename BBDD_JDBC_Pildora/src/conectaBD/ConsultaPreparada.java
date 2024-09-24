package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.-CREAR CONEXION
		
		try {
			
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql","root","");
			
		//2.- CREAR OBJETO PREPAREDSTATEMENT
			
			PreparedStatement miSentencia=miConexion.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS" 
			+ " WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");
			
		//3.- ESTABLECER PARÁMETROS DE CONSULTA
			
			miSentencia.setString(1, "deportes");
			miSentencia.setString(2, "USA");
			
		//4.- EJECUTAR Y RECORRER CONSULTA
			
			ResultSet rs=miSentencia.executeQuery();
			
		//5.- RECORRE LA TABLA VIRTUAL(RESULSET)
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
			
			// 5.- REUTILIZACION CONSULTA
			System.out.println("EJECUCION SEGUNDA CONSULTA");
			System.out.println("");

			miSentencia.setString(1, "cerámica");
			miSentencia.setString(2, "china");

			// 4.- EJECUTAR Y RECORRER CONSULTA

			rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
