package Fichero_Caracteres;

import java.io.FileReader;

public class Read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LeerFicheroTexto());
	}

	public static String LeerFicheroTexto() {
		FileReader fr = null;
		StringBuilder texto = new StringBuilder(); //cadena de caracteres dinámica 
		int valorCaracter;
		try {
			// Apertura del flujo a fichero
			fr = new FileReader("C:/Users/userg/Documents/CIPSA/flujoCaracteres.txt");
			// Lectura del fichero de texto caracter a caracter.
			valorCaracter = fr.read();
			while (valorCaracter != -1) {
				texto.append((char) valorCaracter); // (appends)añadiendo caracteres al StringBuilder y char a un String 
				valorCaracter = fr.read();
			}
		} catch (Exception e) {
			System.out.println("Error E/S");
		} finally {
			try {
				// Cierre del flujo a fichero.
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
			}
		}
		return texto.toString();
	}

}
