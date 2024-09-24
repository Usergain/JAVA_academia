package Colecciones;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Pelicula> lista = new ArrayList<Pelicula>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		boolean salir = false;
		Scanner teclado = new Scanner(System.in);
		String titulo;
		int duracion;
		String protagonista;
		String idioma;

		while (!salir) {

			System.out.println(" ******** Menú Principal ******** ");
			System.out.println(" 1- Insertar película ");
			System.out.println(" 2- Datos de película");
			System.out.println(" 3- Numero total de películas");
			System.out.println(" 4- Listado de películas");
			System.out.println(" 5- Salir");
			System.out.println(" ********************************* ");

			Scanner sc = new Scanner(System.in);
			opcion = sc.nextInt();

			switch (opcion) {

			case 1:

				System.out.println("Titulo de la película: ");
				titulo = teclado.nextLine();
				System.out.println("Duración de la película: ");
				duracion = teclado.nextInt();
				teclado.nextLine();
				System.out.println("Protagonista de la película: ");
				protagonista = teclado.nextLine();
				System.out.println("Idioma de la película: ");
				idioma = teclado.nextLine();

				Pelicula pelicula = new Pelicula(titulo, duracion, protagonista, idioma);
				lista.add(pelicula);

				break;

			case 2:

				System.out.println("Dime una posicion: ");
				int posicion = teclado.nextInt();

				System.out.println(" Los datos de la pelicula buscada son: " + lista.get(posicion));

				break;

			case 3:
				System.out.println("El numero total de peliculas guardadas es: " + lista.size());
				break;

			case 4:
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i));
				}
				break;

			case 5:

				salir = true;
				break;

			default:

				System.out.println("Seleccione una opción válida");
				break;

			}
		}

	}

}
