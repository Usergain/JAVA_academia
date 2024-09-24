package Main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Cuenta.Cuenta;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cuenta cuenta = new Cuenta("VCTTTM_20393_3302", 1275.5f, 0.75f);
		// Instanciacion de objeto JSONObject
		JSONObject json = new JSONObject();
		// Guardado de atributos
		json.put("ncuenta", cuenta.ncuenta);
		json.put("saldo", cuenta.saldo);
		json.put("interes", cuenta.interes);
		// Guardado de fichero
		try (PrintWriter pw = new PrintWriter("C:/Users/userg/Documents/CIPSA/datos.json")) {
			pw.write(json.toJSONString());
			pw.flush();
			System.out.println("Fichero guardado.");
		} catch (FileNotFoundException ex) {
			System.out.println("El fichero no puedo guardarse.");
		}
		
		try (FileReader reader = new FileReader("C:/Users/userg/Documents/CIPSA/datos.json")) {
			// Instanciacion del parseador
			JSONParser parser = new JSONParser();
			// Obtencion del objeto JSONObject codificado
			JSONObject json2 = (JSONObject) parser.parse(reader);
			// Obtencion de los atributos almacenados
			String ncuenta = (String) json2.get("ncuenta");
			double saldo = (double) json2.get("saldo");
			double interes = (double) json2.get("interes");
			// Instanciacion del objeto Cuenta codificado
			Cuenta obj = new Cuenta(ncuenta, (float) saldo, (float) interes);
			System.out.println(obj.toString());
		} catch (IOException ex) {
			System.out.println("Error abriendo fichero");
		} catch (ParseException ex) {
			System.out.println("Error parseando JSON");
		}
	}

}
