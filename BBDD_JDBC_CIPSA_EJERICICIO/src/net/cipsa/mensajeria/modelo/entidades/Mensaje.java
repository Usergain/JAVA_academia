package net.cipsa.mensajeria.modelo.entidades;

import java.util.Date;

public class Mensaje {

	@Override
	public String toString() {
		return "Mensaje [asunto=" + asunto + ", contenido=" + contenido + ", fecha=" + fecha + ", id=" + id + ", leido="
				+ leido + ", usuario_destino=" + usuario_destino + ", usuario_origen=" + usuario_origen + "]";
	}

	public Mensaje(String asunto, String contenido, Date fecha, boolean leido, String usuario_destino,
			String usuario_origen) {
		this.asunto = asunto;
		this.contenido = contenido;
		this.fecha = fecha;
		this.leido = leido;
		this.usuario_destino = usuario_destino;
		this.usuario_origen = usuario_origen;
	}

	public Mensaje() {
		// TODO Auto-generated constructor stub
	}
	
	public Mensaje (int id, String asunto, String contenido, Date fecha, boolean leido, String usuario_destino, String usuario_origen) {
		this.id = id;
		this.asunto = asunto;
		this.contenido = contenido;
		this.fecha = fecha;
		this.leido = leido;
		this.usuario_destino = usuario_destino;
		this.usuario_origen = usuario_origen;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	public String getUsuario_destino() {
		return usuario_destino;
	}

	public void setUsuario_destino(String usuario_destino) {
		this.usuario_destino = usuario_destino;
	}

	public String getUsuario_origen() {
		return usuario_origen;
	}

	public void setUsuario_origen(String usuario_origen) {
		this.usuario_origen = usuario_origen;
	}
	
	private String asunto;
	private String contenido;
	private Date fecha;
	private int id;
	private boolean leido;
	private String usuario_destino;
	private String usuario_origen;

}