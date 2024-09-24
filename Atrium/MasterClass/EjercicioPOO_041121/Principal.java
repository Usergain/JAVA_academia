package EjercicioPOO_041121;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Scanner lector = new Scanner(System.in);
			
			System.out.println("Usuario introduce 3 objetos de tipo persona.");
			System.out.println("1 Persona: ");
			System.out.println("Dame nombre: ");
			String nombre = lector.nextLine();
			System.out.println("Dame sexo: ");
			String sexo = lector.nextLine();
			System.out.println("Dame edad: ");
			int edad = lector.nextInt();
			System.out.println("Dame peso: ");
			float peso = lector.nextFloat();
			System.out.println("Dame altura: ");
			float altura = lector.nextFloat();
			
			lector.nextLine();
			
			Persona una = new Persona(nombre,edad,sexo);
			int valor = una.CalcularIMC(peso, altura);
			if (valor ==0)
				System.out.println("Estas ideal");
			else
			{
				if (valor<0)
					System.out.println("Estas muy delgado");
				else
					System.out.println("Estas demasiado obeso");
			}
			una.ComprobarQueesMayorDeEdad();
			
			
			Persona [] lista_personas = new Persona[10];
			String nombre1="";
			String sexo1="";
			int edad1;
			float peso1;
			float altura1;
			String dni1;
			for (int i=0;i<2;i++)
			{
				System.out.println(" Persona "+i+": ");
				System.out.println("Dame nombre: ");
				nombre1 = lector.nextLine();
				System.out.println("Dame sexo: ");
				sexo1 = lector.nextLine();
					/*if(sexo=="H" || sexo=="M") {
						sexo1 = sexo;
					}else {
						System.out.println("Lo siento, la opcion no es correcta");
						sexo1=null;
					} me salta directamente al else, porque?*/
				System.out.println("Dame edad: ");
				edad1 = lector.nextInt();
				System.out.println("Dame peso: ");
				peso1 = lector.nextFloat();
				System.out.println("Dame altura: ");
				altura1 = lector.nextFloat(); 
				
				lista_personas[i]= new Persona(nombre1,edad1,sexo1);
				
				dni1=lista_personas[i].generaDNI();
				
				lista_personas[i]=new Persona(dni1,edad1,nombre1,sexo1);
				
				lector.nextLine();
			}
			
			for (int i=0;i<2;i++)
			{
				System.out.println(lista_personas[i].toString());
			}
			
		
			
			
		}
	
			

	}

