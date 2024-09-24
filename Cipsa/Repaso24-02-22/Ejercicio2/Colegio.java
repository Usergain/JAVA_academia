package Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Colegio {

	private HashMap<String, Alumno> diccionario;

	public Colegio() {

	}

	public Colegio(HashMap<String, Alumno> diccionario) {
		this.diccionario = diccionario;
	}

	public HashMap<String, Alumno> getDiccionario() {
		return diccionario;
	}

	public void setDiccionario(HashMap<String, Alumno> diccionario) {
		this.diccionario = diccionario;
	}

	public Alumno mostrarAlumnoDadoDni(String dni) {
		Alumno alumno = null;
		if (diccionario.containsKey(dni)) {
			Alumno a = diccionario.get(dni);

			double media = 0;
			double suma = 0;
			ArrayList<Float> notas = a.getCalificaciones();

			for (int i = 0; i < notas.size(); i++) {
				suma += notas.get(i);
			}
			media = suma / notas.size();
			
			alumno=new Alumno(a.getNombre(),a.getDni(),a.getPoblacion() + ", notas: " + notas + ", media: " + media);
		} 
		
		return alumno ;

	}

	public ArrayList<Alumno> mostrarAlumnosDadoPoblacion(String poblacion) {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		for (String clave : diccionario.keySet()) {
			Alumno a = diccionario.get(clave);
			if (a.getPoblacion().equalsIgnoreCase(poblacion)) {
				alumnos.add(a);
			}
		}
		
		return alumnos;
		
	}
	
	public Map<String, List<Alumno>> mostrarAlumnosAgrupadosPoblacion(List<Alumno>alumnos) {


		Map<String, List<Alumno>> agrupamiento = alumnos.stream().collect(Collectors.groupingBy(p -> p.getPoblacion()));
		
		/*agrupamiento.keySet().stream().forEach(pob -> {
			System.out.println("Poblacion: " + pob);
			agrupamiento.get(pob).stream().forEach(p -> System.out.println(p));
		});*/
		
		return agrupamiento;
	}
	
	

	
	public ArrayList<Alumno> mostrarAlumnosAprobados() {

		ArrayList<Alumno> aprobados = new ArrayList<Alumno>();

		for (String clave : diccionario.keySet()) {
			Alumno a = diccionario.get(clave);

			ArrayList<Float> notas = a.getCalificaciones();
			int cont = 0;

			for (int i = 0; i < notas.size(); i++) {
				if (notas.get(i) >= 5f) {
					cont++;
				}
			}

			if (notas.size() == cont) {
				aprobados.add(a);
			}

		}
		
		return aprobados;

	}
	
	public ArrayList<Alumno> recuentoAlumnosAprobados() {
		
		ArrayList<Alumno> aprobados = new ArrayList<Alumno>();
		ArrayList<Float> notas = new ArrayList<Float>();
		Alumno alumno = null;
		int totalAprobados = 0;
		int cont = 0;
		float media = 0;
		float suma = 0;
		
		for (String clave : diccionario.keySet()) {
			Alumno a = diccionario.get(clave);

			notas = a.getCalificaciones();
	
			for (int i = 0; i < notas.size(); i++) {
				suma += notas.get(i);
			}
			
			media = suma / notas.size();
			
			if (media >= 5) {
				totalAprobados++;
				alumno=new Alumno(a.getNombre(),a.getDni(),a.getPoblacion() + ", notas: " + notas + ", media: " + media + ",total de aprobados: " + totalAprobados);
				aprobados.add(alumno);
			}
			
		}
		
		return aprobados;
		
	}
	
	


}