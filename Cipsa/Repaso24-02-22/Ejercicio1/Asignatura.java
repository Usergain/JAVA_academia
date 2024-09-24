package Ejercicio1;

public class Asignatura {
	private String Nombre;
	private String Area;
	
	public Asignatura(String sNom, String sAmbito) {
		this.Nombre=sNom;
		this.Area=sAmbito;
	}


	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	@Override
	public String toString() {
		return "Asignatura [Nombre=" + Nombre + ", Area=" + Area + "]";
	}
	
	
	
}
