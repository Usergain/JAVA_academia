package ExpresionesLambda_Stream;

import java.util.Arrays;
import java.util.Comparator;

public class MainLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Objeto comparador por de personas por nombre.
		Comparator<Persona> comparador = new Comparator<Persona>() {
			@Override
			public int compare(Persona o1, Persona o2) {
				return o1.nombre.compareTo(o2.nombre);
			}
		};
		Persona[] datos = { new Persona("Roger", 20, 1.95f), new Persona("Victor", 24, 1.68f),
				new Persona("Patrov", 17, 1.74f), new Persona("Simon", 16, 1.84f), new Persona("Anna", 18, 1.92f) };
		// Ordenamos por nombre
		Arrays.sort(datos, comparador);
		System.out.println("Ordenados por nombre: ");
		System.out.println(Arrays.toString(datos));
		
		System.out.println("");
		
		// Objeto comparador por de personas por nombre. 
		//Comparator<Persona> comparador2 = (p1, p2) -> p1.nombre.compareTo(p2.nombre); 
		 
		// Ordenamos por nombre
		 Arrays.sort(datos, (p1, p2) -> p1.nombre.compareTo(p2.nombre)); 
		 System.out.println("Ordenados por nombre: "); 
		 System.out.println(Arrays.toString(datos)); 
		 Arrays.sort(datos, (p1, p2) -> Integer.compare(p1.edad, p2.edad)); 
		 System.out.println("Ordenados por edad: "); 
		 System.out.println(Arrays.toString(datos)); 
		 Arrays.sort(datos, (p1, p2) -> Float.compare(p1.altura, p2.altura)); 
		 System.out.println("Ordenados por altura: "); 
		 System.out.println(Arrays.toString(datos)); 
		 
		 System.out.println("");
		 
		// Ordenamos por nombre y funcion estatica de una clase
		 Arrays.sort(datos, MainLambda::ordenadorNombre); 
		 System.out.println("Ordenados por nombre: "); 
		 System.out.println(Arrays.toString(datos)); 
		 
	}
	
	public static int ordenadorNombre(Persona p1, Persona p2) {
		return p1.nombre.compareTo(p2.nombre);
	} 

}
