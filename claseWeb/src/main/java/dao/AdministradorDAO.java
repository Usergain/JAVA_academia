package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import conexion.Conexion;
import entidades.Administrador;
import entidades.Persona;

public class AdministradorDAO {

	private static Conexion conexion = new Conexion();
	private static Connection conectar = conexion.conectar();
	private static PreparedStatement psmt = null; // para insertar valores (INSERT)
	private static ResultSet result = null; // para guardar el resultado
	private static Statement smt = null; // para obtener valores (SELECT)

	public boolean insertarAdministrador(Administrador administrador) throws SQLException {

		boolean insertado = false;

		String consulta = "INSERT INTO administrador(id_persona) VALUES (?)";

		psmt = conectar.prepareStatement(consulta);
		psmt.setInt(1, administrador.getId_persona());

		psmt.execute();
		insertado = true;

		return insertado;
	}

}
