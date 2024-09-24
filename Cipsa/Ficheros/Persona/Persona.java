package Persona;

import java.io.Serializable;

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dni;
	private int edad;
	private boolean casado;
	private float altura;

	public Persona(String dni, int edad, boolean casado, float altura) {
		this.dni = dni;
		this.edad = edad;
		this.casado = casado;
		this.altura = altura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDni() {
		return dni;
	}

	public int getEdad() {
		return edad;
	}

	public boolean casado() {
		return casado;
	}

	public float getAltura() {
		return altura;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", edad=" + edad + ", casado=" + casado + ", altura=" + altura + "]";
	}
	
	

}