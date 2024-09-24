package net.cipsa.mensajeria.modelo.entidades;

public class Usuario {

	@Override
	public String toString() {
		return "[ Usuario administrador=" + administrador + ", clave=" + clave + ", nombre=" + nombre + "]";
	}

	private boolean administrador;
	private String clave;
	private String nombre;
	
	public Usuario() {
	}

	public Usuario(boolean administrador, String clave, String nombre) {
		this.administrador = administrador;
		this.clave = clave;
		this.nombre = nombre;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}