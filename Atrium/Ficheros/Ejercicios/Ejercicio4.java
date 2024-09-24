package Ejercicios;

import java.io.FileOutputStream;

public class Ejercicio4 {

	public static void main(String[] args) {

		FileOutputStream fs = null;
		byte buffer[] = new byte[128];
		int nbytes;

		try {
			System.out.println("Escribe el texto a guardar ");
			nbytes = System.in.read(buffer);
			fs = new FileOutputStream("C:\\texto.txt", true);
			fs.write(buffer, 0, nbytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
