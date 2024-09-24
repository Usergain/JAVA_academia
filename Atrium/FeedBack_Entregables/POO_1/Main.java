package POO_1;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> asientos_ocupados = new ArrayList<>();
		
		String[][] asientos = generar_asientos(8, 9);
		mostrar_asientos(asientos);
		
		Random ran = new Random();
		
		Pelicula p1 = new Pelicula("Star Wars 1", 120, 18, "Lucas Pérez");
		Pelicula p2 = new Pelicula("Star Wars 2", 60, 20, "Pepito Tellez");
		Pelicula p3 = new Pelicula("Star Wars 3", 70, 18, "Juan Fernández");
		Pelicula p4 = new Pelicula("Star Wars 4", 100, 15, "Angulo Méndez");	
		
		Pelicula[] peliculas = new Pelicula[5];
		peliculas[0] = p1;
		peliculas[1] = p2;
		peliculas[2] = p3;
		peliculas[3] = p4;
		
		int min_pelicula = 0;
		int max_pelicula = peliculas.length-1;		
		int posPelicula = ran.nextInt(max_pelicula) + min_pelicula;		
		Pelicula p = peliculas[posPelicula];
		
		Espectador e1 = new Espectador("Arkaitz", 25, 50);
		Espectador e2 = new Espectador("Juan", 18, 20);
		Espectador e3 = new Espectador("Pepe", 33, 10);
		Espectador e4 = new Espectador("María", 17, 70);
		Espectador e5 = new Espectador("Sahori", 42, 8);
		
		Espectador[] espectadores = new Espectador[5];
		espectadores[0] = e1;
		espectadores[1] = e2;
		espectadores[2] = e3;
		espectadores[3] = e4;
		espectadores[4] = e5;
		
		int min_espectador = 0;
		int max_expectador = espectadores.length-1;		
		int posEspectador = ran.nextInt(max_expectador) + min_espectador;		
		Espectador e = espectadores[posEspectador];
		
		Cine c = new Cine(p, (float) 8.5);

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
