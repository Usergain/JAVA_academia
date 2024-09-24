package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import conexion.Conexion;
import entidades.Empleado;
import entidades.Paciente;
import entidades.Persona;

public class PacienteDAO {

	private static Conexion conexion = new Conexion();
	private static Connection conectar = conexion.conectar();
	private static PreparedStatement psmt = null; // para insertar valores (INSERT)
	private static ResultSet result = null; // para guardar el resultado
	private static Statement smt = null; // para obtener valores (SELECT)

	public boolean insertarPaciente(Paciente paciente) throws SQLException {

		boolean insertado = false;

		String consulta = "INSERT INTO paciente(id_persona) VALUES (?)";

		psmt = conectar.prepareStatement(consulta);
		psmt.setInt(1, paciente.getId_persona());

		psmt.execute();
		insertado = true;

		return insertado;
	}

}
