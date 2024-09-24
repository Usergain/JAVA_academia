package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;
import entidades.Coche;

public class CocheDAO {
	
	private static Conexion conexion = new Conexion();
	private static Connection conectar = conexion.conectar();
	private static PreparedStatement psmt = null; // para insertar valores (INSERT)
	private static ResultSet result = null; // para guardar el resultado
	private static Statement smt = null; // para obtener valores (SELECT)
	
	public boolean insertarAdministrador(Coche coche) throws SQLException {

		boolean insertado = false;

		String consulta = "INSERT INTO coche(id_duenio) VALUES (?)";

		psmt = conectar.prepareStatement(consulta);
		psmt.setString(1, coche.getId_duenio());

		psmt.execute();
		insertado = true;

		return insertado;
	}

}
