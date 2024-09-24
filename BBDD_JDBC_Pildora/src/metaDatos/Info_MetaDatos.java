package metaDatos;

import java.sql.*;

public class Info_MetaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mostrarInfo_BBDD();
		System.out.println("\n");
		mostrarInfo_Tablas();
	}

	static void mostrarInfo_BBDD() {

		Connection miConexion = null;

		try {

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			// Obtención de metadatos
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			// Mostra información de la BBDD
			System.out.println("Gestor de BBDD: " + datosBBDD.getDatabaseProductName());
			System.out.println("Version del Gestor: " + datosBBDD.getDatabaseProductVersion());
			System.out.println("Nombre del driver: " + datosBBDD.getDriverName());
			System.out.println("Version del driver: " + datosBBDD.getDriverVersion());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la insercion de datos");

			e.printStackTrace();
		} finally {

			try {

				miConexion.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static void mostrarInfo_Tablas() {

		Connection miConexion = null;
		ResultSet miResultset=null;

		try {

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			System.out.println("Lista de tablas: ");
			miResultset=datosBBDD.getTables("pruebas", null, null, null);// si lo dejamos en null es genérico, si cambias esos parámetros afinas la busqueda
			
			while(miResultset.next()) {
				
				System.out.println(miResultset.getString("TABLE_NAME"));
			}
			
			//Lista de columnas de Productos
			
			System.out.println(" ");
			System.out.println("Campos de Productos");
			miResultset=datosBBDD.getColumns("pruebas", null, "productos", null);

			while (miResultset.next()) {

				System.out.println(miResultset.getString("COLUMN_NAME"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la insercion de datos");

			e.printStackTrace();
			
		} finally {

			try {

				miConexion.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
