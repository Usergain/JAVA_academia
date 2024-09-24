package Colecciones.src;

import java.util.*;

public class PruebaLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String>personas=new LinkedList<String>();
		
		personas.add("Pepe");
		personas.add("Sandra");
		personas.add("Ana");
		personas.add("Laura");
		
		System.out.println(personas.size());
		
		ListIterator<String>it=personas.listIterator();
		it.next(); //estamos entre la posicion 0 y 1
		it.add("Juan");
		
		for (String persona : personas) {
			System.out.println(persona);
		}

	}

}
