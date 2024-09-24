package Fichero_Ruta;

import java.io.File;
import java.sql.Date;
import java.util.Calendar;

public class Ruta_Carpeta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mostrarDatosFichero("C:\\Users\\userg\\Documents\\CIPSA");
		System.out.println("");
		mostrarDatosCarpeta("C:\\Users\\userg\\Documents\\CIPSA");
	}

	public static void mostrarDatosFichero(String url) {
		File objFichero = new File(url);

		if (objFichero.exists()) {
			System.out.println("Nombre del fichero: " + objFichero.getName());
			System.out.println("Ruta del fichero: " + objFichero.getParent());
			System.out.println("Tamaño: " + objFichero.length() + " bytes");
			Calendar fecha = Calendar.getInstance();
			fecha.setTime(new Date(objFichero.lastModified()));
			System.out.println("Modificado el: " + fecha.get(Calendar.DAY_OF_MONTH) + "/" + fecha.get(Calendar.MONTH)
					+ "/" + fecha.get(Calendar.YEAR));
		} else {
			System.out.println("El fichero no existe");
		}
	}

	public static void mostrarDatosCarpeta(String url) {
		File f = new File(url);
		File[] datos = f.listFiles();
		for (File fichero : datos) {
			if (fichero.isDirectory()) {
				System.out.println("[" + fichero.getName() + "]");
			} else {
				System.out.println(fichero.getName() + "\t\t" + fichero.length() + " bytes");
			}
		}
		System.out.println("Espacio libre: " + f.getFreeSpace() + " bytes");
	}

}
