package entidades;

public class Persona {
	
    private int id_persona;
    private String dni;
    private int edad;

    // Constructor para insertar una Persona en BD
    public Persona(String dni, int edad) {
        this.dni = dni;
        this.edad = edad;
    }

    // Constructor para mostrar los datos de la BD
    public Persona(int id_persona, String dni, int edad) {
		super();
		this.id_persona = id_persona;
		this.dni = dni;
		this.edad = edad;
	}


	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "id_persona= " + id_persona +", dni= " + dni + " y edad=" + edad;
    }
    
}
