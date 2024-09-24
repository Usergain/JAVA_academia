package net.cipsa.elecciones.modelo.entidades;

public class Candidato {
	
	String nombre;
	int votos;
	
	public Candidato(String nombre, int votos) {
		this.nombre = nombre;
		this.votos = votos;
	}
	
	public Candidato() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos() {
		this.votos = votos+1;
	}
	
	public void setVotos(int votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Candidatos [nombre=" + nombre + ", votos=" + votos + "]";
	}

}
