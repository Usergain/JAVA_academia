package net.cipsa.mensajeria.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import net.cipsa.mensajeria.modelo.entidades.Mensaje;
import net.cipsa.mensajeria.modelo.entidades.Usuario;

public class Mensajes {
	
	private static final String QUERY = "SELECT USUARIO_ORIGEN, USUARIO_DESTINO, ASUNTO, LEIDO, FECHA, CONTENIDO FROM MENSAJES";
	private static final String INSERT = "INSERT INTO MENSAJES (ASUNTO, FECHA, LEIDO, USUARIO_DESTINO, USUARIO_ORIGEN, CONTENIDO) VALUES (?, ?, ?, ?, ?, ?)";
	//private static final String UPDATE = "UPDATE MENSAJES SET ASUNTO=?, CONTENIDO=?, FECHA=?, ID=?, LEIDO=?, USUARIO_DESTION=?, USUARIO_ORIGEN=? WHERE ID=? ";
	private static final String DELETE = "DELETE FROM MENSAJES WHERE IDMENSAJES=?";
	private static final String OBTENER = "SELECT USUARIO_ORIGEN, USUARIO_DESTINO, ASUNTO, LEIDO, FECHA, CONTENIDO FROM MENSAJES WHERE USUARIO_DESTINO=?";
	private static final String[] QUERY_FILTROS = { QUERY + " WHERE USUARIO_ORIGEN ?"};
	private Datasource ds;
	
	Mensajes(Datasource _ds){
		this.ds = _ds;
	}
	
	public void insertar(Mensaje objMensaje) throws SQLException {

		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(INSERT);
			st.setString(1, objMensaje.getAsunto());
			st.setDate(2, new java.sql.Date(objMensaje.getFecha().getTime()));
			st.setBoolean(3, objMensaje.isLeido());
			st.setString(4, objMensaje.getUsuario_destino());
			st.setString(5, objMensaje.getUsuario_origen());
			st.setString(6, objMensaje.getContenido());
			st.executeUpdate();

		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}
	
	public void eliminar(Mensaje objMensaje) throws SQLException {

		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(DELETE);
			st.setInt(1, objMensaje.getId());
			st.executeUpdate();
		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}
	
	
	public Mensaje[] filtrar(int tipo_filtro, String valor) throws SQLException {
		ArrayList<Mensaje> mensajes = new ArrayList<>();
		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(QUERY_FILTROS[tipo_filtro]);
			st.setString(1, valor + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				mensajes.add(getMensajeObject(rs));
			}
			return mensajes.toArray(new Mensaje[mensajes.size()]);
		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}
	
	public Mensaje getMensajeObject(ResultSet rs) throws SQLException {
		Mensaje objMensaje = new Mensaje();
		objMensaje.setUsuario_origen(rs.getString("USUARIO_ORIGEN"));
		objMensaje.setUsuario_destino(rs.getString("USUARIO_DESTINO"));
		objMensaje.setAsunto(rs.getString("ASUNTO"));
		objMensaje.setLeido(rs.getBoolean("LEIDO")); 
		objMensaje.setFecha(rs.getDate("FECHA"));
		objMensaje.setContenido(rs.getString("CONTENIDO"));
		
		return objMensaje;
	}

	public Mensaje[] obtener(Usuario usuario) throws SQLException {
		
		ArrayList<Mensaje> mensajes = new ArrayList<>();
		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			//PreparedStatement ps = con.prepareStatement("SELECT USUARIO_ORIGEN, ASUNTO, FECHA, LEIDO FROM MENSAJES WHERE USUARIO_DESTINO='"+usuario.getNombre()+"'");
			PreparedStatement ps = con.prepareStatement(OBTENER);
			ps.setString(1, usuario.getNombre());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				mensajes.add(getMensajeObject(rs));
			}

		} catch (Exception e) {
			throw e;
		} finally {
			ds.cerrarConexion();
		}
		
		return mensajes.toArray(new Mensaje[mensajes.size()]);
	}
	
}