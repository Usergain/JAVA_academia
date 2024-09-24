import org.json.simple.JSONObject;

public class Contacto {
	public String poblacion;
	public String direccion;
	public String telefono;
	public int codigoPostal;

	public Contacto(String poblacion, String direccion, String telefono, int codigoPostal) {
		this.poblacion = poblacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "Contacto [poblacion=" + poblacion + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", codigoPostal=" + codigoPostal + "]";
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("poblacion", this.poblacion);
		json.put("direccion", this.direccion);
		json.put("telefono", this.telefono);
		json.put("cpostal", this.codigoPostal);
		return json;
	}

	public static Contacto fromJSON(JSONObject json) {
		// Obtencion de atributos
		String poblacion = (String) json.get("poblacion");
		String direccion = (String) json.get("direccion");
		String telefono = (String) json.get("telefono");
		long codigoPostal = (long) json.get("cpostal");
		// Instanciacion de objeto
		return new Contacto(poblacion, direccion, telefono, (int) codigoPostal);
	}
}
