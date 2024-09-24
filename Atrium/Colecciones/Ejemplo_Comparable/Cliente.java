package Ejemplo_Comparable;

public class Cliente implements Comparable {

	String nombre;
	double cifraVentas;
	String nif;

	@Override
	public int compareTo(Object o) {
		Cliente otroCliente = null;
		int resultado = 0;

		if (o instanceof Cliente) {
			otroCliente = (Cliente) o; // ClassCastException
		}

		// 0 --> los objetos son iguales
		if (cifraVentas == otroCliente.cifraVentas) {
			resultado = 0;
		}
		// 1 --> es mayor
		else if (cifraVentas > otroCliente.cifraVentas) {
			resultado = 1;
		}
		// -1 --> es menor
		else if (cifraVentas < otroCliente.cifraVentas) {
			resultado = -1;
		}
		return resultado;
	}

	public Cliente(String nombre, double cifraVentas, String nif) {
		this.nombre = nombre;
		this.cifraVentas = cifraVentas;
		this.nif = nif;
	}

	@Override
	public String toString() {
		return "Cliente{" + " nombre=" + nombre + " cifraVentas=" + cifraVentas + " nif=" + nif + '}';
	}

}
