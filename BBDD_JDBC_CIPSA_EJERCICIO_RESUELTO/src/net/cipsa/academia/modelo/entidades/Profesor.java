package net.cipsa.academia.modelo.entidades;

import java.util.Date;

public class Profesor {

	private String DNI;
	private String nombre;
	private String apellidos;
	private int edad;
	private Date alta;
	private boolean activo;

// Constructor sin parámetros
	public Profesor() {
	};

// Constructor parametrizado
	public Profesor(String _DNI, String _nombre, String _apellidos, int _edad, Date _alta, boolean _activo) {

		this.DNI = _DNI;
		this.nombre = _nombre;
		this.apellidos = _apellidos;
		this.edad = _edad;
		this.alta = _alta;
		this.activo = _activo;
	}

//Propiedades GET/SET Dni
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

// Propiedades GET/SET Nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

// Propiedades GET/SET Apellidos
	public String getApellido() {
		return apellidos;
	}

	public void setApellido(String apellido) {
		this.apellidos = apellido;
	}

//Propiedades GET/SET Fecha de Alta
	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

//Propiedades GET/SET Edad
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

//Propiedades GET/SET Activo
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}

