package Fichero_Binario;

import java.io.FileInputStream;
import java.io.IOException;

public class Input_Binario2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fread = null;
		byte[] datos = new byte[16384];
		int bytesleido;
		int bytestotales = 0;

		try {
			fread = new FileInputStream("C:/Users/userg/Documents/CIPSA/datos.dat");
			System.out.println("Fichero_Binario abierto");
			bytesleido = fread.read();

			while (bytesleido != -1) {
				System.out.println("Leido bloque de: " + bytesleido + "bytes.");
				bytestotales += bytesleido;
				System.out.println("Total leido: " + bytestotales + "bytes");
				bytesleido = fread.read(datos);
			}
		} catch (IOException e) {
			System.out.println("Error de E/S");
		} finally {
			try {
				if (fread != null) {
					fread.close();
					System.out.println("cierre del fichero");
				}
			} catch (IOException e) {

			}
		}
	}

}

