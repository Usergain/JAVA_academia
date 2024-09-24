package POO_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainListas {

	public static void main(String[] args) {
		ArrayList<String> asientos_ocupados = new ArrayList<>();

		Random ran = new Random();
		
		System.out.println("¿Cuántas filas tiene el cine?");
		Scanner teclado = new Scanner(System.in);
		
		int filas = teclado.nextInt();

		System.out.println("¿Cuántas columnas tiene el cine?");
		int columnas = teclado.nextInt();		
		
		System.out.println("******** Distribución del Cine ********");
		String[][] asientos = generar_asientos(filas, columnas);
		mostrar_asientos(asientos);	
		System.out.println("");
		
		System.out.println("¿Cuántas películas se proyectarán el cine?");
		int totalpeliculas = teclado.nextInt();
		
		System.out.println("¿Cuántos espectadores asistirán al cine?");
		int totalEspectadores = teclado.nextInt();
		
		Pelicula[] peliculas = new Pelicula[totalpeliculas];
		Espectador[] espectadores = new Espectador[totalEspectadores];
		
		
		System.out.println("******** Llenar lista de películas ********");
		
		for (int i = 0; i < totalpeliculas; i++) {
			int numpeli = i + 1;
			System.out.println("Entre el nombre de la película: " + numpeli);
			String nombrePeli = teclado.next();
			System.out.println("Entre la duración de la película: " + numpeli);
			int duracionPeli = teclado.nextInt();
			System.out.println("Entre la edad mínima de la película: " + numpeli);
			int edadPeli = teclado.nextInt();
			System.out.println("Entre el director de la película: " + numpeli);
			String directorPeli = teclado.next();
			
			Pelicula p = new Pelicula(nombrePeli,duracionPeli,edadPeli,directorPeli);
			
			peliculas[i] = p;
			System.out.println("");
		}
		
		System.out.println("******** Llenar lista de espectadores ********");
		for (int i = 0; i < totalEspectadores; i++) {
			int numEpectador = i + 1;
			System.out.println("Entre el nombre espectador: " + numEpectador);
			String nombreEspectador = teclado.next();
			System.out.println("Entre la edad del espectador: " + numEpectador);
			int edadEspectador = teclado.nextInt();
			System.out.println("Entre el dinero del espectador: " + numEpectador);
			int dineroEspectador = teclado.nextInt();
			
			Espectador e = new Espectador(nombreEspectador, edadEspectador, dineroEspectador);
			espectadores[i] = e;
			System.out.println("");
		}
		
		int min_pelicula = 0;
		int max_pelicula = peliculas.length-1;		
		int posPelicula = ran.nextInt(max_pelicula) + min_pelicula;		
		Pelicula p = peliculas[posPelicula];
		
		int min_espectador = 0;
		int max_expectador = espectadores.length-1;		
		int posEspectador = ran.nextInt(max_expectador) + min_espectador;		
		Espectador e = espectadores[posEspectador];
		
		System.out.println("Entre el precio de la película: ");
		float preciopeli = teclado.nextFloat();
		
		Cine c = new Cine(p, (float) preciopeli);
		
		if (e.getDinero() >= c.getPrecio()) {
			if (e.getEdad() > p.getEdadMinima()) {

				int min_filas = 1;
				int max_filas = 8;
				int numFila = ran.nextInt(max_filas) + min_filas;
				
				int min_columnas = 1;
				int max_columnas = 9;
				int numColumna = ran.nextInt(max_columnas) + min_columnas;
				char letraAsiento = (char)('A'+numColumna);

				String asiento = Integer.toString(numFila)+letraAsiento;
				
				boolean asientoOcupado = false;
				
				for (int i = 0; i < asientos_ocupados.size(); i++) {
					if(asientos_ocupados.get(i).equalsIgnoreCase(asiento)) {
						asientoOcupado = true;
					}
				}
				
				if(asientoOcupado == false) {
						asientos_ocupados.add(asiento);	
						System.out.println(e.getNombre() + " puede ver la película: " +p.getTitulo() + " y se sentará en el asiento: " + asiento);
				}
				

			} else {
				System.out.println("El espectador " + e.getNombre() +" no tiene la edad requerida ("+e.getEdad()+") para ver la película ("+p.getEdadMinima()+")");
			}

		} else {
			System.out.println("El espectador no tiene suficiente dinero. Es pobre !!!");
		}

	}
	
	public static String[][] generar_asientos(int filas, int columnas) {
		String[][] asientos = new String[filas][columnas];
		for (int i = 1; i <= filas; i++) {
			for (int j = 0; j < columnas; j++) {
				char letra = (char) ('A' + j);
				asientos[i - 1][j] = Integer.toString(i) + letra;
			}
		}

		return asientos;
	}

	public static void mostrar_asientos(String[][] asientos) {
		for (int i = asientos.length - 1; i >= 0; i--) {
			for (int j = 0; j < asientos[i].length; j++) {
				System.out.print(asientos[i][j] + " ");
			}
			System.out.println();
		}
	}

}
