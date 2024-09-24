package propAlmacenado;

import java.sql.*;

import javax.swing.JOptionPane;

public class Actualiza_Productos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nPrecio=Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
		String nArticulo=JOptionPane.showInputDialog("Introduce nombre articulo");
		
		
		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			CallableStatement miSentencia=miConexion.prepareCall("{call ACTUALIZA_PROD(?,?)}");
			miSentencia.setInt(1, nPrecio);
			miSentencia.setString(2, nArticulo);
			miSentencia.execute();
			System.out.println("Actualizacion OK");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
