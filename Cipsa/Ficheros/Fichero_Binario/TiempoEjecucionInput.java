package Fichero_Binario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class TiempoEjecucionInput {

	public static void main(String[] args) {

		int byte_leido;
		int bytes_leidos = 0;
		int datos_entrada[] = new int[19361];
		FileInputStream archivo_lectura = null;
		String ruta = "C:/Users/userg/Documents/CIPSA/Lorem.dat";

		try {
			archivo_lectura = new FileInputStream(ruta);
			byte_leido = archivo_lectura.read();
			while (byte_leido != -1) {
				bytes_leidos++;
				System.out.println(byte_leido);
				byte_leido = archivo_lectura.read();

				if (byte_leido != -1) {
					datos_entrada[bytes_leidos] = byte_leido;

				}

			}
			// datos_entrada[bytes_leidos]=byte_leido;
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {
			if (archivo_lectura != null) {
				try {
					archivo_lectura.close();
				} catch (IOException ex) {
				}
			}
			System.out.println(String.format("Archivo cerrado. %d bytes leidos", bytes_leidos)
					+ " .Tiempo de ejecucion " + leerBytes(ruta));

		}

	}

	public static long leerBytes(String ruta) {
		long tiempoInicio = new Date().getTime();
		int datoleido;

		FileInputStream fread = null;
		try {
			fread = new FileInputStream(ruta);
			datoleido = fread.read();

			while (datoleido != -1) {
				datoleido = fread.read();
			}

		} catch (IOException e) {
			System.out.println("ERROR");
		} finally {
			try {
				if (fread != null) {
					fread.close();
				}
			} catch (IOException e) {

			}
		}

		return (new Date().getTime()) - tiempoInicio;
	}

}

