import java.util.Scanner;

/*Amplíe el programa anterior, haciendo que el programa entregue premios y lleve la cuenta del resultado.

Inicialmente, el jugador empieza con una moneda. *
En cada tirada, al jugador se le cobra una moneda. *
En cada tirada, el programa muestra tres números al azar del 1 al 6. *
Si los tres números son distintos, el jugador no gana nada (es decir, pierde la moneda que apostó). *
Si salen dos números iguales, el jugador gana dos monedas (es decir, gana en total una moneda).*
Si salen tres números iguales, el jugador gana cinco monedas (es decir, gana en total cuatro monedas).
El número de monedas puede hacerse negativo.
Tras cada tirada, el jugador indica si quiere seguir jugando o no.*/

public class EjerciOpcWHILE12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String jugar = null;
		int cartera=1;

		System.out.println("Pulse Intro para volver a jugar, otra tecla e Intro para terminar: ");
		jugar = teclado.nextLine();

		while (jugar.equals("")) {
			
			cartera--;

			int valor = (int) Math.floor(Math.random() * 6 + 1);
			int valor2 = (int) Math.floor(Math.random() * 6 + 1);
			int valor3 = (int) Math.floor(Math.random() * 6 + 1);

			System.out.println(" Tirada: " + valor + " " + valor2 + " " + valor3 + " ");

			if (valor != valor2 && valor != valor3 && valor2 != valor3) {
				System.out.println(" No hay números iguales " + " tienes en tu cartera " + cartera);
			} else if (valor == valor2 && valor2 == valor3 && valor==valor3) {
				cartera=cartera+5;
				System.out.println(" Hay tres números iguales " + " tienes en tu cartera " + cartera);
				
			}
			else if (valor == valor2 || valor == valor3 || valor2 == valor3) {
				cartera=cartera+2;
				System.out.println(" Hay dos números iguales " + " tienes en tu cartera " + cartera);
			}

			System.out.println("Pulse Intro para volver a jugar, otra tecla e Intro para terminar: ");
			jugar = teclado.nextLine();
		}
	}
}
