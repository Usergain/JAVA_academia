package POO;

import java.util.*;

public class Uso_Empleado {

	public static void main(String[] args) {
		
		Jefatura jefe_RRHH=new Jefatura("Juan",55000,2006,9,25);
		jefe_RRHH.estableceIncentivo(2570);
		
		
		// TODO Auto-generated method stub
		/*Empleado empleado1=new Empleado("Paco Gómez",85000,1990,12,17); //metiendo argumentos al constructor, creando tres instancias de clases
		Empleado empleado2=new Empleado("Ana Lopez",95000,1995,06,02);
		Empleado empleado3=new Empleado("Maria Martin",105000,2002,03,15);
		
		empleado1.subeSueldo(5);
		empleado2.subeSueldo(5);
		empleado3.subeSueldo(5);
		
		System.out.println(" Nombre: " + empleado1.dameNombre() + " Sueldo: " + empleado1.dameSueldo() + " Fecha de Alta " + empleado1.damefechaContrato());
		System.out.println(" Nombre: " + empleado2.dameNombre() + " Sueldo: " + empleado2.dameSueldo() + " Fecha de Alta " + empleado2.damefechaContrato());
		System.out.println(" Nombre: " + empleado3.dameNombre() + " Sueldo: " + empleado3.dameSueldo() + " Fecha de Alta " + empleado3.damefechaContrato());
		*/
		
		Empleado[]misEmpleados=new Empleado[6];
		//String[]miarray=new String[3]; para ver que es lo mismo que el array de arriba
		misEmpleados[0]=new Empleado("Paco Gómez",85000,1990,12,17);
		misEmpleados[1]=new Empleado("Ana Lopez",95000,1995,06,02);
		misEmpleados[2]=new Empleado("Maria Martin",105000,2002,03,15);
		misEmpleados[3]=new Empleado("Antonio Fernandez"); //Estaremos llamando al segundo constructor.
		misEmpleados[4]=jefe_RRHH; //Polimorfismo. Principio de sustitución
		misEmpleados[5]=new Jefatura("Maria",95000,1999,5,26);
		
		Jefatura jefa_finanzas=(Jefatura)misEmpleados[5]; //Casting para pasar Empleados a Jefatura
		jefa_finanzas.estableceIncentivo(55000);
		
		Empleado director_comercial=new Jefatura("Sandra",8500,2012,05,05);
		Comparable ejemplo=new Empleado("Elisabeth",9500,2011,06,07);
		
		if(director_comercial instanceof Empleado) { //Para saber si es de tipo o hereda
			System.out.println("Es de tipo Jefatura");
		}
		if(ejemplo instanceof Comparable) {
			System.out.println("Implementa la interfaz comparable");
		}
		
		
		/*for(int i=0;i<3;i++) {
			misEmpleados[i].subeSueldo(5);
		}
		
		for (int i = 0; i < misEmpleados.length; i++) {
			System.out.println("Nombre: " + misEmpleados[i].dameNombre() + " Sueldo " + misEmpleados[i].dameSueldo() + " Fecha de Alta: " + misEmpleados[i].damefechaContrato());
		}*/
		
		System.out.println(jefa_finanzas.tomar_decisiones("Dar más dias de vacaciones a los empleados"));
		
		System.out.println("El jefe " + jefa_finanzas.dameNombre() + " tiene un bonus de: " +jefa_finanzas.establece_bonus(500));
		System.out.println("El empleado " + misEmpleados[3].dameNombre() + "tiene un bonus de: " + misEmpleados[3].establece_bonus(200));
		
		
		for (Empleado e : misEmpleados) { //bucle for mejorado
			e.subeSueldo(5);
		}
		
		Arrays.sort(misEmpleados);
		
		for (Empleado e : misEmpleados) {
			System.out.println( "Nombre: " + e.dameNombre() 
			+ " Sueldo " + e.dameSueldo() 
			+ " Fecha de Alta: " + e.damefechaContrato());	
		}
		

	}

}

class Empleado implements Comparable, Trabajadores{ //Si no escribiesemos un constructor se ejecutaría un constructor por defecto public "Empleados();"
	public Empleado(String nom, double sue, int agno, int mes, int dia){//Constructor con parámetros/argumentos. Ni return, ni void.
		
		nombre=nom;
		sueldo=sue;
		// Para crear una fecha
		GregorianCalendar calendario=new GregorianCalendar(agno,mes-1,dia);// constructor GregorianCalendar de la clase GregorianCalendar de la libreria java.util
		altaContrato=calendario.getTime();// Objeto de tipo Gregorian calendar con metodo .getTime heredado de otro objeto.
		Id=IdSiguiente;
		IdSiguiente++;
	}
	
	public Empleado(String nom) { //sobrecarga de constructores
		this(nom,30000,2000,01,01); //Cuando invocamos este constructor, almacena los datos introducidos por defectos, utilizaremos el ".this" para invocar seguidamente el otro constructor
		nombre=nom;
		++IdSiguiente;
		Id=IdSiguiente;
		
	
	}
	
	public String dameNombre() {
		return nombre + ", Id :" + Id + " , ";
	}
	

	public double dameSueldo() { //getter
		return sueldo;
	}
	
	public Date damefechaContrato() { //getter
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) { //setter
		double aumento=sueldo*porcentaje/100;
		sueldo+=aumento; //+= operador incremento
	}
	public int compareTo(Object miObjeto) { //Para poder implemenatar la interfaz Comparable
		Empleado otroEmpleado=(Empleado)miObjeto; //Casting		
		if(this.sueldo<otroEmpleado.sueldo) {
			return -1;
		}
		if(this.sueldo>otroEmpleado.sueldo) {
			return 1;
		}
		
		return 0;
	}
	
	public double establece_bonus(double gratificacion){
		return Trabajadores.bonus_base+gratificacion;
	}
	
	// Campos de clase
	private String nombre;
	private double sueldo;// variable primitivo de datos
	private Date altaContrato; //variable de tipo Date(Objeto)
	private int Id;
	private static int IdSiguiente=1;
	
}

/*final*/ class Jefatura extends Empleado implements Jefes{ //final: deteniendo la cadena de Herencia de la clase *
	

	public Jefatura(String nom, double sue, int agno, int mes, int dia) {
		super(nom,sue,agno,mes,dia);
		
	}
	
	public void estableceIncentivo(double b) {
		incentivo=b;
	}
	
	public double dameSueldo() {
		double sueldoJefe=super.dameSueldo();
		return sueldoJefe + incentivo;
	}
	
	public String tomar_decisiones(String decision) {
		return "Un miembro de la direccion ha tomado la decisión de: " + decision ;
 	}
	
	public double establece_bonus(double gratificacion) {
		double prima=2000;
		return Trabajadores.bonus_base+gratificacion+prima;
	}
	
	private double incentivo; //campos de clase
			
	
}

	/*class Director extends Jefatura{
		public Director(String nom, double sue, int agno, int mes, int dia) {
			super(nom,sue,agno,mes,dia);
		}
	}*/
