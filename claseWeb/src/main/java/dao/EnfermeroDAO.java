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
import entidades.Enfermero;
import entidades.Persona;

public class EnfermeroDAO {

	private static Conexion conexion = new Conexion();
	private static Connection conectar = conexion.conectar();
	private static PreparedStatement psmt = null; // para insertar valores (INSERT)
	private static ResultSet result = null; // para guardar el resultado
	private static Statement smt = null; // para obtener valores (SELECT)

	public boolean insertarEnfermero(Enfermero enfermero, int id_empleado) throws SQLException {

		boolean insertado = false;

		String consulta = "INSERT INTO enfermero(total_test,id_empleado) VALUES (?,?)";

		psmt = conectar.prepareStatement(consulta);
		psmt.setInt(1, enfermero.getTotal_test());
		psmt.setInt(2, id_empleado);

		psmt.execute();
		insertado = true;

		return insertado;
	}

}
