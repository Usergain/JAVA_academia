import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.JSONArray;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] valores = { 10, 20, 30, 40, 50, 60, 70, 80 };
		// Instanciacion de objeto JSONArray
		JSONArray json = new JSONArray();
		// Guardado de valores
		for (int valor : valores)
			json.put(valor);
		// Guardado de fichero
		try (PrintWriter pw = new PrintWriter("C:/Users/userg/Documents/CIPSA/datos2.json")) {
			pw.write(json.toString());
			pw.flush();
			System.out.println("Fichero guardado.");
		} catch (FileNotFoundException ex) {
			System.out.println("El fichero no puedo guardarse.");
		}
	}

}
