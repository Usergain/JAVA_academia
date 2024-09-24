package POO;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona[] lasPersonas=new Persona[2];
		lasPersonas[0]=new Empleado2("Luis Conde",50000,2009,02,25);
		lasPersonas[1]=new Alumno("Ana Lopez","Biologicas");
		
		for (Persona p : lasPersonas) {
			System.out.println(p.dameNombre() + " " + p.dameDescripcion());
		}
		

	}

}

abstract class Persona{
	public Persona(String nom) {
		nombre=nom;
		
	}
	
	public String dameNombre() {
		return nombre;
	}
	
	public abstract String dameDescripcion();
	
	private String nombre;
}

class Empleado2 extends Persona{ //porque no entre en conflicto con la otra clase Empleados
	
	public Empleado2(String nom, double sue, int agno, int mes, int dia){
		
		super(nom);
		sueldo=sue;
		Id=IdSiguiente;
		IdSiguiente++;
		GregorianCalendar calendario=new GregorianCalendar(agno,mes-1,dia);
		altaContrato=calendario.getTime();
	}
	
	public String dameDescripcion() { //redefinir el metodo de la clase abstracta
		
		return "Este empleado tiene un Id= " + Id +"con un sueldo=" + sueldo;
	}
	
	
	
	public double dameSueldo() { 
		return sueldo;
	}
	
	public Date damefechaContrato() { 
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) { 
		double aumento=sueldo*porcentaje/100;
		sueldo+=aumento; 
	}
	
	private String nombre;
	private double sueldo;
	private Date altaContrato; 
	private static int IdSiguiente=1;
	private int Id;
	
}

class Alumno extends Persona{
	public Alumno(String nom, String car) {
		super(nom);
		carrera=car;
	}
	public String dameDescripcion() {
		return "Este alumno está estudiando la carrera de " + carrera;
	}
	private String carrera;
}