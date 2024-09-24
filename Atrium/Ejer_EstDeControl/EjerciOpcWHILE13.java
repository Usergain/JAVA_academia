import java.util.Scanner;

public class EjerciOpcWHILE13 {
	
	/*Amplíe el programa anterior, de manera que se parezca más al funcionamiento real de una máquina tragaperras.

	Inicialmente, el jugador indica con cuántas monedas empieza a jugar.
	En cada tirada, al jugador se le cobra una moneda.
	En cada tirada, el programa muestra tres números al azar del 1 al 6.
	Si los tres números son distintos, el jugador no gana nada (es decir, pierde la moneda que apostó).
	Si salen dos números iguales, el jugador gana dos monedas (es decir, gana en total una moneda).
	Si salen tres números iguales, el jugador gana cinco monedas (es decir, gana en total cuatro monedas).
	Si el jugador se queda sin monedas, la partida termina.
	Tras cada tirada, el jugador indica si quiere seguir jugando o no.
	Al terminar la partida, el programa indica cuántas monedas se han ganado o perdido.*/
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String jugar = null;
		int cartera = 0;
		int aux=0;
		int ganancias = 0;
		int premio;

		System.out.println("TRAGAPERRAS");
		System.out.println();
		System.out.println("¿Con cuantas monedas quiere empezar?");
		cartera = teclado.nextInt();
		
		teclado.nextLine();
		System.out.println(" ");
		System.out.println("Empieza la partida con " + cartera + " moneda(s). ");
		System.out.println("Pulse Intro para volver a jugar, otra tecla e Intro para terminar: ");
		jugar = teclado.nextLine();
		
		aux=cartera;
		
		while (jugar.equals("") && cartera >= 0) {

			cartera--;

			int valor = (int) Math.floor(Math.random() * 6 + 1);
			int valor2 = (int) Math.floor(Math.random() * 6 + 1);
			int valor3 = (int) Math.floor(Math.random() * 6 + 1);

			System.out.println(" Tirada: " + valor + " " + valor2 + " " + valor3 + " ");

			if (valor != valor2 && valor != valor3 && valor2 != valor3) {
				premio = 0;
				cartera=cartera+premio;
				System.out.println(" No hay números iguales " + " tienes en tu cartera " + cartera);
			} else if (valor == valor2 && valor2 == valor3 && valor == valor3) {
				premio = 5;
				cartera = cartera + premio;
				System.out.println(" Hay tres números iguales " + " tienes en tu cartera " + cartera);

			} else if (valor == valor2 || valor == valor3 || valor2 == valor3) {
				premio=2;
				cartera = cartera + premio;
				System.out.println(" Hay dos números iguales " + " tienes en tu cartera " + cartera);
			}

			System.out.println("Pulse Intro para volver a jugar, otra tecla e Intro para terminar: ");
			jugar = teclado.nextLine();
			
			if (cartera>aux) {
				System.out.println(" Ha ganado " + ganancias + " monedas. Ahora tiene " + cartera + " monedas " );
				
			} else {
				System.out.println(" Ha acabado la partida con " + cartera + " monedas ");
				
			}

		}

	}

}
