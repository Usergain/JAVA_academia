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
import entidades.Persona;

public class EmpleadoDAO {

	private static Conexion conexion = new Conexion();
	private static Connection conectar = conexion.conectar();
	private static PreparedStatement psmt = null; // para insertar valores (INSERT)
	private static ResultSet result = null; // para guardar el resultado
	private static Statement smt = null; // para obtener valores (SELECT)

	public boolean insertarEmpleado(Empleado empleado) throws SQLException {

		boolean insertado = false;

		String consulta = "INSERT INTO empleado(id_persona) VALUES (?)";

		psmt = conectar.prepareStatement(consulta);
		psmt.setInt(1, empleado.getId_persona());

		psmt.execute();
		insertado = true;

		return insertado;
	}

	public int obtenerEmpleadoDadoPersonaId(int id) throws SQLException {

		int id_empleado = 0;

		String consulta = "SELECT * FROM empleado WHERE id_persona = "+id+" ORDER BY id_empleado DESC LIMIT 1";
		smt = conectar.createStatement();
		result = smt.executeQuery(consulta);

		while (result.next()) {
			id_empleado = result.getInt("id_empleado");			
		}

		return id_empleado;
	}

}
