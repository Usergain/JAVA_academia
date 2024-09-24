package Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import Ejercicio1.Asignatura;

public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private String dni;
	private String poblacion;
	private ArrayList<Float> calificaciones;

	public Alumno(String nombre, String dni, String poblacion) {
		this.dni = dni;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.calificaciones = new ArrayList<Float>();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public ArrayList<Float> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Float> calificaciones) {
		// this.calificaciones.add(getCalificaciones());
		this.calificaciones = calificaciones;
	}

	@Override
	public String toString() {
		return " Alumno: dni=" + dni + ", nombre=" + nombre + ", poblacion=" + poblacion  + " \n ";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return this.nombre.equals(other.nombre); // compara entre cadenas no entre objetos... nos daría la referencia
	}

	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
