package Ejercicio2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {
	
	//Habria que instanciar la clase colegio. Todos los metodos a la clase colegio. No en el main

	private static HashMap<String, Alumno> diccionario = new HashMap<String, Alumno>();

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
		
		
		mostrarAlumnoDadoDni(dniBuscar); // metodo estatico
		
		
		System.out.println("Introduzca la población a buscar: ");
		String poblacionBuscar = teclado.next();

		mostrarAlumnosDadoPoblacion(poblacionBuscar); // metodo estatico con HashMap
		System.out.println("");
		// mostrarAlumnosDadoPoblacion2(poblacionBuscar); //metodo estatico con Stream

		System.out.println(" ");
		System.out.println("**********************************************************");
		System.out.println("         LISTADO ALUMNOS TODOS EXAMENES APROBADOS         ");
		System.out.println("**********************************************************");
		System.out.println(" ");
		mostrarAlumnosAprobados();
		
		System.out.println(" ");
		System.out.println("**********************************************************");
		System.out.println("         LISTADO ALUMNOS MEDIA APROBADA                   ");
		System.out.println("**********************************************************");
		System.out.println(" ");
		recuentoAlumnosAprobados();

	}

	public static void mostrarAlumnoDadoDni(String dni) {
		if (diccionario.containsKey(dni)) {
			Alumno a = diccionario.get(dni);
			System.out.println("Alumno: " + a.toString());

			double media = 0;
			double suma = 0;
			ArrayList<Float> notas = a.getCalificaciones();

			System.out.println("Notas: ");
			for (int i = 0; i < notas.size(); i++) {
				System.out.println("Nota " + (i + 1) + ": " + notas.get(i));
				suma += notas.get(i);
			}
			media = suma / notas.size();
			System.out.println("La media del alumno " + a.getNombre() + " es: " + media);

		} else {
			System.out.println("No existe alumno con el dni: " + dni);
		}
	}

	public static void mostrarAlumnosDadoPoblacion(String poblacion) {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		for (String clave : diccionario.keySet()) {
			Alumno a = diccionario.get(clave);
			if (a.getPoblacion().equalsIgnoreCase(poblacion)) {
				alumnos.add(a);
			}
		}

		if (alumnos.size() > 0) {
			System.out.println(" ");
			System.out.println("**********************************************************");
			System.out.println("         LISTADO POR POBLACION: " + poblacion              );
			System.out.println("**********************************************************");
			System.out.println(" ");
			for (int i = 0; i < alumnos.size(); i++) {
				System.out.println(alumnos.get(i).toString());
			}
			System.out.println("");
		} else {
			System.out.println("No hay alumnos para la población: " + poblacion);
		}

	}

	public static void mostrarAlumnosDadoPoblacion2() {

		// List<Alumno>alumnos=new List<Alumno>(alumnos)
		// List<Alumno> listname = new ArrayList<> (Arrays.asList(alumnos));
		// List<Alumno>alumnos2=Arrays.asList(new ArrayList<Alumno>(alumnos));

		// Me da un error de tipado. Como pasar una Arraylist a List, o mediante stream
		// pasar ArrayList?

		Map<Object, List<Alumno>> agrupamiento = ((Collection<Alumno>) diccionario).stream()
				.collect(Collectors.groupingBy(p -> p.getPoblacion()));

		agrupamiento.keySet().stream().forEach(pob -> {
			System.out.println("Poblacion: " + pob);
			agrupamiento.get(pob).stream().forEach(p -> System.out.println(p));
		});
	}

	public static void mostrarAlumnosAprobados() {
		
		ArrayList<Alumno> aprobados = new ArrayList<Alumno>();

		for (String clave : diccionario.keySet()) {
			Alumno a = diccionario.get(clave);

			ArrayList<Float> notas = a.getCalificaciones();
			int cont = 0;

			//System.out.println("TOTAL NOTAS: " + notas.size());
			
			for (int i = 0; i < notas.size(); i++) {
				if (notas.get(i) >= 5f) {
					cont++;
				}
			}
			
			//System.out.println("TOTAL NOTAS && CONTADOR: " + notas.size() + " - " + cont);
			
			if (notas.size() == cont) {
				aprobados.add(a);
			}
			
			System.out.println("");
		}
		
		for (int i = 0; i < aprobados.size(); i++) {
			System.out.println(aprobados.get(i).toString());
		}

	}

	public static void recuentoAlumnosAprobados() {
		
		int totalAprobados = 0;
		
		for (String clave : diccionario.keySet()) {
			Alumno a = diccionario.get(clave);

			ArrayList<Float> notas = a.getCalificaciones();
			int cont = 0;
			float media = 0;
			float suma = 0;

			for (int i = 0; i < notas.size(); i++) {
				suma += notas.get(i);
			}
			
			media = suma / notas.size();
			
			if (media >= 5) {
				totalAprobados++;
				System.out.println(" El alumno: " + a.getNombre() + " con media " + media + " a aprobado las asignaturas. ");
			}

		}
		
		System.out.println("El recuento de alumnos aprobados es: " + totalAprobados);
		
	}

}
