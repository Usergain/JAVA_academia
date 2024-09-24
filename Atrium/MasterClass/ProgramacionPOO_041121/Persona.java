package ProgramacionPOO_041121;

public class Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private String sexo;
	//String [] materias;
	
	public Persona() {
	
	}
	
	public Persona(String dni, String nombre,String apellidos, int edad, String sexo)
	{
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	/*
	public Persona(String undni, String unnombre,String unosapellidos, int unaedad, String unsexo)
	{
		this.dni = undni;
		this.nombre = unnombre;
		this.apellidos = unosapellidos;
		this.edad = unaedad;
		this.sexo = unsexo;
	}
*/
	public Persona(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", sexo="
				+ sexo + "]";
	}
	
	public String acortar_el_nombre(String nombre)
	{
		this.nombre="Pepe";
		//int i=this.longuitudnombre();
		return nombre;
		
	}
	
	public int longuitudnombre()
	{
		return nombre.length();
	}
}
