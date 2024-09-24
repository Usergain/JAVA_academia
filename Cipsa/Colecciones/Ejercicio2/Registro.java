package Ejercicio2;

public class Registro implements Comparable<Registro> {
	private int mes;
	private int anio;
	private float lluvia;

	public Registro(int mes, int anio, float lluvia) {
		if (mes >= 1 && mes <= 12 && anio > 0 && lluvia > 0.00f) { // en el main estaria mejor
			this.mes = mes;
			this.anio = anio;
			this.lluvia = lluvia;

		} else {
			System.out.println("Hay un rango que no está bien introducido" + "\n");// en el main estaria mejor
		}
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public float getLluvia() {
		return lluvia;
	}

	public void setLluvia(float lluvia) {
		this.lluvia = lluvia;
	}

	@Override
	public int compareTo(Registro o) {
		if (o.getLluvia() > this.lluvia)
			return -1;
		else if (o.getLluvia() < this.lluvia)
			return +1;
		else
			return 0;

	}

	@Override
	public String toString() {
		return " mes=" + mes + ", anio=" + anio + ", lluvia=" + lluvia + "\n";
	}

}
