package Ejemplo;

//Empleado is-a Object
//Empleado is-a Persona
//Se hereda todo menos los constructores y los recursos privados
public class Empleado extends Persona{
	
	private double sueldo;
	private int antiguedad;
	
	public Empleado() {
		//this(null, 0, 'v',0,0,0);
		super();
	}

	public Empleado(String nombre, int edad, char sexo, float altura, double sueldo, int antiguedad ) {
		// Invocando al constructor de la superclase
		super(nombre, edad, sexo, altura);
		// TODO Auto-generated constructor stub
		this.sueldo = sueldo;
		this.antiguedad = antiguedad;
	}


	public double getSueldo() {
		return sueldo;
	}


	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}


	public int getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antiguedad;
		long temp;
		temp = Double.doubleToLongBits(sueldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (antiguedad != other.antiguedad)
			return false;
		if (Double.doubleToLongBits(sueldo) != Double
				.doubleToLongBits(other.sueldo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +
			   " Sueldo: " + sueldo + " Antieguedad : " + antiguedad	;
	}

}
