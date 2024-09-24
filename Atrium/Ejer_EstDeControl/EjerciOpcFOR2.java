import java.util.Iterator;
import java.util.Scanner;

//Escriba un programa que pida un número entero mayor que cero y que escriba sus divisores.

public class EjerciOpcFOR2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int numero = 0;
		// int divisores;
		// int dividendos;
		System.out.println("DIVISORES");
		System.out.println(" ");
		System.out.print("Escriba un número entero mayor que cero: ");
		numero = teclado.nextInt();
		System.out.print("Los divisores de " + numero + " son : ");
		for (int i = 1; i < numero; i++) {

			if (numero % i == 0) {
				System.out.print(" " + i + " ");
			}

		}

		if (numero > 0) {

		} else {
			System.out.println("¡ Le he pedido un número entero mayor que cero! ");
		}
	}

}
