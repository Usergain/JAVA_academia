package ACT03_ASIX_asix.IntroDatos;

import java.util.Scanner;

/**
 * Clase Filtro encargada de pedir datos por consola y retornarlos.
 */

public class Filtro {
	/**
	 * Método para pedir un entero por consola y retornarlo.
	 *
	 * @param pregunta La pregunta que se mostrará al usuario.
	 * @return El número entero proporcionado por el usuario.
	 */
	public static int pideEntero(String pregunta) {
		Scanner scanner = new Scanner(System.in);
		int entero;

		while (true) {
			System.out.println(pregunta);
			if (scanner.hasNextInt()) {
				entero = scanner.nextInt();
				break;
			} else {
				System.out.println("Por favor, introduce un número entero válido.");
				scanner.next();
			}
		}

		return entero;
	}
	/**
	 * Método para pedir un número double por consola y retornarlo.
	 *
	 * @param pregunta La pregunta que se mostrará al usuario.
	 * @return El número double proporcionado por el usuario.
	 */
	public static double pideDouble(String pregunta) {
		Scanner scanner = new Scanner(System.in);
		double doble;

		while (true) {
			System.out.println(pregunta);
			if (scanner.hasNextDouble()) {
				doble = scanner.nextDouble();
				break;
			} else {
				System.out.println("Por favor, introduce un número válido.");
				scanner.next();
			}
		}

		return doble;
	}
}