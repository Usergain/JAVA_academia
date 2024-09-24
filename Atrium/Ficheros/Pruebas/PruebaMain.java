package Pruebas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaMain {

	public static void main(String[] args) {
		try {

			FileReader input = new FileReader("C:\\prueba.txt");

			try {
				FileWriter output = new FileWriter("C:\\salida.txt");

				try {
					char[] buffer = new char[128];

					// Caracteres leidos
					int numLeidos = 0;

					// Efectuamos la primera lectura
					numLeidos = input.read(buffer);

					while (numLeidos != -1) {
						output.write(buffer, 0, numLeidos);

						// Efectuamos la siguiente lectura
						numLeidos = input.read(buffer);
					}
				} finally {
					// Forzar si hubiese algo pendiente de escribir
					output.flush();

					// cerrar el fichero
					output.close();
				}

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				input.close();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}


