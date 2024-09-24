package transacciones;

import java.sql.*;

import javax.swing.JOptionPane;

public class Transaccion_Productos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection miConexion = null;
		try {

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			miConexion.setAutoCommit(false);
			Statement miStatement = miConexion.createStatement();

			String instruccionSql_1 = "DELETE FROM PRODUCTOS WHERE PA�SDEORIGEN='ITALIA'";
			String instruccionSql_2 = "DELETE FROM PRODUCTOS WHERE PRECIO>300";
			String instruccionSql_3 = "UPDATE PRODUCTOS SET PRECIO=PRECIO*1.15";

			boolean ejecutar = ejecutar_transaccion();
			if (ejecutar) {

				miStatement.executeUpdate(instruccionSql_1);
				miStatement.executeUpdate(instruccionSql_2);
				miStatement.executeUpdate(instruccionSql_3);
				miConexion.commit();
				
				System.out.println("Se ejecut� la transacci�n correctamente");
			} else {

				System.out.println("No se realizo ning�n cambio en la BBDD");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {

				miConexion.rollback();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Error en la insercion de datos");

		}

	}

	static boolean ejecutar_transaccion() {
		
		String ejecucion=JOptionPane.showInputDialog("�Ejecutamos transacci�n?");
		
		if(ejecucion.equals("S�")) return true;
		
		else return false;
	}

}
