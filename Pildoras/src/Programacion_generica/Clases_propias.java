package Programacion_generica;

public class Clases_propias <T> {
	
	private T primero;
	
		public Clases_propias() {
			
			primero=null;
	}
		
	public void setPrimero(T nuevoValor) {
		
		primero=nuevoValor;
	}
	
	public static void imprimirTrabajador(Clases_propias<? extends Empleado>p) { //Para que pueda ser utilizado por subclases. Tipo "Comodin"
		
		Empleado primero=p.getPrimero();
		
		System.out.println(primero);
	}
	
	public T getPrimero() {
		
		return primero;
	}
	
	// Este main deberia estar en otra clase externa, como en el ejemplo.
	
	public static void main(String[] args) {
		
		Clases_propias<String> una=new Clases_propias<String>(); //primero=null
		
		una.setPrimero("Juan");//primero = Juan
		
		System.out.println(una.getPrimero());
		
		Persona pers1=new Persona("Ana");
		
		Clases_propias<Persona> otra=new Clases_propias<Persona>();
		
		otra.setPrimero(pers1);
		
		System.out.println(otra.getPrimero());	
	}
	
}

class Persona{
	
	private String nombre;
	
	public Persona(String nombre) {
		
		this.nombre=nombre;
	}
	
	public String toString() {
		
		return nombre;
	}
}

