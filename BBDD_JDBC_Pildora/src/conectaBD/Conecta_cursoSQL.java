package conectaBD;

import java.sql.*;
import javax.sql.*;

public class Conecta_cursoSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		//1.- Crear conexión
			
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql","root","");
			
		//2.- Crear objeto Statement
			
			Statement miStatement=miConexion.createStatement();
			
		//3. Ejecutar SQL
			
			ResultSet miResultset=miStatement.executeQuery("SELECT* FROM PRODUCTOS");
			
		//4.- Recorrer el Resultset
			
			while(miResultset.next()) {
				
				System.out.println(miResultset.getString("CÓDIGOARTÍCULO") +"--->"+ miResultset.getString("NOMBREARTÍCULO") + "---> " + miResultset.getDouble("PRECIO")
				+"--->"+ miResultset.getDate("FECHA"));
			}
			
		}catch(Exception e){
			
			System.out.println("No conecta: ");
			e.printStackTrace();
			
		}
	}

}
