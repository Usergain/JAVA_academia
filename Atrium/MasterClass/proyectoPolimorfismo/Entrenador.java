package proyectoPolimorfismo;

public class Entrenador extends SeleccionFutbol {
	
private int idFederacion;
	
	public Entrenador() { }

	
	
	public Entrenador(int id, String nombre, String apellidos, int edad,int idFederacion) {
		super(id,nombre,apellidos,edad);
		this.idFederacion = idFederacion;
	}

	

	public int getIdFederacion() {
		return idFederacion;
	}



	public void setIdFederacion(int idFederacion) {
		this.idFederacion = idFederacion;
	}



	@Override
	public String toString() {
		return "Entrenador [idFederacion=" + idFederacion + "]";
	}



	@Override
	public void entrenamiento() {
		System.out.println("Está dirigiendo un entrenamiento (Clase Entrenador)");
		
	}



	@Override
	public void partidoFutbol() {
		System.out.println("Está dirigiendo un partido de Futbol (Clase Entrenador)");
	}
	
	public void planificarEntrenamiento() {
		System.out.println(" Está planificando un entrenamiento");
	}
	
	
	

}
