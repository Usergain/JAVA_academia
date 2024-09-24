import java.util.Scanner;

public class EjerciOpcWHILE10 {

	/*
	 * En este apartado se pretende escribir un programa que simule un juego similar
	 * al juego de cartas «Las siete y media«. En vez de pedir cartas, los jugadores
	 * tirarán unos dados cuantas veces quieran y el valor límite es el 20 (gana el
	 * que obtiene la puntuación más alta sin superar el límite)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String jugar1 = null;
		String jugar2 = null;
		int jugador1 = 0;
		int jugador2 = 0;
		int tirada = 0;

		System.out.println("Pulse intro para lanzar el dado. Pulse otra tecla e Intro para terminar: ");
		System.out.print(" Jugador 1: ");
		jugar1 = teclado.nextLine();
		System.out.print(" Jugador 2: ");
		jugar2 = teclado.nextLine();

		while (jugar1.equals("") && jugar2.equals("") && jugador1<=20 && jugador2<=20){

			tirada++;
			int valor1 = (int) Math.floor(Math.random() * 6 + 1);
			int valor2 = (int) Math.floor(Math.random() * 6 + 1);
			// System.out.println(valor);
			jugador1 += valor1;
			jugador2 += valor2;
			System.out.println(" Jugador 1 - tirada: " + tirada + " - Suma: " + jugador1);
			System.out.println(" Jugador 2 - tirada: " + tirada + " - Suma: " + jugador2);
			System.out.println(" Pulse intro para lanzar el dado. Pulse otra tecla e Intro para terminar: ");
			System.out.print(" Jugador 1: ");
			jugar1 = teclado.nextLine();
			System.out.print(" Jugador 2: ");
			jugar2 = teclado.nextLine();
			if (jugador1 > jugador2) {
				System.out.println(" Ha ganado el jugador 1 ");
			} else {
				System.out.println(" Ha ganado el jugador 2 ");

			}
		}

		/*if (jugador1 > jugador2) {
			System.out.println(" Ha ganado el jugador 1 ");
		} else {
			System.out.println(" Ha ganado el jugador 2 ");

		}*/

	}
}
