package proyectoPolimorfismo;

public class Futbolista extends SeleccionFutbol {
	
	private int dorsal;
	private String demarcacion;
	
	public Futbolista() { }

	public Futbolista(int id, String nombre, String apellidos, int edad,int dorsal, String demarcacion) {
		super(id,nombre,apellidos,edad);
		this.dorsal = dorsal;
		this.demarcacion = demarcacion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getDemarcacion() {
		return demarcacion;
	}

	public void setDemarcacion(String demarcacion) {
		this.demarcacion = demarcacion;
	}

	public void entrevista() {
		System.out.println(" Está dando una entrevista (Clase Futbolista)");
	}
	
	@Override
	public String toString() {
		return "Futbolista [dorsal=" + dorsal + ", demarcacion=" + demarcacion + "]";
	}
	
	@Override
	public void entrenamiento() {
		System.out.println("Está realizando un entrenamiento (Clase Futbolista)");
	}
	
	@Override
	public void partidoFutbol() {
		System.out.println("Está jugando un partido de futbol (Clase Futbolista)");
	}
	

}
