package transacciones;

import java.sql.*;

public class Inserta_Clientes_Pedidos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection miConexion=null;
		try {

			miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			miConexion.setAutoCommit(false); //Para tratarlo como bloque, se ejecutan todas o ninguna
			Statement miStatement=miConexion.createStatement();
			String instruccionSql_1="INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'C/AJURIAGUERRA') ";
			miStatement.executeUpdate(instruccionSql_1);
			String instruccionSql_2="INSERT INTO PEDIDOS (NÚMERODEPEDIDO, CÓDIGOCLIENTE, FECHADEPEDIDO) VALUES ('82', 'CT84', '2000/02/16') ";
			miStatement.executeUpdate(instruccionSql_2);
			miConexion.commit();//Si sale bien se ejecutará en bloque
			
			System.out.println("Dastos insertados correctamente");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la insercion de datos");
			
			try {
				
				miConexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
}
