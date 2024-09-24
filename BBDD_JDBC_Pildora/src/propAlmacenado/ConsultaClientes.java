package propAlmacenado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class ConsultaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			//De esta forma el trabajo se lo estamos delegando al servidor, util para mucho clientes
			CallableStatement miSentencia=miConexion.prepareCall("{call MUESTRA_CLIENTES}");
			ResultSet rs=miSentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));
			}
		} catch (Exception e) {

			System.out.println("No conecta: ");
			e.printStackTrace();

		}

	}

}
