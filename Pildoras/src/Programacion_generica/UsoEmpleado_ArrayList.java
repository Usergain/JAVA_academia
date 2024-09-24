package Programacion_generica;

import java.util.*;

public class UsoEmpleado_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Empleado listaEmpleados[]=new Empleado[3];
		
		listaEmpleados[0]=new Empleado("Ana",45,2500);
		listaEmpleados[1]=new Empleado("Antonio",55,2000);
		listaEmpleados[2]=new Empleado("Maria",25,2600);*/
		
		ArrayList<Empleado>listaEmpleados=new ArrayList<Empleado>();
		
		/* Por defecto los Arraylist estan preparados para 10 elementos, si se va añadiendo más. 
		 * Internamente irá haciendo una copia de los 10 y añadirá los nuevos. Consume muchos recursos.
		 listaEmpleados.ensureCapacity(11);
		*/
		
		listaEmpleados.add(new Empleado("Ana",45,2500));
		listaEmpleados.add(new Empleado("Antonio",55,2000));
		listaEmpleados.add(new Empleado("Maria",25,2600));
		listaEmpleados.add(new Empleado("Jose",35,2200));
		listaEmpleados.add(new Empleado("Ana",45,2500));
		listaEmpleados.add(new Empleado("Antonio",55,2000));
		listaEmpleados.add(new Empleado("Maria",25,2600));
		listaEmpleados.add(new Empleado("Jose",35,2200));
		listaEmpleados.add(new Empleado("Ana",45,2500));
		listaEmpleados.add(new Empleado("Antonio",55,2000));
		listaEmpleados.add(new Empleado("Maria",25,2600));
		listaEmpleados.add(new Empleado("Jose",35,2200));
		listaEmpleados.add(new Empleado("Ana",45,2500));
		listaEmpleados.add(new Empleado("Antonio",55,2000));
		listaEmpleados.add(new Empleado("Maria",25,2600));
		listaEmpleados.add(new Empleado("Jose",35,2200));
		
		/*Si estas seguro que no se van a añdir más elementos. Asi no come tantos recursos.
		listaEmpleados.trimToSize();*/
		
		listaEmpleados.set(1, new Empleado("Olga",22,2200)); //Para añadir objetos en una posicion determinada.
		
		//System.out.println(listaEmpleados.get(4).dameDatos()); // imprimir por pantalla un determinado objeto.
		
		
		System.out.println(listaEmpleados.size());
		
		/*Bucle for each
		for (Empleado empleado : listaEmpleados) {
			System.out.println(empleado.dameDatos());
		}
		
		*Bucle for convencional, se puede manejar de esta forma:
		 * 
		for (int i = 0; i <listaEmpleados.size(); i++) {
			Empleado e=listaEmpleados.get(i);
			
			System.out.println(e.dameDatos());
		}
		
		*Otro forma sería:
		*
		*Empleado arrayEmpleados[]=new Empleado[listaEmpleados.size()];
		*listaEmpleados.toArray(arratEmpleados);
		*
		*for(int i=0;i<arrayEmpleados.length;i++){
		*	system.out.println(arrayEmpleados[i].dameDatos());	
		*/
		
		Iterator<Empleado>mi_iterador=listaEmpleados.iterator();
		
		while(mi_iterador.hasNext()) {
			System.out.println(mi_iterador.next().dameDatos());
		}
	}

}

class Empleado{
	private String nombre;
	private int edad;
	private double salario;
	
	public Empleado(String nombre, int edad, double salario) {
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
	}
	
	public String dameDatos() {
		return "El empleado se llama " + nombre + ". Tiene " + edad + " años. " + " Y un salario de " + salario + "€";
	}
}
