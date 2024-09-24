package POO;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleados trabajador1=new Empleados("Paco");
		Empleados trabajador2=new Empleados("Ana");
		Empleados trabajador3=new Empleados("Antonio");
		Empleados trabajador4=new Empleados("Maria");
		
		trabajador1.cambiaSeccion("RRHH");
		//trabajador1.cambiaNombre("Maria"); //En este caso cambiariamos el nombre, pero cuando no quieres que se pueda modificar esta variable
		// utilizado una constante FINAL
		
		System.out.println(trabajador1.devuelveDatos());
		System.out.println(trabajador2.devuelveDatos()+"\n"+ trabajador3.devuelveDatos()+"\n"+trabajador4.devuelveDatos());
		/*//Empleados.Id++;//para ir incrementando el Id de los trabajadores
		System.out.println(trabajador2.devuelveDatos());
		//Empleados.Id++;
		System.out.println(trabajador3.devuelveDatos());
		System.out.println(trabajador4.devuelveDatos());*/
		
		System.out.println(Empleados.dameIdSiguiente());
		

	}

}

class Empleados{
	public Empleados(String nom) {
		nombre=nom;
		seccion="Administración";
		//Id=1;
		Id=IdSiguiente;
		IdSiguiente++;
		
	}
	
	public void cambiaSeccion(String seccion) {//setter
		this.seccion=seccion;//campo de clase this.seccion
	}
	
	public String devuelveDatos() {
		return "El nombre es: " + nombre + " ,la seccion es " + seccion + " y el Id= " +Id;
	}
	
	public void cambiaNombre(String nombre) {
		//this.nombre=nombre; //te pita error porque nombre es una constante FINAL
	}
	
	public static String dameIdSiguiente() {//getter
		return "El IdSiguiente es: " + IdSiguiente;
	}
	
	private final String nombre; //tratamos esta variable como CONSTANTE
	private String seccion;
	//public static int Id; // Una variable de clase que es comun a todos los objetos. Para compartir
	private int Id;
	private static int IdSiguiente=1; // a la hora de construir objetos e incrementarlos no hay que añadir nada. Se incrementa solo
}									  // "CAMPO DE CLASE"
