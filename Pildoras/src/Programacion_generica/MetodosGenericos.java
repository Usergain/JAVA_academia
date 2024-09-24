package Programacion_generica;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MetodosGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombres[]={"Jose","Maria","Pepe"};
		
		System.out.println(MisMatrices.getMenor(nombres));
		
		String elementos=MisMatrices.getElementos(nombres);
		
		System.out.println(elementos);
		
		Empleado ListaEmpleados[]= {new Empleado("Ana",15,2500),
				new Empleado("Ana",15,2500),
				new Empleado("Ana",15,2500),
				new Empleado("Ana",15,2500),
				new Empleado("Ana",15,2500)
		};
		
		System.out.println(MisMatrices.getElementos(ListaEmpleados));
		
		//System.out.println(MisMatrices.getMenor(ListaEmpleados)); No funciona porque la Clase Empleado no hereda de la interfaz Comparable
		
		
		GregorianCalendar fechas[]= {new GregorianCalendar(2015,07,12),
				new GregorianCalendar(2015,05,18),
				new GregorianCalendar(2021,04,1),
		};
		
		System.out.println(MisMatrices.getMenor(fechas).get(Calendar.DAY_OF_MONTH) + " " + MisMatrices.getMenor(fechas).get(Calendar.MONTH) + " " +  MisMatrices.getMenor(fechas).get(Calendar.YEAR) );

	}

}

class MisMatrices{
	
	// Al ser static no hace falta instamcias desde la clase MetodosGenericos
	
	public static <T> String getElementos(T[]a) {
		
		return "El array tiene " + a.length + " elementos";
	}
	
	public static <T extends Comparable> T getMenor(T[]a){ //extends porque implementa la interfaz pero tambien extendiende de sus subclases
		
		if(a==null || a.length==0) {
			
			return null;
		}
		
		T elementoMenor=a[0];
		
		for(int i=1;i<a.length;i++){
			
			if(elementoMenor.compareTo(a[i])>0) { //implementa de la interfaz comparable.
				
				elementoMenor=a[i];
			}
		}
		
		return elementoMenor;
	}
	
}
