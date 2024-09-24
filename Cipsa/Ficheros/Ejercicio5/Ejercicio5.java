package Ejercicio5;

import java.io.File;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

public class Ejercicio5 {

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
			if(objFichero.canWrite()==true) {
				System.out.println("Se puede modificar");
			}else {
				System.out.println("No se puede modificar");
			}
			Calendar fecha = Calendar.getInstance();
			fecha.setTime(new Date(objFichero.lastModified()));
			System.out.println("Modificado el: " + fecha.get(Calendar.DAY_OF_MONTH) + "/" + fecha.get(Calendar.MONTH)
					+ "/" + fecha.get(Calendar.YEAR));
		} else {
			System.out.println("Fichero inexistente");
		}
	}

	public static void mostrarDatosCarpeta(String url) {
		File f = new File(url);
		File[] datos = f.listFiles();
		for (File fichero : datos) {
			if (fichero.isDirectory()) {
				System.out.println("[" + fichero.getName() + "]");
			} else {
				System.out.println(fichero.getName() + "\t\t" + fichero.length());
			}
		}
		System.out.println("Espacio libre: " + f.getFreeSpace() + "bytes");
	}

}
