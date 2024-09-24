package Ejer1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Integer anio
		Scanner teclado = new Scanner(System.in);
		Integer edad;

		HashMap<String, Integer> personas = new HashMap<String, Integer>();
		personas.put("Adolfo", 21);
		personas.put("Elena", 39);
		personas.put("Genaro", 17);
		personas.put("Penelope", 89);
		personas.put("Aiza", 6);

		System.out.println(personas);

		System.out.println("Dame un año de corte para enseñarte la lista de personas mayore a esa edad: ");
		edad = teclado.nextInt();

		for (Map.Entry<String, Integer> persona : personas.entrySet()) {
			String nombre = persona.getKey();
			Integer edadpersona = persona.getValue();
			
			if(edadpersona > edad) {
				System.out.println("Nombre: " + nombre + " con edad: " + edadpersona);
			}			
		}
		
		// Segunda forma de recorrer un HASH MAP
		for (String clave : personas.keySet()) {
			int edadpersona = personas.get(clave);
			if(edadpersona > edad) {
				System.out.println("Nombre: " + clave + " con edad: " + edadpersona);
			}
		}

	}
}
