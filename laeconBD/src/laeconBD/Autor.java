package laeconBD;

public class Autor {
	
	private int idautor;
	private String nombre;
	private String apellidos;
	private String nacionalidad;
	private String fnacimiento;
	
	public Autor(int idautor, String nombre, String apellidos, String nacionalidad, String fnacimiento) {
		this.idautor = idautor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacionalidad = nacionalidad;
		this.fnacimiento = fnacimiento;
	}
	
	public Autor() {
		
	}

	public int getIdautor() {
		return idautor;
	}

	public void setIdautor(int idautor) {
		this.idautor = idautor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(String fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos;
	}
	
	
	

}
