package EjercicioPOO_041121;

public class Persona {
	
	private String dni;
	private int edad=0;
	private String nombre="";
	private String sexo="H";
	
	public Persona() {}
	
	public Persona(String nombre, int edad, String sexo) {
		this.nombre=nombre;
		this.edad = edad;
		this.sexo=sexo;
	}

	public Persona(String dni, int edad, String nombre, String sexo) {
		this.dni = dni;
		this.edad = edad;
		this.nombre = nombre;
		this.sexo = sexo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni() {
		this.dni=generaDNI();
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		if(sexo=="H" || sexo=="M") {
			this.sexo = sexo;
		}else {
			System.out.println("Lo siento, la opcion no es correcta");
		}
		
	}
	
	private boolean esMayorDeEdad() {
		boolean mayor=false;
		if (this.edad>=18)
			mayor=true;
		else
			mayor = false;
		return mayor;
	}
	
	private void comprobarSexo(char sexo)
	{
		if (sexo=='H' || sexo=='M')
			this.sexo=String.valueOf(sexo);
		else
			this.sexo="H"; //Ponga lo que ponga por defecto será H
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", edad=" + edad + ", nombre=" + nombre + ", sexo=" + sexo + "]";
	}
	
	public int CalcularIMC(float peso, float altura)
	{
		int valor_a_devolver;
		//    ASI NOOOOOOO
		//Scanner lector = new Scanner(System.in);
		//System.out.println("Dame peso:");
		//int peso = lector.nextInt();
		
		// ASI SIIIIII
		float IMC = (peso)/(altura*altura);
		if (IMC<20)
			valor_a_devolver=-1;
		else
		{
			if (IMC>=20 && IMC<=25)
				valor_a_devolver=0;
			else
				valor_a_devolver=1;
		}
		
		
		return valor_a_devolver;
	}
	
	public void ComprobarQueesMayorDeEdad() {
		boolean valor=false;
		valor=esMayorDeEdad();
		if (valor) // !=false 
			System.out.println("Es mayor de edad");
		else
			System.out.println("Es menor de edad");
	}
	
	public String generaDNI(){
		
		int digitos;
		digitos=(int)(Math.random()*(99999999)+1);
		
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        //La letra correspondiente será el resto de la división del número del DNI entre las 23 posibilidades que hay
        char letra = letras.charAt((int) (digitos % letras.length()));
        
        String DNI=new Integer(digitos).toString();
        
        String dniEntero = DNI + letra;
        
        return dniEntero;
	}
}
