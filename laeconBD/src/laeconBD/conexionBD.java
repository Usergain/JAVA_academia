package laeconBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class conexionBD {

	private Connection conn = null;

	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	// Definimos el controlador de carga.
	private String jdbcName;

	public conexionBD() {

		dbUrl = "jdbc:mysql://localhost:3306/mydb";
		dbUser = "root";
		dbPassword = "";
		// Definimos el controlador de carga.
		jdbcName = "com.mysql.jdbc.Driver";

	}

	public void conectar() {
		if (conn == null) {
			try {
				Class.forName(jdbcName);
			} catch (Exception e) {
				System.out.println("Problemas con el controlador de JDBC!");
			}
			try {
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			} catch (SQLException ex) {
				System.out.println("!Error al conectarse a la base de datos!");
			}
		}
	}

	public void desconectar() {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void insertarAutor(int id, String nombre, String apellidos, String nacionalidad, String f_nacimiento)
			throws SQLException {
		String query = "insert into autor(id_autor,nombre_autor,apellidos_autor,nacionalidad_autor,fecha_nacimiento) values(?,?,?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);

		preparedStmt.setInt(1, id);

		preparedStmt.setString(2, nombre);
		preparedStmt.setString(3, apellidos);
		preparedStmt.setString(4, nacionalidad);
		preparedStmt.setString(5, f_nacimiento);

		// Ejecutar la sentencia en el SGBD
		try {
			preparedStmt.execute();
		} catch (Exception ex) {
			System.out.println("Primary key repetida, por favor inserte de nuevo!!!");
		}
	}

	public boolean comprobaridAutor(int id) throws SQLException {
		boolean valor = false;
		Statement stmt = null;
		String query = "Select id_autor from autor where id_autor=" + id;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rset = stmt.executeQuery(query);
		// Lo ideal no es que un metodo de una clase tenga e/s desde el propio metodo.
		while (rset.next()) {
			valor = true;

		}
		return valor;
	}

	public void eliminarAutor(Autor a) throws SQLException {
		String query = "Delete from autor where idautor=" + a.getIdautor();
		PreparedStatement preparedStmt = conn.prepareStatement(query);

		// Ejecutar la sentencia en el SGBD
		try {
			preparedStmt.execute();
		} catch (Exception ex) {
			System.out.println("Fallo en la modificacion");
		}
	}

	public void modificarAutor(Autor a) throws SQLException {

		String query = "Update autor set nombre='" + a.getNombre() + "', apellidos='" + a.getApellidos()
				+ "', nacionalidad='" + a.getNacionalidad() + "', fnacimiento='" + a.getFnacimiento()
				+ "' where idautor=" + a.getIdautor();
		PreparedStatement preparedStmt = conn.prepareStatement(query);

		// Ejecutar la sentencia en el SGBD
		try {
			preparedStmt.execute();
		} catch (Exception ex) {
			System.out.println("Fallo en la modificacion");
		}

	}

	public Autor obtenerDatosAutor(int id) throws SQLException {
		Autor elautor = null;
		boolean valor = false;
		Statement stmt = null;
		String query = "Select * from autor where idautor=" + id;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rset = stmt.executeQuery(query);
		// Lo ideal no es que un metodo de una clase tenga e/s desde el propio metodo.
		while (rset.next()) {
			elautor = new Autor(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
					rset.getString(5));

		}
		return elautor;
	}

	public void insertarAutor1(Autor a) throws SQLException {
		if (!comprobaridAutor(a.getIdautor())) {
			String query = "insert into autor(id_autor,nombre_autor,apellidos_autor,nacionalidad_autor,fecha_nacimiento_autor) values(?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);

			preparedStmt.setInt(1, a.getIdautor());
			preparedStmt.setString(2, a.getNombre());
			preparedStmt.setString(3, a.getApellidos());
			preparedStmt.setString(4, a.getNacionalidad());
			preparedStmt.setString(5, a.getFnacimiento());

			// Ejecutar la sentencia en el SGBD
			try {
				preparedStmt.execute();
				
				JOptionPane.showConfirmDialog(null, "Autor insertado en BD", "Insertado!", JOptionPane.DEFAULT_OPTION);			
				
				
			} catch (Exception ex) {
				JOptionPane.showConfirmDialog(null, "Primary key repetida, por favor inserte de nuevo!", "ERROR!", JOptionPane.DEFAULT_OPTION);		
				
			}
		} else {
			JOptionPane.showConfirmDialog(null, "No se puede insertar al autor porque la clave esta duplicada", "ERROR!", JOptionPane.DEFAULT_OPTION);		
		}
	}

	public void seleccionarAutores() throws SQLException {
		Statement stmt = null;
		String query = "Select * from autor";
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rset = stmt.executeQuery(query);
		// Lo ideal no es que un metodo de una clase tenga e/s desde el propio metodo.
		while (rset.next()) {
			System.out.println("Id autor: " + rset.getInt(1));
			System.out.println("Nombre: " + rset.getString(2));
			System.out.println("Apellidos: " + rset.getString(3));
			System.out.println("Nacionalidad: " + rset.getString(4));
			System.out.println("F. Nacimiento: " + rset.getString(5));
		}

	}
	
	
	public void insertarEditorial(Editorial editorial)
			throws SQLException {
		
		String query = "insert into editorial(id_editorial,nombre_editorial,nacionalidad_editorial) values(?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);

		preparedStmt.setInt(1, editorial.getId());
		preparedStmt.setString(2, editorial.getNombre());
		preparedStmt.setString(3, editorial.getNacionalidad());

		// Ejecutar la sentencia en el SGBD
		try {
			preparedStmt.execute();
			
			JOptionPane.showConfirmDialog(null, "Editorial insertada en BD", "Insertar Editorial", JOptionPane.DEFAULT_OPTION);			
			
			
		} catch (Exception ex) {
			JOptionPane.showConfirmDialog(null, "Primary key repetida, por favor inserte de nuevo!", "ERROR!", JOptionPane.DEFAULT_OPTION);		
			
		}
	}
	
	public ArrayList<Autor> listarAutores() throws SQLException {
		
		Autor elautor = null;
		boolean valor = false;
		Statement stmt = null;
		
		ArrayList<Autor> autores = new ArrayList<Autor>();
		
		String query = "Select * from autor";
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rset = stmt.executeQuery(query); // ejecutamos la consulta y guardamos el resultado
		
		// Lo ideal no es que un metodo de una clase tenga e/s desde el propio metodo.
		
		while (rset.next()) {
			elautor = new Autor(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
					rset.getString(5));
			autores.add(elautor);

		}
		
		return autores;
	}
	
	public ArrayList<Editorial> listarEditoriales() throws SQLException {
		
		Editorial editorial = null;
		boolean valor = false;
		Statement stmt = null;
		
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		
		String query = "Select * from editorial";
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rset = stmt.executeQuery(query); // ejecutamos la consulta y guardamos el resultado
		
		// Lo ideal no es que un metodo de una clase tenga e/s desde el propio metodo.
		
		while (rset.next()) {
			editorial = new Editorial(rset.getInt(1), rset.getString(2), rset.getString(3));
			editoriales.add(editorial);
		}
		
		return editoriales;
	}
	
	public void insertarLibro(Libro libro) throws SQLException {
		
		String query = "insert into libro(id_libro,paginas,titulo,autor_id,editorial_id) values(?,?,?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);

		preparedStmt.setInt(1, libro.getId());
		preparedStmt.setInt(2, libro.getPaginas());
		preparedStmt.setString(3, libro.getTitulo());
		preparedStmt.setInt(4, libro.getAutor().getIdautor());
		preparedStmt.setInt(5, libro.getEditorial().getId());

		// Ejecutar la sentencia en el SGBD
		try {
			preparedStmt.execute();
			
			JOptionPane.showConfirmDialog(null, "Libro insertado en BD", "Insertar Libro", JOptionPane.DEFAULT_OPTION);			
			
			
		} catch (Exception ex) {
			JOptionPane.showConfirmDialog(null, "Primary key repetida, por favor inserte de nuevo!", "ERROR!", JOptionPane.DEFAULT_OPTION);		
			
		}
	}

	
}
