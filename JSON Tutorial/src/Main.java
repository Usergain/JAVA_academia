import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.JSONObject;

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
			pw.write(json.toString());
			pw.flush();
			System.out.println("Fichero guardado.");
		} catch (FileNotFoundException ex) {
			System.out.println("El fichero no puedo guardarse.");
		}
	}

}
