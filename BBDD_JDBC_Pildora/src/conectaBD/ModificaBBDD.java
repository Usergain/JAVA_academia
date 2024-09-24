package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			// 1.- Crear conexión

			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			// 2.- Crear objeto Statement

			Statement miStatement = miConexion.createStatement();
			
			//String instruccionSql="INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) VALUES ('AR77', 'PANTALÓN', 25.35)";
			//String instruccionSql="UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";
			String instruccionSql="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77'";
			miStatement.executeUpdate(instruccionSql);
			
			//System.out.println("Datos insertados correctamente");
			//System.out.println("Datos modificados correctamente");
			System.out.println("Datos eliminados correctamente");

		} catch (Exception e) {

			System.out.println("No conecta: ");
			e.printStackTrace();

		}
	}

}
