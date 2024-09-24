package Programacion_generica;

public class HerenciaGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Esto es el ejemplo de la intanciaciones de las clases y sus herencias
		 * 
		 * Empleado Administrativa=new Empleado("Elena",45,1500);
		 * 
			Jefe DirectoraComercial=new Jefe("Ana",27,3500);
		
			Empleado nuevoEmpleado=DirectoraComercial;*/
		
		Clases_propias<Empleado>Administrativa=new Clases_propias<Empleado>();
		Clases_propias<Jefe>DirectoraComercial=new Clases_propias<Jefe>();
		
		// En las clases genericas no tienen los mismos fundamentos de sustitucion que las clases normales
		
		Clases_propias.imprimirTrabajador(Administrativa);
		Clases_propias.imprimirTrabajador(DirectoraComercial);

	}
	
}
	
// Esto deberia estar en otra clase aparte

public class Empleado{
	
	private String nombre;
	private int edad;
	private double salario;
	
	public Empleado(String nombre, int edad, double salario){
		
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
		
	}
}

// Esto deberia estar en otra clase aparte

class Jefe extends Empleado{
	
	public Jefe(String nombre, int edad, double salario) {
		
		super(nombre,edad,salario);
	}
	
	double incentivo(double inc) {
		
		return inc;
	}
}

