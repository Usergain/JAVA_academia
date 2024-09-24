package Consultas;

import java.sql.*;
import java.util.ArrayList;

import Conexion.Conexion;
import entidades.Roles;

public class RolesDAO {
	
	public static ArrayList<Roles> listar_roles() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ArrayList<Roles> roles = new ArrayList<Roles>();
		
		Statement scSQL;
		ResultSet rsListaRegistros;
		ResultSetMetaData lsDatos;
		
		Conexion conexion = new Conexion();
		Connection conn = conexion.conectar();
		
		scSQL = conn.createStatement();
		rsListaRegistros = scSQL.executeQuery("SELECT * FROM roles");
		lsDatos = rsListaRegistros.getMetaData();
		
		while (rsListaRegistros.next()) {
			
			int id = Integer.parseInt(rsListaRegistros.getString("id"));
			String nombre = rsListaRegistros.getString("nombre");
			
			Roles r = new Roles(id, nombre);
			roles.add(r);
		}
		
		return roles;
	}
	
	public static Roles rol_dado_id(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Roles rol = null;
		
		Statement scSQL;
		ResultSet rsListaRegistros;
		ResultSetMetaData lsDatos;
		
		Conexion conexion = new Conexion();
		Connection conn = conexion.conectar();
		
		scSQL = conn.createStatement();
		rsListaRegistros = scSQL.executeQuery("SELECT * FROM roles where id = "+id+" LIMIT 1");
		lsDatos = rsListaRegistros.getMetaData();
		
		while (rsListaRegistros.next()) {
			
			int idRol = Integer.parseInt(rsListaRegistros.getString("id"));
			String nombre = rsListaRegistros.getString("nombre");
			
			rol = new Roles(idRol, nombre);
		}
		
		return rol;
	}
	
}
