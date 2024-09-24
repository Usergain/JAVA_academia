package Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		//Meterle un stream para que me saque por pantalla lo que me piden
		
		HashMap<String, Alumno> diccionario = new HashMap<String, Alumno>();
		
		Alumno alumno=new Alumno("Arkaitz", "78920987-Y", "Bilbao");
		Alumno alumno2=new Alumno("Arkaitz", "73563587-Y", "Bilbao");
		Alumno alumno3=new Alumno("Txomin", "00000859-Q", "Munguia");
		Alumno alumno4=new Alumno("Kepa", "11111859-Q", "Munguia");
		Alumno alumno5=new Alumno("Helena", "339240987-O", "Bilbao");
		Alumno alumno6=new Alumno("Martin", "90000000-F", "Somorrostro");
		
		ArrayList<Float> calificaciones=new ArrayList<Float>();
		System.out.println(alumno.getNombre()+ " " +alumno.getDni()+ " " +alumno.getPoblacion());
		
		Colegio colegio=new Colegio();
		
		System.out.println("");
		System.out.println(colegio.mostrarAlumnoDadoDni("78920987-Y"));
		System.out.println("");
		
		calificaciones.add(7.0f);
		calificaciones.add(10.0f);
		alumno.setCalificaciones(calificaciones);
		System.out.println(alumno.toString());
		
		calificaciones=new ArrayList<Float>();
		calificaciones.add(2f);
		calificaciones.add(5f);
		alumno2.setCalificaciones(calificaciones);
		
		System.out.println(alumno2.toString());
		
		System.out.println("");
		System.out.println("COMPARAR");
		
		System.out.println(alumno.equals(alumno2));
		
		System.out.println("");
		
		List<Alumno>alumnos=Arrays.asList(new Alumno[] {
				new Alumno("Arkaitz", "78920987-Y", "Bilbao"),
				new Alumno("Juanito", "78920987-Y", "Bilbao"),
				new Alumno("Txomin", "00000859-Q", "Munguia"),
				new Alumno("Kepa", "11111859-Q", "Munguia"),
				new Alumno("Helena", "339240987-O", "Bilbao"),
				new Alumno("Martin", "90000000-F", "Somorrostro")
		});
		
		
		for (int i = 0; i < alumnos.size(); i++) {
			diccionario.put(alumnos.get(i).getDni(), alumnos.get(i));
		}
		
		
		
		System.out.println("");
		System.out.println("****************************");
		System.out.println("LISTADO DE ALUMNOS HASHMAP: ");
		System.out.println("****************************");
		System.out.println("");
		
		for (String clave:diccionario.keySet()) {
		    Alumno a = diccionario.get(clave);
		    System.out.println(a.toString());
		    
		    ArrayList<Float> notas = a.getCalificaciones();
		    
		    for (int i = 0; i < notas.size(); i++) {
				System.out.println("Nota " + (i+1) +": " + notas.get(i));
			}
		    System.out.println("");
		    
		}
		
		System.out.println("");
		System.out.println("***************************");
		System.out.println("LISTADO DE ALUMNOS STREAM: ");
		System.out.println("***************************");
		System.out.println("");
		
		Map<Object, List<Alumno>>agrupamiento=alumnos.stream().collect(Collectors.groupingBy(p->p.getPoblacion()));
		
		agrupamiento.keySet().stream().forEach(pob->{
			System.out.println("Poblacion: " + pob);
			agrupamiento.get(pob).stream().forEach(p->System.out.println(p));
		});
		
		/*public static void mostrarResultados(ArrayList<Double> a, double media) {                                
		      int superior = 0, inferior = 0;
		      System.out.println("alturas introducidas: ");
		      System.out.println(a);
		      for (Double d : a) {
		            if (d > media)
		                superior++;
		            else if (d < media)
		                       inferior++;
		      }
		      System.out.printf("Media: %.2f %n", media);
		      System.out.println("Hay " + superior + " alumnos más altos que la media");
		      System.out.println("Hay " + inferior + " alumnos más bajos que la media");
		   }*/
		
		
		ArrayList<Float> calificaciones2=new ArrayList<Float>();
		
		//List<String> sumatorio=alumnos.stream().filter(p->p.getCalificaciones(if(nota>=5))).map(p->p.toString()).collect(Collectors.toList());
		
		System.out.println("");
		System.out.println("*****************");
		System.out.println("EJEMPLO HASHCODE");
		System.out.println("*****************");
		System.out.println("");
		HashSet<String> conjunto = new HashSet<String>();
		
		String valor;
		Scanner scr = new Scanner( System.in);
		for( int i = 0; i < 5; i++ ) {
			valor = scr.nextLine();
			if ( !conjunto.contains(valor)) {
				System.out.println("AÑADIDO");
				conjunto.add(valor);
			} else System.out.println("Ya esta.");
		}
		
		conjunto.add("A");
		conjunto.add("B");
		conjunto.add("C");
		conjunto.add("B");
		conjunto.add("C");
		conjunto.add("B");		
		System.out.println(conjunto.size());
		for( String valor1 : conjunto )
			System.out.println(valor1);
		

	}

}
