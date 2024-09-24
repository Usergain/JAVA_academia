package Ejercicio5;

import java.util.ArrayList;
import java.util.Iterator;

public class Palabra {

	private String nombre;
	private ArrayList definiciones;

	public Palabra(String nuevaPalabra) {
		this.nombre = nuevaPalabra;
		definiciones = new ArrayList();
	}

	public void addDefinicion(String nuevaDefinicion) {
		definiciones.add(nuevaDefinicion);
	}

	public void eliminaDefinicion(int indice) {
		definiciones.remove(indice);
	}

	public void imprimeDefiniciones() {
		String definicion;

		System.out.println("\n" + nombre);
		Iterator listaDefiniciones = definiciones.iterator();
		while (listaDefiniciones.hasNext()) {
			definicion = (String) listaDefiniciones.next();
			int indice = definiciones.indexOf(definicion);
			System.out.println("[" + indice + "]." + definicion);
		}
	}

}
