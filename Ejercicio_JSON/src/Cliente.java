import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Cliente {
	public String DNI;
	public String nombre;
	public int edad;
	public Contacto contacto;
	public Cuenta[] cuentas;

	public Cliente(String DNI, String nombre, int edad) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Cliente [DNI=" + DNI + ", nombre=" + nombre + ", edad=" + edad + ", contacto=" + contacto + ", cuentas="
				+ Arrays.toString(cuentas) + "]" + "\n" ;
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		// Codificacion de los atributos simples
		json.put("dni", this.DNI);
		json.put("nombre", this.nombre);
		json.put("edad", this.edad);
		// Codificacion del objeto contacto
		json.put("contacto", this.contacto.toJSON());
		// Codificacion de la matriz de cuentas
		JSONArray json_cuentas = new JSONArray();
		for (Cuenta cuenta : this.cuentas)
			json_cuentas.add(cuenta.toJSON());
		json.put("cuentas", json_cuentas);
		return json;
	}

	public static Cliente fromJSON(JSONObject json) {
		// Obtencion de atributos simples
		String DNI = (String) json.get("dni");
		String nombre = (String) json.get("nombre");
		long edad = (long) json.get("edad");
		// Instanciacion de objeto Cliente
		Cliente cliente = new Cliente(DNI, nombre, (int) edad);
		// Obtencion + instanciacion de objeto Contacto
		cliente.contacto = Contacto.fromJSON((JSONObject) json.get("contacto"));
		JSONArray json_cuentas = (JSONArray) json.get("cuentas");
		// Obtencion + instanciacion de objetos Cuenta
		cliente.cuentas = new Cuenta[json_cuentas.size()];
		for (int i = 0; i < cliente.cuentas.length; i++) {
			cliente.cuentas[i] = Cuenta.fromJSON((JSONObject) json_cuentas.get(i));
		}
		return cliente;
	}

}
