package Colecciones;

import java.util.ArrayList;
import java.util.Iterator;

public class Pelicula {

	private String titulo;
	private int duracion;
	private String protagonista;
	private String idioma;
	private ArrayList<Pelicula> lista;

	public Pelicula(String titulo, int duracion, String protagonista, String idioma) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.protagonista = protagonista;
		this.idioma = idioma;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public ArrayList<Pelicula> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Pelicula> lista) {
		this.lista = lista;
	}


	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", duracion=" + duracion + ", protagonista=" + protagonista + ", idioma="
				+ idioma + "]" ;
	}

}
