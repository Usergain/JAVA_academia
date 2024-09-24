package net.cipsa.academia.modelo;

import net.cipsa.academia.modelo.entidades.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Profesores {

	public static final int FILTRAR_NOMBRE = 0;
	public static final int FILTRAR_APELLIDO = 1;
	public static final int FILTRAR_DNI = 2;
	// SQL de obtencion de registros de profesores
	private static final String QUERY = "SELECT DNI, NOMBRE, APELLIDOS, EDAD, ALTA, ACTIVO FROM PROFESORES";
	// SQL de insercion de registro de profesor
	private static final String INSERT = "INSERT INTO PROFESORES( DNI, NOMBRE, APELLIDOS, EDAD, ALTA, ACTIVO ) VALUES (?, ?, ?, ?, ?, ? )";
	// SQL de modificacion de registro de profesor
	private static final String UPDATE = "UPDATE PROFESORES SET DNI = ?, NOMBRE = ?, APELLIDOS = ?, EDAD = ?, ALTA = ?,ACTIVO = ? WHERE DNI = ?";
	// SQL de eliminacion de registro de profesor
	private static final String DELETE = "DELETE FROM PROFESORES WHERE DNI = ?";
	// Condicionales para las SQL para filtrar los datos por nombre, apellidos y
	// DNI.
	private static final String[] QUERY_FILTROS = { QUERY + " WHERE NOMBRE LIKE ?", QUERY + " WHERE APELLIDOS LIKE ?",
			QUERY + " WHERE DNI LIKE ?" };
	// Origen de datos
	private Datasource ds;

	// Constructor interno – llamado desde el método getProfesores() de la clase
	// Datasource
	Profesores(Datasource _ds) {
		ds = _ds;
	}

	// Inserta en tabla PROFESORES un nuevo registro con los datos del objeto
	// Profsor.
	public void insertar(Profesor objProfesor) throws SQLException {

		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(INSERT);
			st.setString(1, objProfesor.getDNI());
			st.setString(2, objProfesor.getNombre());
			st.setString(3, objProfesor.getApellido());
			st.setInt(4, objProfesor.getEdad());
			st.setDate(5, new java.sql.Date(objProfesor.getAlta().getTime()));
			st.setBoolean(6, objProfesor.isActivo());
			st.executeUpdate();

		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}

	// Elimina en la base de datos el registro con los datos del profesor
	// indicado
	public void eliminar(Profesor objProfesor) throws SQLException {

		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(DELETE);
			st.setString(1, objProfesor.getDNI());
			st.executeUpdate();
		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}

	// Actualiza en la base de datos un nuevo registro con los datos del objeto
	// Profesor.
	public void actualizar(Profesor objProfesor) throws SQLException {
		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(UPDATE);
			st.setString(1, objProfesor.getDNI());
			st.setString(2, objProfesor.getNombre());
			st.setString(3, objProfesor.getApellido());
			st.setInt(4, objProfesor.getEdad());
			st.setDate(5, new java.sql.Date(objProfesor.getAlta().getTime()));
			st.setBoolean(6, objProfesor.isActivo());
			st.setString(7, objProfesor.getDNI());
			st.executeUpdate();
		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}

	public Profesor[] listar() throws SQLException {
		ArrayList<Profesor> profesores = new ArrayList<>();
		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(QUERY);
			while (rs.next()) {
				profesores.add(getProfesorObject(rs));
			}
			return profesores.toArray(new Profesor[profesores.size()]);
		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}

	public Profesor[] filtrar(int tipo_filtro, String valor) throws SQLException {
		ArrayList<Profesor> profesores = new ArrayList<>();
		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(QUERY_FILTROS[tipo_filtro]);
			st.setString(1, valor + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				profesores.add(getProfesorObject(rs));
			}
			return profesores.toArray(new Profesor[profesores.size()]);
		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}

	public Profesor getProfesorObject(ResultSet rs) throws SQLException {
		Profesor objProfesor = new Profesor();
		objProfesor.setDNI(rs.getString("DNI"));
		objProfesor.setNombre(rs.getString("NOMBRE"));
		objProfesor.setApellido(rs.getString("APELLIDOS"));
		objProfesor.setEdad(rs.getInt("EDAD"));
		objProfesor.setAlta(rs.getDate("ALTA"));
		objProfesor.setActivo(rs.getBoolean("ACTIVO"));
		return objProfesor;
	}

}
