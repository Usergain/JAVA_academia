package net.cipsa.mensajeria.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import net.cipsa.mensajeria.modelo.entidades.Mensaje;
import net.cipsa.mensajeria.modelo.entidades.Usuario;

public class Usuarios {

	private static final String QUERY = "SELECT * FROM USUARIOS";
	private static final String QUERY2 = "SELECT * FROM USUARIOS WHERE USUARIO=?";
	private static final String INSERT = "INSERT INTO USUARIOS(USUARIO,CLAVE,ADMINISTRADOR) VALUES(?,?,?)";
	private static final String MODIFICAR= "UPDATE USUARIOS SET CLAVE=?, ADMINISTRADOR=? WHERE USUARIO = ?";
	private Datasource ds;
	
	Usuarios(Datasource _ds){
		this.ds = _ds;
	}
	
	/*public void modificar(String usuario){
		
		Usuario u = null;
		
		try {
			u=obtener(usuario);
			System.out.println("el campo marcado entra " + u);
			ds.abrirConexion();
			Connection con = ds.getConnection();
			Statement st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			//PreparedStatement st = con.prepareStatement(MODIFICAR);
			//st.setString(1, u.getNombre());
			st.executeUpdate(MODIFICAR);
			//ResultSet rs = st.executeQuery(QUERY2);
			rs.moveToInsertRow();
			if(rs.next()) {
				rs.updateString(1, u.getClave());
				rs.updateBoolean(2, u.isAdministrador());
				rs.updateString(3, u.getNombre());
				rs.updateRow();
			}else {
				System.out.println("No hay ningún usuario con ese nombre.");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	public Usuario obtener(String usuario) throws Exception {

		Usuario u = null;
		

		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			//PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE USUARIO='" + usuario + "' LIMIT 1 ");
			PreparedStatement ps = con.prepareStatement(QUERY2);
			ps.setString(1, usuario);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String nom = rs.getString("USUARIO");
				String pass = rs.getString("CLAVE");
				int admin = rs.getInt("ADMINISTRADOR");
				boolean administrador = false;
				if (admin == 1) {
					administrador = true;
				}

				u = new Usuario(administrador, pass, nom);
			}

		} catch (Exception e) {

			throw e;
		} finally {
			ds.cerrarConexion();
		}

		return u;
	}
	
	public void insertar(Usuario objUsuario) throws SQLException {

		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(INSERT);
			st.setString(1, objUsuario.getNombre());
			st.setString(2, objUsuario.getClave());
			st.setBoolean(3, objUsuario.isAdministrador());
			st.executeUpdate();

		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}
	
	public void modificar(Usuario objUsuario) throws SQLException {

		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(MODIFICAR);
			
			st.setString(1, objUsuario.getClave());
			st.setBoolean(2, objUsuario.isAdministrador());
			st.setString(3, objUsuario.getNombre());
			st.executeUpdate();

		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}
	
	public Usuario[] listar()throws SQLException{
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(QUERY);
			while (rs.next()) {
				usuarios.add(getUsuarioObject(rs));
			}
			return usuarios.toArray(new Usuario[usuarios.size()]);

		} catch (Exception e) {
			throw e;
		} finally {
			ds.cerrarConexion();
		}
		
	}
	
	public Usuario getUsuarioObject(ResultSet rs) throws SQLException {
		Usuario objUsuario = new Usuario();
		objUsuario.setNombre(rs.getString("USUARIO"));
		objUsuario.setClave(rs.getString("CLAVE"));
		objUsuario.setAdministrador(rs.getBoolean("ADMINISTRADOR"));
		
		return objUsuario;
	}
	

}
