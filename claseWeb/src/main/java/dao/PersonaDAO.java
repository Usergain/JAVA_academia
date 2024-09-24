package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import conexion.Conexion;
import entidades.Persona;

public class PersonaDAO {

	private static Conexion conexion = new Conexion();
	private static Connection conectar = conexion.conectar();
	private static PreparedStatement psmt = null; // para insertar valores (INSERT)
	private static ResultSet result = null; // para guardar el resultado
	private static Statement smt = null; // para obtener valores (SELECT)

	public boolean insertarPersona(Persona persona) throws SQLException {

		boolean insertado = false;

		String consulta = "INSERT INTO persona(dni,edad) VALUES (?,?)";

		psmt = conectar.prepareStatement(consulta);
		psmt.setString(1, persona.getDni());
		psmt.setInt(2, persona.getEdad());

		psmt.execute();
		insertado = true;

		return insertado;
	}

	public boolean verificarUsuario(String dni) throws SQLException {

		boolean existe = false;
		Persona p = null;

		String consulta = "SELECT * FROM persona WHERE dni = '" + dni + "'";
		smt = conectar.createStatement();
		result = smt.executeQuery(consulta);

		while (result.next()) {
			p = new Persona(result.getString("dni"), result.getInt("edad"));
		}

		if (p != null) {
			existe = true;
		}

		return existe;
	}

	public Persona obtenerUltimaPersona() throws SQLException {

		Persona p = null;

		String consulta = "SELECT * FROM persona ORDER BY id_persona DESC LIMIT 1";
		smt = conectar.createStatement();
		result = smt.executeQuery(consulta);

		while (result.next()) {
			p = new Persona(result.getInt("id_persona"),result.getString("dni"), result.getInt("edad"));
		}

		return p;
	}
	
	public ArrayList<Persona> listarUsuarios() throws SQLException{
		
		ArrayList<Persona> personas = new ArrayList<Persona>(); // array vacío de Personas
		Persona p = null; // variable persona
		
		String consulta = "SELECT * FROM persona";
		smt = conectar.createStatement();
		result = smt.executeQuery(consulta);
		
		while (result.next()) {
			p = new Persona(result.getInt("id_persona"),result.getString("dni"), result.getInt("edad"));
			personas.add(p); // insertar persona a la lista de Personas
		}
		
		return personas;
		
	}

}
