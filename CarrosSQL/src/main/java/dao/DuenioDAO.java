package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import entidades.Coche;
import entidades.Duenio;

public class DuenioDAO {

	private static Conexion conexion = new Conexion();
	private static Connection conectar = conexion.conectar();
	private static PreparedStatement psmt = null; // para insertar valores (INSERT)
	private static ResultSet result = null; // para guardar el resultado
	private static Statement smt = null; // para obtener valores (SELECT)

	public boolean insertarDuenio(Duenio duenio) throws SQLException {

		boolean insertado = false;

		String consulta = "INSERT INTO duenio(id_duenio) VALUES (?)";

		psmt = conectar.prepareStatement(consulta);
		psmt.setString(1, duenio.getId_duenio());

		psmt.execute();
		insertado = true;

		return insertado;
	}

	public boolean verificarUsuario(String id_duenio) throws SQLException {

		boolean existe = false;
		Duenio d = null;

		String consulta = "SELECT * FROM duenio WHERE dni = '" +id_duenio + "'";
		smt = conectar.createStatement();
		result = smt.executeQuery(consulta);

		while (result.next()) {
			d = new Duenio(result.getString("id_duenio"), ("nombre"), ("apellido"), ("fecha_nacimiento"), ("domicilio"));
		}

		if (d != null) {
			existe = true;
		}

		return existe;
	}

	public Duenio obtenerUltimaDuenio() throws SQLException {

		Duenio d = null;

		String consulta = "SELECT * FROM duenio ORDER BY id_duenio DESC LIMIT 1";
		smt = conectar.createStatement();
		result = smt.executeQuery(consulta);

		while (result.next()) {
			d = new Duenio(result.getString("id_duenio"), ("nombre"), ("apellido"), ("fecha_nacimiento"), ("domicilio"));
		}

		return d;
	}
	
	public Duenio obtenerDuenio(String id_duenio) throws SQLException {

		Duenio d = null;

		String consulta = "SELECT * FROM duenio WHERE dni = '" +id_duenio + "'";
		smt = conectar.createStatement();
		result = smt.executeQuery(consulta);

		while (result.next()) {
			d = new Duenio(result.getString("id_duenio"), ("nombre"), ("apellido"), ("fecha_nacimiento"), ("domicilio"));
		}

		return d;
	}

	public ArrayList<Duenio> listarUsuarios() throws SQLException{

		ArrayList<Duenio> personas = new ArrayList<Duenio>(); // array vacío de Personas
		Duenio d = null; // variable persona

		String consulta = "SELECT * FROM persona";
		smt = conectar.createStatement();
		result = smt.executeQuery(consulta);

		while (result.next()) {
			d = new Duenio(result.getString("id_duenio"), ("nombre"), ("apellido"), ("fecha_nacimiento"), ("domicilio"));
			personas.add(d); // insertar persona a la lista de Personas
		}

		return personas;

	}

}
