import org.json.simple.JSONObject;

public class Cuenta {
	public String ncuenta;
	public float saldo;
	public float interes;

	public Cuenta(String ncuenta, float saldo, float interes) {
		this.ncuenta = ncuenta;
		this.saldo = saldo;
		this.interes = interes;
	}
	
	@Override
	public String toString() {
		return "Cuenta [ncuenta=" + ncuenta + ", saldo=" + saldo + ", interes=" + interes + "]";
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("ncuenta", this.ncuenta);
		json.put("saldo", this.saldo);
		json.put("interes", this.interes);
		return json;
	}

	public static Cuenta fromJSON(JSONObject json) {
		// Obtencion de valores de atributos
		String ncuenta = (String) json.get("ncuenta");
		double saldo = (double) json.get("saldo");
		double interes = (double) json.get("interes");
		// Instanciacion de objeto
		return new Cuenta(ncuenta, (float) saldo, (float) interes);
	}
}
