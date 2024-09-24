package Main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] valores = { 10, 20, 30, 40, 50, 60, 70, 80 };
		// Instanciacion de objeto JSONArray
		JSONArray json = new JSONArray();
		// Guardado de valores
		for (int valor : valores)
			json.add(valor);
		// Guardado de fichero
		try (PrintWriter pw = new PrintWriter("C:/Users/userg/Documents/CIPSA/datos2.json")) {
			pw.write(json.toJSONString());
			pw.flush();
			System.out.println("Fichero guardado.");
		} catch (FileNotFoundException ex) {
			System.out.println("El fichero no puedo guardarse.");
		}

		try (FileReader reader = new FileReader("C:/Users/userg/Documents/CIPSA/datos2.json")) {
			// Instanciacion del parseador
			JSONParser parser = new JSONParser();
			// Obtencion del objeto JSONArray codificado
			JSONArray json2 = (JSONArray) parser.parse(reader);
			long[] matriz = new long[json2.size()];
			// Recuperacion de los valores almacenados.
			for (int i = 0; i < matriz.length; i++)
				matriz[i] = (long) json2.get(i);
			System.out.println(Arrays.toString(matriz));
		} catch (IOException ex) {
			System.out.println("Error abriendo fichero");
		} catch (ParseException ex) {
			System.out.println("Error parseando JSON");
		}

	}

}
