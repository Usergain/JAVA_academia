package proyectoPolimorfismo;

public abstract class SeleccionFutbol {
	
	protected int id;
	protected String nombre;
	protected String apellidos;
	protected int edad;
	
	public SeleccionFutbol() { }

	public SeleccionFutbol(int id, String nombre, String apellidos, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	public void Viajar() {
		System.out.println("Se está viajando desde la clase Abstracta o Polimorfica");
	}
	
	public void concentrarse() {
		System.out.println("Se está concentrado desde la clase Abstracta o Polimorfica");
	}
	
	public void partidoFutbol() {
		System.out.println(" Asistiendo a un partido de futbol clase Abstracta o Polimorfica");
	}
	
	public abstract void entrenamiento();

}
