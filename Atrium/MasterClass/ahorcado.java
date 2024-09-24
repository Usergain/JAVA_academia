import java.util.Random;
import java.util.Scanner;

public class ahorcado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				/*
				 * JUEGO:AHORCADO Simula el juego ahorcado, con algunas palabras guardadas en
				 * matriz que juegan aleatoriamente.
				 */

				// Matriz de palabras que participan en el juego
				char[][] matriz = { { 'j', 'i', 'r', 'a', 'f', 'a' }, { 'c', 'a', 's', 'a' }, { 'p', 'e', 'r', 'r', 'o' },
						{ 'c', 'a', 's', 't', 'i', 'l', 'l', 'o' }, { 'l', 'o', 'r', 'o' } };

				// Controla si el usuario puede seguir jugando al juego o no.
				boolean jugar = true;

				// Controla el número de fallos que va cometiendo el usuario
				int fallos = 0;

				// Scanner para leer los caracteres del usuario.
				Scanner sc = new Scanner(System.in);
				char letra = ' ';

				// Guarda si/no desea echar otra partida
				String respuesta = " ";

				// Inicializamos las variables del juego.
				int control = 0; // Verifica caracteres
				int aciertos = 0;
				int contador = 0; // Contabiliza si queda algún guión
				boolean on = true;

				// Entramos al juego.----------------------------------------------------------------------------------------
				System.out.println("****************** Bienvenido al juego del Ahorcado ******************");
				System.out.println("***********************************************************************");

				while (on) {
					System.out.println("");
					System.out.println("¿Empezamos una partida?");
					respuesta = sc.nextLine();
					if (respuesta.equals("no") || respuesta.equals("NO") || respuesta.equals("No")) {
						on = false;
						System.out.println("Fin");
					} else {
						on = true;
						fallos = 0;
						aciertos = 0;
						control = 0;
						contador = 0;
						// Aleatorio para decidir que palabra de nuestra matriz juega
						// Usamos .nextInt(porque sabemos el tamaño de la matriz y podemos darle el
						// máximo=4)
						Random aleatorio = new Random(System.currentTimeMillis()); // Llamo a la clase
						int numero_aleatorio = aleatorio.nextInt(4); // Genero random en la variable "numero_aleatorio"

						// Array que guarda tantos "_" como letras tenga la palabra con la que jugamos
						char[] palabra_jugar = new char[matriz[numero_aleatorio].length];

						// Cargamos el array del usuario con los _
						for (int i = 0; i < palabra_jugar.length; i++) {
							palabra_jugar[i] = '*';
						}

						do {

							System.out.println("La palabra que tienes que adivinar es la siguiente: ");
							// Imprime palabra_jugar con tantos "_" o "letras" acertadas lleve el jugador
							for (int i = 0; i < palabra_jugar.length; i++) {
								System.out.print(palabra_jugar[i] + " ");
							}
							System.out.println();
							System.out.println();

							// Informamos de los fallos acumulados
							System.out.println("La cantidad de fallos que tienes es de " + fallos);

							// Pedimos al usuario que introduzca un caracter por teclado.
							System.out.println("Usuario dame un caracter: ");
							// Con .charAt(0), nos quedamos solo con el primer caracter de la palabra
							// introducida
							letra = sc.nextLine().charAt(0);

							// Comprobamos si el caracter introducido es correcto
							control = 0;
							for (int i = 0; i < palabra_jugar.length; i++) {
								// Comprobar casilla por casilla si hay coincidencias.
								// Si HAY COINCIDENCIA guardo la letra en ese espacio de palabra_jugar
								if (matriz[numero_aleatorio][i] == letra) {
									palabra_jugar[i] = letra;
									aciertos++;
									control++;
								}
							}

							// Si NO hay coincidencias control NO suma pero si suma fallos(MÁXIMO10)
							if (control == 0) {
								fallos++;
							}
							// Cuenta los guiones (_) que quedan por resolver
							contador = 0;
							for (int i = 0; i < palabra_jugar.length; i++) {
								if (palabra_jugar[i] == '_') {
									contador++;
								}
							}
							// Si no quedan guiones la palabra ha sido completada
							if (contador == 0) {
								jugar = false;
							}

						} while (fallos < 10 && jugar);

						if (!jugar) {

							// En este caso, el usuario ha acertado la palabra;
							System.out.println("Acertaste la palabra!!!! Ganaste!!!!");
							// Imprimo la palabra ganadora
							for (int i = 0; i < palabra_jugar.length; i++) {
								System.out.print(matriz[numero_aleatorio][i] + " ");
							}

						}

						else {
							// En este caso, el usuario ha agotado todos los intentos sin acertar
							System.out.println("No has acertado la palabra, la palabra con la que se jugaba era: ");
							// Imprimo la palabra ganadora
							for (int i = 0; i < palabra_jugar.length; i++) {
								System.out.print(matriz[numero_aleatorio][i] + " ");
							}
							System.out.println("");
							System.out.println("¡¡Inténtalo de nuevo!!");
						}

					}
				} // Fin While

	}

}
