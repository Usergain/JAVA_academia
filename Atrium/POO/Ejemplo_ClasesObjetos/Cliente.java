package Ejemplo_ClasesObjetos;

public class Cliente extends Object {
	
	// caracteristicas -> propiedades
	public int codigo;
	public String nombre;
	public String apellido;
	public String email;
	public long telefono;
	public boolean nuevo;
	public double cifraVentas;
	
	// Constructor
	// Por defecto
	public Cliente() {
		// TODO Auto-generated constructor stub
	}	
	
	public Cliente(int codigo, String nombre, String email) {
		super(); // Object()
		this.codigo = codigo;
		this.nombre = nombre;
		this.email = email;
	}

	public Cliente(int codigo, String nombre, String email, long telefono,
			boolean nuevo, double cifraVentas) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.nuevo = nuevo;
		this.cifraVentas = cifraVentas;
	}

	// acciones -> metodos
	public void mostrarDatos(){
		System.out.println("Codigo: " + codigo + " Nombre: " + nombre + " ... " );
	}
	
	public double verCifraVentas(){
		return cifraVentas;
	}
	
	public void cambiarTelefono(long nuevoTelefono){
		telefono = nuevoTelefono;
	}
	

}
