package Ejemplo_Comparator;

import java.util.Comparator;
import java.util.TreeSet;

import Ejemplo_Comparable.*;

public class Main {

	public static void main(String[] args) {
		// crear una coleccion clasifique los objetos --> TreeSet
		ComparadorNombre c = new ComparadorNombre();
		ComparadorNif nif = new ComparadorNif();
		ComparadorCifraVentas v = new ComparadorCifraVentas();

		// Elegimos ordenar los clientes por su nombre
		//TreeSet arbol = new TreeSet(c);
		TreeSet arbol = new TreeSet(nif);

		arbol.add(new ClienteSimple("Juan", 1500, "1111-A"));
		arbol.add(new ClienteSimple("Jose", 1200, "3333-B"));
		arbol.add(new ClienteSimple("Maria", 1800, "2222-C"));
		arbol.add(new ClienteSimple("Laura", 1100, "0000-D"));
		
		

		Object[] array = arbol.toArray();

		for (int i = 0; i < array.length; i++) {
			
			System.out.println((ClienteSimple) array[i]);
		}
	}

}
