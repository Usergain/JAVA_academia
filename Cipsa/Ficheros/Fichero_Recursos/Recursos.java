package Fichero_Recursos;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Recursos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream in = classLoader.getResourceAsStream("Archivos/photo.jpg");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String linea;

		try {
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			System.out.println("FIN fichero");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR E/S");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ex) {
				};
			}
		}

	}

}




