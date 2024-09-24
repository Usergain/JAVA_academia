
import java.util.ArrayList;
import java.util.Scanner;

/*Queremos guardar los nombres y la edades de los alumnos de un curso. Realiza un programa que 
 *introduzca el nombre y la edad de cada alumno. El proceso de lectura de datos terminará cuando se 
 *introduzca como nombre un asterisco (*) Al finalizar se mostrará los siguientes datos:
 *Todos lo alumnos mayores de edad.
 *Los alumnos mayores (los que tienen más edad)*/

public class EjerciOpcArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String datos = null;
		String nombre;
		String edad;
		Scanner teclado = new Scanner(System.in);
		// ArrayList <String>listaEstudiantes = new ArrayList<String>();
		ArrayList<String>[][] listaEstudiantes = new ArrayList[1][1];
		while (datos != "*") {
			System.out.println("Dame los datos de un alumno: ");
			System.out.print("Nombre:");
			nombre = teclado.next();
			listaEstudiantes[0][1].add(nombre);
			System.out.print("Edad: ");
			edad = teclado.next();
			listaEstudiantes[0][2].add(edad);

		}

	}

}
