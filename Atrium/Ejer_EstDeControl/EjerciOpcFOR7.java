
import java.util.Scanner;

public class EjerciOpcFOR7 {
	// Escriba un programa que pida un número entero mayor que 1 y que escriba si el
	// número es un número primo o no. Número primo es todo numero que es divisible
	// solo entre el mismo y la unidad

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		Scanner teclado = new Scanner(System.in);
		int primo;
		int cont = 0;

		System.out.println("NÚMERO PRIMO");
		System.out.println(" ");
		System.out.print("Escriba un número mayor que 1: ");
		numero = teclado.nextInt();
		if (numero > 1) {
			for (int i = numero; i > 1; i--) {
				if (numero % i == 0) {
					cont++;
				}

			}

			if (cont > 1) {
				System.out.println(numero + " no es primo ");
			} else {
				System.out.println("NÚMERO PRIMO");
			}
		} else {
			System.out.println("¡Le he pedido un número entero mayor que 1!");
		}

	}

}
