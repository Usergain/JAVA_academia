package Ejercicio8;

import java.io.File;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String url;

		System.out.println("Dame el nombre de una ruta:");
		url = sc.nextLine();

		mostrarDatosFichero(url);
		System.out.println("");
		mostrarDatosCarpeta(url);
	}

	// --------------------------------------------------------------------

	public static void mostrarDatosFichero(String url) {
		File objFichero = new File(url);

		if (objFichero.exists()) {
			System.out.println("Nombre de fichero: " + objFichero.getName());
			System.out.println("Ruta del fichero: " + objFichero.getParent());
			System.out.println("Tamaño: " + objFichero.length() + " bytes");
		} else {
			System.out.println("Fichero inexistente");
		}
	}

	public static void mostrarDatosCarpeta(String url) {
		File f = new File(url);
		File[] datos = f.listFiles();
		for (File fichero : datos) {
			if (!fichero.isDirectory()) {
				System.out.println(fichero.getName() + "\t\t" + fichero.length() + "bytes");
			}
		}
		for (File file : datos) {
			if(file.isDirectory()) {
				System.out.println( file.getName() + "\t\t"+ "<Carpeta>");
			}
		}
	}

}

