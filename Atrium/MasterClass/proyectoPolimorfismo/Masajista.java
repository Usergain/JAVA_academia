package proyectoPolimorfismo;

public class Masajista extends SeleccionFutbol {
	
	private String titulacion;
	private int anosExperiencia;
	
	public Masajista() { }

	
	public Masajista(int id, String nombre, String apellidos, int edad,String titulacion, int anosExperiencia) {
		super(id,nombre,apellidos,edad);
		this.titulacion = titulacion;
		this.anosExperiencia = anosExperiencia;
	}


	public String getTitulacion() {
		return titulacion;
	}


	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}


	public int getAnosExperiencia() {
		return anosExperiencia;
	}


	public void setAnosExperiencia(int anosExperiencia) {
		this.anosExperiencia = anosExperiencia;
	}


	@Override
	public String toString() {
		return "Masajista [titulacion=" + titulacion + ", anosExperiencia=" + anosExperiencia + "]";
	}


	@Override
	public void entrenamiento() {
		System.out.println(" Está dando asistencia a un entrenamiento (Clase Masajista)");
		
	}
	
	public void darMasaje() {
		System.out.println(" Está dando un masaje");
	}
	

}
