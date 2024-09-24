package entidades;

public class Roles {
	
	private int id;
	private String nombre;
	
	public Roles(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
