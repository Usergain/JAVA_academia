package net.cipsa.elecciones.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import net.cipsa.elecciones.modelo.entidades.Candidato;

public class Candidatos {
	
	private static final String QUERY = "SELECT * FROM CANDIDATOS";
	private static final String QUERY2 = "SELECT * FROM CANDIDATOS WHERE NOMBRE=?";
	private static final String INSERT = "INSERT INTO CANDIDATOS(NOMBRE,VOTOS) VALUES(?,?)";
	private static final String MODIFY= "UPDATE CANDIDATOS SET VOTOS=? WHERE NOMBRE = ?";
	private Datasource ds;
	
	Candidatos(Datasource _ds){
		this.ds = _ds;
	}
	
	public Candidato obtener(String nombre) throws Exception {

		Candidato c = null;
		

		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY2);
			ps.setString(1, nombre);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String nom = rs.getString("NOMBRE");
				int votos = rs.getInt("VOTOS");

				c = new Candidato(nom, votos);
			}

		} catch (Exception e) {

			throw e;
		} finally {
			ds.cerrarConexion();
		}

		return c;
	}
	
	public void insertar(Candidato objCandidato) throws SQLException {

		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(INSERT);
			st.setString(1, objCandidato.getNombre());
			st.setInt(2, objCandidato.getVotos());
			st.executeUpdate();

		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}
	
	public void modificar(Candidato objCandidato) throws SQLException {

		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement(MODIFY);
			
			st.setInt(1, objCandidato.getVotos());
			st.setString(2, objCandidato.getNombre());
			st.executeUpdate();

		} catch (SQLException ex) {
			throw ex;
		} finally {
			ds.cerrarConexion();
		}
	}
	
	public Candidato[] listar()throws SQLException{
		
		ArrayList<Candidato> candidatos = new ArrayList<>();
		try {
			ds.abrirConexion();
			Connection con = ds.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(QUERY);
			while (rs.next()) {
				candidatos.add(getCandidatoObject(rs));
			}
			return candidatos.toArray(new Candidato[candidatos.size()]);

		} catch (Exception e) {
			throw e;
		} finally {
			ds.cerrarConexion();
		}
		
	}
	
	public Candidato getCandidatoObject(ResultSet rs) throws SQLException {
		Candidato objCandidato = new Candidato();
		objCandidato.setNombre(rs.getString("NOMBRE"));
		objCandidato.setVotos(rs.getInt("VOTOS"));
		
		return objCandidato;
	}

}
