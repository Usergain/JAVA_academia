package entidades;

public class Duenio {
	
	private String id_duenio;
	private String nombre;
	private String apellido;
	private String fecha_nacimiento;
	private String domicilio;
	
	public Duenio(String id_duenio, String nombre,String apellido, String fecha_nacimiento, String domicilio) {
		this.id_duenio=id_duenio;
		this.nombre=nombre;
		this.apellido=apellido;
		this.fecha_nacimiento=fecha_nacimiento;
		this.domicilio=domicilio;
	}

	public String getId_duenio() {
		return id_duenio;
	}

	public void setId_duenio(String id_duenio) {
		this.id_duenio = id_duenio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Duenio [id_duenio=" + id_duenio + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", domicilio=" + domicilio + "]";
	}


}
