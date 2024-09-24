package Fichero_Binario;

import java.io.FileOutputStream;
import java.io.IOException;

public class Output_Binario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] datos = { 67, 73, 80, 83, 65 };
		FileOutputStream fwrite = null;

		try {
			fwrite = new FileOutputStream("C:/Users/userg/Documents/CIPSA/datos.dat", true);
			fwrite.write(datos);
			System.out.println("Datos escritos");
		} catch (IOException e) {
			System.out.println("Error de E/S");
		} finally {
			try {
				if (fwrite != null) {
					fwrite.flush();
					fwrite.close();
					System.out.println("cierre del fichero");
				}
			} catch (IOException e) {

			}
		}

	}

}

