package Ejercicio1;

public class CuentaBancaria implements Comparable<CuentaBancaria> {

	private String cuenta;
	private String dni_titular;
	private String nombre_titular;
	private float capital = 0f;

	public CuentaBancaria(String cuenta, String dni_titular, String nombre_titular, float capital) {
		this.cuenta = cuenta;
		this.dni_titular = dni_titular;
		this.nombre_titular = nombre_titular;
		this.capital = capital;
	}

	@Override
	public int compareTo(CuentaBancaria o) {
		if (o.capital > this.capital) {
			return -1;
		} else if (o.capital < this.capital) {
			return 1;
		} else
			return 0;
	}

	@Override
	public String toString() {
		return "NºCUENTA: " + cuenta + " TITULAR: " + dni_titular + " " + nombre_titular + " SALDO: " + capital + "\n";
	}

}
