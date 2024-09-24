package Ejercicio5;

import java.util.HashMap;
import java.util.Iterator;

public class Diccionario {

	private HashMap conjuntoPalabras;

	public Diccionario() {
		this.conjuntoPalabras = new HashMap();
	}

	public void addPalabra(String cadena) {
		Palabra nuevaPalabra = new Palabra(cadena);
		conjuntoPalabras.put(cadena, nuevaPalabra);
	}

	public void addDefinicion(String cadena, String definicion) {
		Palabra palabra = (Palabra) conjuntoPalabras.get(cadena);
		palabra.addDefinicion(definicion);
	}

	public void imprimeDiccionario() {
		Iterator accesoLista = conjuntoPalabras.values().iterator();
		while (accesoLista.hasNext()) {
			Palabra nuevaPalabra = (Palabra) accesoLista.next();
			nuevaPalabra.imprimeDefiniciones();
		}
	}

	public static void main(String[] args) {
		Diccionario dic = new Diccionario();

		dic.addPalabra("lenguaje");
		dic.addDefinicion("lenguaje",
				"Conjunto de sonidos articulados" + " con que el hombre manifiesta lo que piensa o siente.");
		dic.addDefinicion("lenguaje", "lengua");
		dic.addDefinicion("lenguaje", "Manera de expresarse");

		dic.addPalabra("consulta");
		dic.addDefinicion("consulta", "Accion y efecto de consultar.");
		dic.addDefinicion("consulta",
				"Parecer o dictamen que por" + " escrito o de palabra se pide o se da acerca de algo");

		dic.imprimeDiccionario();
	}

}
