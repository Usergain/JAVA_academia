package HerenciaValida;

public class Entrenador extends SeleccionFutbol{
	
	private String idFederacion;
	
	public Entrenador() { }

	public Entrenador(int id, String nombre, String apellidos, int edad,String idFederacion) {
		super(id,nombre,apellidos,edad);
		this.idFederacion = idFederacion;
	}

	public String getIdFederacion() {
		return idFederacion;
	}

	public void setIdFederacion(String idFederacion) {
		this.idFederacion = idFederacion;
	}
	
	public void dirigirPartido() {
		System.out.println(" El Entrenador, clase hija, esta dirigiendo un partido");
	}

	public void  dirigirEntrenamiento() {
		System.out.println(" El Entrenador, clase hija, esta dirigiendo un entrenamiento");
	}
}

