import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente objCliente1 = new Cliente("172635489D", "Jhonny Mendez", 20);
		objCliente1.contacto = new Contacto("Bilbao", "C/Rafael Ybarra, 20, 2H", "555-490392", 28080);
		objCliente1.cuentas = new Cuenta[] { new Cuenta("JHNMND_40393_0235", 1200.5f, 0.5f),
				new Cuenta("JHNMND_34389_0235", 675.5f, 0.5f) };
		Cliente objCliente2 = new Cliente("29384462S", "Victor Tatamovich", 34);
		objCliente2.contacto = new Contacto("Santander", "C/Hermanos Fuego, 10, 6B", "555-003920", 39000);
		objCliente2.cuentas = new Cuenta[] { new Cuenta("VCTTTM_49340_0221", 2320.5f, 0.75f),
				new Cuenta("VCTTTM_20393_3302", 1275.5f, 0.75f) };

		Cliente[] clientes = { objCliente1, objCliente2 };

		// Instanciacion de objeto JSONArray
		JSONArray json_clientes = new JSONArray();
		for (Cliente objCliente : clientes)
			// Asignacion de objeto JSONObject de cada cuenta.
			json_clientes.add(objCliente.toJSON());
		// Guardado en fichero
		try (PrintWriter pw = new PrintWriter("C:/Users/userg/Documents/CIPSA/Ejercicio_JSON.json")) {
			pw.write(json_clientes.toJSONString());
			pw.flush();
			System.out.println("Fichero guardado.");
		} catch (FileNotFoundException ex) {
			System.out.println("El fichero no puedo guardarse.");
		}

		try (FileReader reader = new FileReader("datos.json")) {
			// Instanciacion del parseador
			JSONParser parser = new JSONParser();
			// Obtencion del objeto JSONArray codificado
			JSONArray json = (JSONArray) parser.parse(reader);
			Cliente[] matriz = new Cliente[json.size()];
			// Recuperacion de objeto Cliente codificados en matriz.
			for (int i = 0; i < matriz.length; i++)
				matriz[i] = Cliente.fromJSON((JSONObject) json.get(i));
			System.out.println(Arrays.toString(matriz));
		} catch (IOException ex) {
			System.out.println("Error abriendo fichero");
		} catch (ParseException ex) {
			System.out.println("Error parseando JSON");
		}

	}

}

