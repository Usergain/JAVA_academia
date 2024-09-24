package Ejer2;

public class Persona {
	
	private String nombre="";
	private int edad=0;
	private String dni;
	private char sexo='H';
	private float peso=0;
	
	public Persona(){
		
	}
	
	public Persona(String nombre, int edad, char sexo) {
		this.nombre=nombre;
		this.edad=edad;
		this.sexo=sexo;
	}
	
	public Persona(String nombre, int edad, String dni, char sexo, float peso) {
		this.nombre=nombre;
		this.edad=edad;
		this.dni=dni;
		this.sexo=sexo;
		this.peso=peso;
	}
	
	public int calcularIMC(float peso, float altura){
		float pesoI=peso/(altura*altura);
		final int resultado;
		
		if(pesoI<20) {
			resultado=-1; //por debajo del peso ideal.
		}
		else if(pesoI>20 && pesoI<25) {
			resultado=0; //en el peso ideal.
		}
		else {
			resultado=1; //por encima del peso ideal.
		}
		
		return resultado;
	}
	
	public boolean esMayorDeEdad(Persona persona) {
		boolean resultado;
		
		if(persona.getEdad()<18) {
			resultado=false;
		}
		else {
			resultado=true;
		}
		return resultado;
	}
	
	public char comprobarSexo(Persona persona) {
		char resultado = 0;
		
		if(persona.getSexo()=='H') {
			resultado='H';
		}
		else if(persona.getSexo()=='M'){
			resultado='M';	
		}
		else {
			resultado='H';
		}
		
		return resultado;
	}
	
	public void generaDNI() {
		
		int numDni=(int)Math.floor(Math.random()*(1000000-(100000000+1))+(100000000+1));
		String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";
		int modulo= numDni % 23;
		
		char letra = juegoCaracteres.charAt(modulo);
		this.dni=String.valueOf(numDni)+ "-"+ letra;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", sexo=" + sexo + ", peso=" + peso
				+ "]";
	}

}


