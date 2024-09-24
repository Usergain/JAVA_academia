package Fichero_Binario;

import java.io.FileInputStream;
import java.io.IOException;

public class Input_Binario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fread = null;
		int datoleido;

		try {
			fread = new FileInputStream("C:/Users/userg/Documents/CIPSA/datos.dat");
			System.out.println("Fichero_Binario abierto");
			datoleido = fread.read();

			while (datoleido != -1) {
				System.out.println("Leido valor: " + datoleido);
				System.out.println("Caracter: " + (char) datoleido);
				datoleido = fread.read();
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

