package Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static HashMap<String, Alumno> diccionario = new HashMap<String, Alumno>();
	private static List<Alumno>Alumnolambdas=new ArrayList<Alumno>();// para invocar metodo por Lambdas
	private static Colegio colegio=new Colegio(diccionario);

	public static void main(String[] args) {
		
		
		Scanner teclado = new Scanner(System.in);

		System.out.println(" ");
		System.out.println("*********************************");
		System.out.println("         ACADEMIA CIPSA          ");
		System.out.println("*********************************");
		System.out.println(" ");

		System.out.println("¿Cuántos alumnos quieres crear?");
		int cantidadAlumnos = teclado.nextInt();

		for (int i = 0; i < cantidadAlumnos; i++) {

			System.out.println("Dame el nombre");
			String nombre = teclado.next();
			System.out.println("Dame el DNI");
			String dni = teclado.next();
			System.out.println("Dame la población");
			String poblacion = teclado.next();

			Alumno a = new Alumno(nombre, dni, poblacion);

			System.out.println("¿Cuántas calificaciones quieres crearle al alumno?");
			int cantidadCalificaciones = teclado.nextInt();

			ArrayList<Float> calificaciones = new ArrayList<Float>();

			for (int j = 0; j < cantidadCalificaciones; j++) {
				System.out.println("Introduce la calificación " + (j + 1));
				float nota = teclado.nextFloat();
				calificaciones.add(nota);
			}

			a.setCalificaciones(calificaciones);
			
			

			diccionario.put(a.getDni(), a); // introducir Arraylist al HashMap diccionario
			Alumnolambdas.add(a);
		}

		System.out.println(" ");
		System.out.println("*********************************");
		System.out.println("         LISTADO ALUMNOS         ");
		System.out.println("*********************************");
		System.out.println(" ");

		for (String clave : diccionario.keySet()) {
			Alumno a = diccionario.get(clave);
			System.out.println(a.toString());

			ArrayList<Float> notas = a.getCalificaciones();
			System.out.println("Notas: ");
			for (int i = 0; i < notas.size(); i++) {
				System.out.println("Nota " + (i + 1) + ": " + notas.get(i));
			}
			System.out.println("");
		}

		System.out.println(" ");
		System.out.println("*********************************");
		System.out.println("        BUSQUEDA ALUMNO:DNI      ");
		System.out.println("*********************************");
		System.out.println(" ");

		System.out.println("Introduzca el DNI del alumno a buscar");
		String dniBuscar = teclado.next();
		
		if (diccionario.size() > 0) {
			System.out.println("");
			System.out.println(colegio.mostrarAlumnoDadoDni(dniBuscar)); // metodo estatico con HashMap
			System.out.println("");
		} else {
			 System.out.println("");
			 System.out.println(" No existe ningún registro creado. ");
			 System.out.println("");
		}
		
		System.out.println(" ");
		System.out.println("*********************************");
		System.out.println("        FILTRADO POR POBLACION   ");
		System.out.println("*********************************");
		System.out.println(" ");

		System.out.println("Introduzca la población a buscar: ");
		String poblacionBuscar = teclado.next();
		
		if (diccionario.size() > 0) {
			System.out.println("");
			System.out.println(colegio.mostrarAlumnosDadoPoblacion(poblacionBuscar)); // metodo estatico con HashMap
			System.out.println("");
		} else {
			 System.out.println("");
			 System.out.println(" No existe ningún registro creado. ");
			 System.out.println("");
		}
		
		System.out.println(" ");
		System.out.println("************************************");
		System.out.println(" FILTRADO POR POBLACION POR LAMBDA  ");
		System.out.println("************************************");
		System.out.println(" ");
		
		if (diccionario.size() > 0) {
			System.out.println("");
			System.out.println(colegio.mostrarAlumnosAgrupadosPoblacion(Alumnolambdas)); // metodo estatico con Stream
			System.out.println("");
		} else {
			 System.out.println("");
			 System.out.println(" No existe ningún registro creado. ");
			 System.out.println("");
		}
		
		System.out.println(" ");
		System.out.println("**********************************************************");
		System.out.println("         LISTADO ALUMNOS TODOS EXAMENES APROBADOS         ");
		System.out.println("**********************************************************");
		System.out.println(" ");
		
		if (diccionario.size() > 0) {
			System.out.println("");
			System.out.println(colegio.mostrarAlumnosAprobados());
			System.out.println("");
		} else {
			 System.out.println("");
			 System.out.println(" No existe ningún registro creado. ");
			 System.out.println("");
		}
		
		System.out.println(" ");
		System.out.println("**********************************************************");
		System.out.println("         LISTADO ALUMNOS MEDIA APROBADA                   ");
		System.out.println("**********************************************************");
		System.out.println(" ");
		
		if (diccionario.size() > 0) {
			System.out.println("");
			System.out.println(colegio.recuentoAlumnosAprobados());
			System.out.println("");
		} else {
			 System.out.println("");
			 System.out.println(" No existe ningún registro creado. ");
			 System.out.println("");
		}
		
	}



}

