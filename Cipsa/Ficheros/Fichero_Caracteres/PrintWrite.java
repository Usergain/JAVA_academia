package Fichero_Caracteres;

import java.io.PrintWriter;

public class PrintWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] lineas = new String[] { "Hola", "Linea 1", "Linea 2", "Linea 3", "Final" };
		EscribirFichero(lineas);
	}

	public static void EscribirFichero(String[] lineas) {
		PrintWriter pw = null;
		try {
			// Apertura del flujo de salida a fichero
			pw = new PrintWriter("C:/Users/userg/Documents/CIPSA/flujoCaracteres_PrintWriter.txt");
			// Guardado de cada cadena de la matriz lineas en una línea.
			for (String linea : lineas) {
				pw.println(linea);
			}
		} catch (Exception e) {
			System.out.println("Error E/S");
		} finally {
			try {
				// Cierre del flujo a fichero.
				if (null != pw) {
					pw.flush();
					pw.close();
				}
			} catch (Exception e2) {
			}
		}
	}

}
