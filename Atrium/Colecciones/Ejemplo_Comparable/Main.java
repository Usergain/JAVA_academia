package Ejemplo_Comparable;

import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// crear una coleccion clasifique los objetos --> TreeSet
		Set arbol = new TreeSet();

		arbol.add(new Cliente("Juan", 1500, "12345678-A"));
		arbol.add(new Cliente("Jose", 1200, "1245778-A"));
		arbol.add(new Cliente("Maria", 1800, "2222222-A"));
		arbol.add(new Cliente("Laura", 1100, "88888888-A"));

		Object[] array = arbol.toArray();

		for (int i = 0; i < array.length; i++) {
			System.out.println((Cliente) array[i]);
		}

	}

}