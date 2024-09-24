import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import Colecciones.Arraylist;

/*Queremos guardar los nombres y la edades de los alumnos de un curso. Realiza un programa que introduzca el nombre y la edad de cada alumno. El proceso de lectura de datos terminará 
 * cuando se introduzca como nombre un asterisco (*) Al finalizar se mostrará los siguientes datos:

Todos lo alumnos mayores de edad.
Los alumnos mayores (los que tienen más edad)*/

public class EjerciOpcArrays8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre = "nombre";
		int edad;
		int index = 0;
		ArrayList<String> arrayNombre = new ArrayList<String>();
		ArrayList<Integer> arrayEdad = new ArrayList<Integer>();

		Scanner teclado = new Scanner(System.in);

		boolean salir = false;

		while (!nombre.equalsIgnoreCase("*")) {
			System.out.println("Dame nombre del alumno: ");
			nombre = teclado.next();
			arrayNombre.add(nombre);
			System.out.println("Dame edad del alumno: ");
			edad = teclado.nextInt();
			arrayEdad.add(edad);
		}

		for (int i = 0; i < arrayNombre.size(); i++) {
			if (!nombre.equalsIgnoreCase("*")) {
				System.out.println("Nombre: " + arrayNombre.get(i) + " y edad: " + arrayEdad.get(i) + " años");
			}
		}

		/*******************************
		 * OTRA FORMA DE HACERLO, AL GUSTO DEL
		 * CONSUMIDOR**************************************************************
		 * while (!salir) {
		 * 
		 * System.out.println("Dame nombre del alumno: "); nombre = teclado.next();
		 * 
		 * System.out.println("Dame edad del alumno: "); edad = teclado.nextInt();
		 * 
		 * if (!nombre.equalsIgnoreCase("*")) { arrayNombre.add(nombre);
		 * arrayEdad.add(edad); } else { salir = true; }
		 * 
		 * }
		 * 
		 * for (int i = 0; i < arrayNombre.size(); i++) { System.out.println("Nombre: "
		 * + arrayNombre.get(i) + " y edad: " + arrayEdad.get(i) + " años"); }
		 ********************************************************************************************************************************************/

	}

}
