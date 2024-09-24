package Fichero_Caracteres;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(obtenerValorFichero("C:/Users/userg/Documents/CIPSA/flujoCaracteres_PrintWriter_Personas.txt", 4));
	
	}

	public static int obtenerValorFichero(String ruta, int indx) {

		RandomAccessFile randomFile = null;
		long desplazamiento;
		int resultado = 0;

		try {
			// Apertura del fichero para acceso aleatorio de sólo lectura
			randomFile = new RandomAccessFile(ruta, "r");
			// Cálculo del desplazamiento con 4 bytes por elemento.
			desplazamiento = indx * 4; // Un entero se almacena como 4 bytes.
			// Comprobacion de desplazamiento
			if (desplazamiento < randomFile.length()) {
				// Posicionamiento y lectura.
				randomFile.seek(desplazamiento);
				resultado = randomFile.readInt();
			} else {
				System.out.println("Posicion fuera de rango");
			}
		} catch (IOException ex) {
			System.out.println("Error E/S: " + ex.getMessage());

		} finally {
			try {
				// Cierre del fichero.
				if (randomFile != null)
					randomFile.close();
			} catch (Exception ex) {
			}
		}
		// Retorno valor recuperado.
		return resultado;
	}

}
