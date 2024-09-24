package Ejercicio1;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno[] alumnos = new Alumno[3];
		Alumno[]alumnos2=new Alumno[3];
		
		alumnos[0] = new Alumno("Jhonny", "Mendez", 20, 4f, 'H', 
				new Asignatura[] {
						new Asignatura("Matematica", "Ciencias"), 
						new Asignatura("Fisica", "Ciencias"), 
						new Asignatura("Filología", "Letras")
				});
		alumnos[1] = new Alumno("Victor", "Right", 23, 6f, 'H', 
				new Asignatura[] {
						new Asignatura("Programacion", "Ciencias"), 
						new Asignatura("Filosofia", "Letras"), 
				});
		alumnos[2] = new Alumno("Ana", "Gonzalez", 19, 7, 'M', 
				new Asignatura[] {
						new Asignatura("Estadística", "Ciencias"), 
						new Asignatura("Electrónica", "Ciencias")
				});
		
		Aula aula = new Aula( alumnos ); 
		Academia academia = new Academia(aula);
		
		alumnos2[0] = new Alumno("Arantza", "Lorenzo", 19, 9, 'M', 
				new Asignatura[] {
						new Asignatura("Estadística", "Ciencias"), 
						new Asignatura("Dibujo", "Arte")
				});
		
		alumnos2[1] = new Alumno("Arkaitz", "Artaraz", 19, 5, 'H', 
				new Asignatura[] {
						new Asignatura("Baloncesto", "Deporte"), 
						new Asignatura("Electrónica", "Ciencias")
				});
		
		alumnos2[2] = new Alumno("Aiza", "Artaraz", 19, 10, 'M', 
				new Asignatura[] {
						new Asignatura("Euskera", "Idiomas"), 
						new Asignatura("Matemáticas", "Ciencias")
				});
		
		Aula aula2 = new Aula( alumnos2 ); 
		Academia academia2 = new Academia(aula2);
		
		for (int i = 0; i < aula.getTotalAlumnos(); i++) {
			Alumno alumno = aula.getAlumno(i);
			System.out.println("Alumno: \n" + alumno.toString());
			System.out.println("Asignaturas: ");
			for( Asignatura asignatura : alumno.getAsignatura()) 
				System.out.println(asignatura.toString());
		}
		
		
		System.out.println("Hombres: " + aula.getNumHombres());
		System.out.println("Mujeres: " +  aula.getNumMujeres());
		System.out.println("Media: " + aula.calcularMedia());
		
		System.out.println(" ");
		
		System.out.println(academia.getMediaAulas(aula));
		
		
		System.out.println(academia.resumenSexoEstudiantes(aula).toString());
		
		
		System.out.println(" ");
		
		for (int i = 0; i < aula2.getTotalAlumnos(); i++) {
			Alumno alumno2 = aula2.getAlumno(i);
			System.out.println("Alumno: \n" + alumno2.toString());
			System.out.println("Asignaturas: ");
			for( Asignatura asignatura : alumno2.getAsignatura()) 
				System.out.println(asignatura.toString());
		}
		
		
		System.out.println("Hombres: " + aula2.getNumHombres());
		System.out.println("Mujeres: " +  aula2.getNumMujeres());
		
		System.out.println("Media: " + aula2.calcularMedia());
		
		System.out.println(" ");
		
		System.out.println(academia2.getMediaAulas(aula2));		
		
		System.out.println(academia2.resumenSexoEstudiantes(aula2).toString());
		
		 
		
		System.out.println(StringUtil.Concatenar("Arkaitz", "Artaraz"));
		System.out.println(StringUtil.BuscaYElimina(" Este mundo es maravilloso ", "mundo")); 
		
		
	}

	

	/* Programa que empezé a implementar yo, es verdad que mejor mejor datos fijos para ver si
	 * funcion o no 
	 * 
	 * @param args
	 *public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno alumno = new Alumno();
		Asignatura[] asignatura = new Asignatura[10];
		Aula aula=new Aula(null);
		Alumno[] alumnos = new Alumno[10];
		Scanner teclado = new Scanner(System.in);
		String nombre;
		String apellidos;
		int edad;
		int nota;
		char sexo;
		String nombreAsignatura;
		String areaAsignatura;*/

		/*
		 * System.out.println(" Vamos a ir metiendo datos del nuevo alumno: ");
		 * System.out.print(" Dame el nombre del nuevo alumno: ");
		 * nombre=teclado.next();
		 * System.out.println(" Dame el apellido del nuevo alumno: ");
		 * apellidos=teclado.next();
		 * System.out.println(" Dame la edad del nuevo alumno: ");
		 * edad=teclado.nextInt(); System.out.println(" Dame la nota del alumno: ");
		 * nota=teclado.nextInt(); if(nota<0) { nota=0; } else if(nota>10) { nota=10; }
		 * System.out.println(" Dame el sexo del alumno: ");
		 * sexo=teclado.next().charAt(0);
		 * 
		 * alumno.setNombre(nombre); alumno.setApellidos(apellidos);
		 * alumno.setEdad(edad); alumno.setNota(nota);
		 * alumno.setSexo(sexo);alumno2.getAsignatura()[i]
		 * 
		 * System.out.println(alumno.toString());
		 */

		/*System.out.println("                  PROGRAMA                    ");
		System.out.println(" *********************************************");
		System.out.println("");

		for (int j = 0; j < 3; j++) {

			System.out.println(" Vamos a ir metiendo datos del nuevo alumno: ");
			System.out.println("");
			System.out.print("   Dame el nombre del nuevo alumno: ");
			nombre = teclado.next();
			System.out.println(" Dame el apellido del nuevo alumno: ");
			apellidos = teclado.next();
			System.out.println(" Dame la edad del nuevo alumno: ");
			edad = teclado.nextInt();
			System.out.println(" Dame la nota del alumno: ");
			nota = teclado.nextInt();
			if (nota < 0) {
				nota = 0;
			} else if (nota > 10) {
				nota = 10;
			}


				do {
					System.out.println(" Dame el sexo del alumno: ");
					sexo = teclado.next().charAt(0);
					teclado.nextLine();// Limpiamos buffer de entrada
				}while(sexo != 'H' && sexo != 'M');

			System.out.println(" ¿Cuántas materias está cursando el alumno?");
			int totalMaterias = teclado.nextInt();

			for (int i = 0; i < totalMaterias; i++) {

				System.out.println(" Dame el nombre de la asignatura: ");
				nombreAsignatura = teclado.nextLine();
				teclado.nextLine();// Limpiamos buffer de entrada
				System.out.println(" Dame el area de la asignatura: ");
				areaAsignatura = teclado.nextLine();
				teclado.nextLine();// Limpiamos buffer de entrada

				asignatura[i] = new Asignatura(nombreAsignatura, areaAsignatura);

			}

			Alumno alumno2 = new Alumno(nombre, apellidos, edad, nota, sexo, asignatura);
			//System.out.println(alumno2.toString());
			System.out.println("Asignaturas del alumno: " + alumno2.getNombre());

			for (int i = 0; i < alumno2.getAsignatura().length; i++) {
				if (alumno2.getAsignatura()[i] != null) {
					System.out.println(alumno2.getAsignatura()[i].toString());
				}
			}

			//alumnos[j] = new Alumno();
			alumnos[j]=alumno2;
			aula=new Aula(alumnos);
			
			//System.out.println(aula.getAlumno()[j].toString());

		}
		
		
//************************ la parte de las asignaturas no me imprime mas que la referencia del puntero*****************************************************
		
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i] != null) {
				System.out.println(aula.getAlumno()[i].toString() + aula.getAlumno()[i].getAsignatura().toString()); 
			}
			
//************************* Me da error en el metodo, me dice que alumno[i] es null ************************************************************************
			
			System.out.println(aula.getNumHombres());
			System.out.println(aula.getNumMujeres());
			System.out.println(aula.calcularMedia());
			

		}

	}*/

}
