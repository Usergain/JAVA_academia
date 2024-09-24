package Fichero_Caracteres;

import java.io.FileWriter;

public class Write {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EscribirFrase("HOLA");
		EscribirFrase("ESTO ES CADENA 1");
		EscribirFrase("ESTA ES LA CADENA 2");
		EscribirFrase("ESTA ES LA CADENA 3");
	}

	public static void EscribirFrase(String frase) {
		FileWriter fw = null;

		try {
			// Apertura del flujo a fichero en modo añadir.
			fw = new FileWriter("C:/Users/userg/Documents/CIPSA/flujoCaracteres.txt", true);
			// Escritura de la cadena
			fw.write(frase);
		} catch (Exception e) {
			System.out.println("Error E/S");
		} finally {
			try {
				// Cierre del flujo a fichero.
				if (null != fw) {
					fw.close();
				}
			} catch (Exception e2) {
			}
		}
	}

}

