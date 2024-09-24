package Fichero_Caracteres;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] lineas = LeerFicheroTexto(); 
		 for( String linea : lineas) { 
		 System.out.println( linea ); 
		 } 

	}

	public static String[] LeerFicheroTexto() {
		// Coleccion dinámica para las cadenas de caracterres.
		java.util.ArrayList<String> lineas = new java.util.ArrayList<String>();
		String linea;
		BufferedReader br = null;
		try {
			// Apertura del flujo a fichero
			br = new BufferedReader(new FileReader("C:/Users/userg/Documents/CIPSA/flujoCaracteres_PrintWriter.txt"));
			// Lectura de fichero línea a línea.
			linea = br.readLine();
			while (linea != null) {
				lineas.add(linea);
				linea = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Error E/S");
		} finally {
			try {
				// Cierre del flujo a fichero.
				if (null != br) {
					br.close();
				}
			} catch (Exception e2) {
			}
		}
		// Conversión de la colección a matriz
		String[] matriz = new String[lineas.size()];
		return lineas.toArray(matriz);
	}

}
