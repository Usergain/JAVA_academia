package Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		ArrayList<Alumno> alumnos = new ArrayList<>();
	
		// TODO Auto-generated method stub
		
		 int opcion;
	     boolean salir = false;
	     
	     GestionRegistro coleccion = new GestionRegistro();
	     
	     while (!salir) {

	            System.out.println(" ******** Menú Principal ******** ");
	            
	            System.out.println(" 0- Salir ");
	            System.out.println(" 1- Registrar lluvia ");
	            System.out.println(" 2- Mostrar lluvia");
	            System.out.println(" 3- Mostrar promedio");
	            System.out.println(" 4- Mostrar máximo");
	            System.out.println(" 5- Mostrar mínimo");
	            System.out.println(" 6- Mostrar ordenado");
	            
	            System.out.println(" ******************************** ");


	            Scanner sc = new Scanner(System.in);
	            opcion = sc.nextInt();

	            switch (opcion) {

	                case 1:
	                {
	                	System.out.println(" Introduzca el mes ");
                        int mes  = sc.nextInt();
	                	System.out.println(" Introduzca el añio ");
	                	int anio= sc.nextInt();
	                	System.out.println(" Introduzca los litros por metro cuadrado de lluvia ");
	                	float lluvia = sc.nextFloat();
	                	coleccion.anadirRegistrarLluvia(mes, anio, lluvia);
	                }; break;
	                	
	                case 2: {
	                	System.out.println(" Introduce un mes ");
	                	int mes=sc.nextInt();
	                	System.out.println(" Introduce un añio ");
	                	int anio=sc.nextInt();
	                	try {
	                		System.out.println("Las precipitaciones: " + coleccion.obtenerLluvia(mes, anio));
	                	} catch (Exception e) {
						// TODO Auto-generated catch block
	                		System.out.println("No existe registro para ese año y mes");
	                	}
					};
					break;
	                	
	                case 3: {
	                	System.out.println("Dame un año");
	                	int anio3=sc.nextInt();
	                	System.out.println("Cantidad media de precipitaciones es: " + coleccion.promedio(anio3));
	                };
	                break;
	                	
	                case 4: 
	                	System.out.println(" El dia con mayores precipitaciones: " + coleccion.maximo());
	                	break;
	                	
	                case 5:
	                	System.out.println(" El dia con minimo precipitaciones: " + coleccion.minimo());
	                	break;
	                	
	                case 6:
	                	System.out.println(" Registro ordenado de menor a mayor : ");
	                	coleccion.mostrarOrdenado();
	                	break;
	                	
	                case 0:
	        			System.out.println("Fin del programa");
	        			System.exit(0);
	        			break;
	                	
	                default:
	                	System.out.println("Seleccione una opcion valida" + "\n");
	                	break;
	                		
	            }
	     
	     }
	     
	}
	
}
             
		