package Colecciones;

import java.util.ArrayList;
import java.util.Collections;

public class Arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> coches = new ArrayList<String>();
		ArrayList<Integer> numeros = new ArrayList<Integer>();

		coches.add("Volvo");

		coches.add("Mazda");
		coches.add("BMW");
		coches.add("Ford");

		System.out.println(coches);

		System.out.println(coches.get(1));

		coches.set(0, "Opel");
		System.out.println(coches);

		coches.remove(0);
		System.out.println(coches);
		//coches.clear();
		System.out.println("El tamaño del arraylist es de: "+coches.size());
		System.out.println(coches);
		System.out.println("Recorremos con un bucle for sin ordenar: ");
		for (int i=0;i<coches.size();i++)
		{
			System.out.println(coches.get(i));
		}
		//Ordenamos la colección
		Collections.sort(coches);

		System.out.println("Recorremos con un bucle for each: ");
		for (String i : coches)
		{
			System.out.println(i);
		}

	}

}
