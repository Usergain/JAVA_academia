package conexmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ppal {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		conexionBD db=new conexionBD();

		db.conectar();
		db.insertarPersona("Y4904844Q",30);
		db.desconectar();
		
		/*Scanner milector = new Scanner(System.in);
		// Conexion
		Connection conn = null;
		
		String dbUrl="jdbc:mysql://localhost:3306/lae";
		String dbUser="root";
		String dbPassword="123456";
		//Definimos el controlador de carga.
		String jdbcName ="com.mysql.jdbc.Driver";
		
	/*	
		int numero=0;
		
		try {
			System.out.println("Dame un numero: ");
			numero = milector.nextInt();
			
		} catch (Exception e)
		{
			System.out.println("Por favor introduce un valor numerico: ");
			
		}
		
		System.out.println("El numero que has introducido es: "+numero);
		*/
		
		/*
		// Cargamos el controlador.
		try {
			Class.forName(jdbcName);
		}catch (Exception e)
		{
			System.out.println("Problemas con el controlador de JDBC!");
		}
		try
		{
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		}
		catch(SQLException ex)
		{
			System.out.println("!Error al conectarse a la base de datos!");
		}
		
		*/
		/*
		Statement comando = conn.createStatement();
		ResultSet registros=comando.executeQuery("select * from autor");
		while (registros.next())
		{
			System.out.println("Id del autor: "+ registros.getString("id_autor"));
			System.out.println("Nombre del autor: "+registros.getString("nombre_autor"));
			System.out.println("Apellidos del autor: "+registros.getString("apellidos_autor"));
			System.out.println("Nacionalidad del autor: "+registros.getString("nacionalidad_autor"));
			System.out.println("F. Nacimiento del autor: "+registros.getString("fecha_nacimiento"));
		}
		
		String query="insert into autor(id_autor,nombre_autor,apellidos_autor,nacionalidad_autor,fecha_nacimiento) values(?,?,?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		
		preparedStmt.setInt(1, 1005);
		String elnombre;
		System.out.println("Usuario dame un nombre: ");
		elnombre=milector.nextLine();
		preparedStmt.setString(2, elnombre);
		preparedStmt.setString(3, "de Cervantes Saavedra");
		preparedStmt.setString(4, "España");
		preparedStmt.setString(5, "3/12/1900");
		
		//Ejecutar la sentencia en el SGBD
		try {
		preparedStmt.execute();
		}
		catch (Exception ex)
		{
			System.out.println("Primary key repetida, por favor inserte de nuevo!!!");
		}
		
		comando = conn.createStatement();
		registros=comando.executeQuery("select * from autor");
		while (registros.next())
		{
			System.out.println("Id del autor: "+ registros.getString("id_autor"));
			System.out.println("Nombre del autor: "+registros.getString("nombre_autor"));
			System.out.println("Apellidos del autor: "+registros.getString("apellidos_autor"));
			System.out.println("Nacionalidad del autor: "+registros.getString("nacionalidad_autor"));
			System.out.println("F. Nacimiento del autor: "+registros.getString("fecha_nacimiento"));
		}
		
		conn.close();*/
		
		
	}

}