package conexmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class conexionBD {
	private Connection conn = null;
	
	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	//Definimos el controlador de carga.
	private String jdbcName ;
	
	public conexionBD() {
		
		this.dbUrl="jdbc:mysql://localhost:3306/covid";
		this.dbUser="root";
		this.dbPassword="";
		//Definimos el controlador de carga.
		this.jdbcName ="com.mysql.jdbc.Driver";
		
	}
	
	public void conectar()
	{
		if (conn==null) {
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
		}
	}
	
	public void desconectar() {
		if (conn!=null)
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void insertarPersona(String dni, int edad) throws SQLException
	{
		String query="insert into persona(dni,edad) values(?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		
		preparedStmt.setString(1,dni);
		preparedStmt.setInt(2, edad);
		
		//Ejecutar la sentencia en el SGBD
		try {
		preparedStmt.execute();
		}
		catch (Exception ex)
		{
			System.out.println("Primary key repetida, por favor inserte de nuevo!!!");
		}
	}
}