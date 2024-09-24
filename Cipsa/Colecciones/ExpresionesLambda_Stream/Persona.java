package ExpresionesLambda_Stream;

import java.util.Objects;

public class Persona implements Comparable<Persona>{
	public String nombre;
	public int edad;
	public float altura;
	public String categoria;
	
	public Persona(String nombre, int edad, float altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
	}

	public Persona(String nombre, int edad, float altura, String categoria) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + ", categoria=" + categoria + "]" + "\n";
	}

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return Float.compare(this.edad, o.edad);
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, categoria, edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Float.floatToIntBits(altura) == Float.floatToIntBits(other.altura)
				&& Objects.equals(categoria, other.categoria) && edad == other.edad
				&& Objects.equals(nombre, other.nombre);
	}

}
