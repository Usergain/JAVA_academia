package entidades;

public class Persona {

	private int id;
	private String nombre;
	private String dni;
	private String email;
	private int telefono;
	private int edad;
	private String direccion;
	private int rol;

	public Persona(int id, String nombre, String dni, String email, int telefono, int edad, String direccion, int rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.edad = edad;
		this.direccion = direccion;
		this.rol = rol;
	}
	
	public Persona(String nombre, String dni, String email, int telefono, int edad, String direccion, int rol) {
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.edad = edad;
		this.direccion = direccion;
		this.rol = rol;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

}
