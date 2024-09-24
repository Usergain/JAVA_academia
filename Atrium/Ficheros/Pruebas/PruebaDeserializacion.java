package Pruebas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PruebaDeserializacion {

	public static void main(String[] args) {

		FileInputStream fichero;

		try {
			fichero = new FileInputStream("C:\\prueba.txt");
			ObjectInputStream input = new ObjectInputStream(fichero);

			String objetoRecuperado = (String) input.readObject();
			System.out.println(objetoRecuperado);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


