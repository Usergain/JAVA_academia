package Ejercicio3;

public class Vagon {
	
	private String mercancia;
	private float toneladas;
	
	public Vagon(String mercancia, float toneladas) {
		this.mercancia = mercancia;
		this.toneladas = toneladas;
	}

	public String getMercancia() {
		return mercancia;
	}

	public float getToneladas() {
		return toneladas;
	}

	@Override
	public String toString() {
		return " >DATOS VAGON - " + " \n " + " > " + " MERCANCIAS: " + mercancia + " \n " + " MASA TONELADAS: " + toneladas + " \n ";
	}
	
}
	 
	


