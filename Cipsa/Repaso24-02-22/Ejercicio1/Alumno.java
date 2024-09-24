package Ejercicio1;

import java.util.Arrays;

public class Alumno {
	
	private String nombre;
	private String apellidos;
	private int edad;
	private float nota;
	private char sexo;
	Asignatura []asignatura;
	
	public Alumno() {
	}
	
	public Alumno(String nombre, String apellidos, int edad, float nota, char sexo, Asignatura[] asignatura) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.nota=nota;
		this.sexo=sexo;
		this.asignatura = asignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public Asignatura[] getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura[] asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", nota=" + nota + ", sexo="
				+ sexo + "]";
	}

}



