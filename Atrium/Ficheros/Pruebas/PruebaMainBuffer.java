package Pruebas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaMainBuffer {
	public static void main(String[] args) {

		try {

			FileReader input = new FileReader("D:\\prueba.txt"); // Lo he intentado con .dat y tampoco me funciona
			BufferedReader bufferEntrada = new BufferedReader(input);

			try {
				FileWriter output = new FileWriter("D:\\salida1.txt");
				BufferedWriter bufferSalida = new BufferedWriter(output);

				try {
					String linea;

					// Efectuamos la primera lectura
					linea = bufferEntrada.readLine();
					
					while (linea != null) {
						bufferSalida.write(linea, 0, linea.length());

						// provocamos un salto de linea
						bufferSalida.newLine();

						// Efectuamos la siguiente lectura
						linea = bufferEntrada.readLine();
					}
				} finally {
					// Forzar si hubiese algo pendiente de escribir
					bufferSalida.flush();

					// cerrar el fichero
					bufferSalida.close();
				}

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				bufferEntrada.close();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
