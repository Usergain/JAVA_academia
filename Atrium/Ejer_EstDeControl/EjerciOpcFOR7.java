
import java.util.Scanner;

public class EjerciOpcFOR7 {
	// Escriba un programa que pida un n�mero entero mayor que 1 y que escriba si el
	// n�mero es un n�mero primo o no. N�mero primo es todo numero que es divisible
	// solo entre el mismo y la unidad

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		Scanner teclado = new Scanner(System.in);
		int primo;
		int cont = 0;

		System.out.println("N�MERO PRIMO");
		System.out.println(" ");
		System.out.print("Escriba un n�mero mayor que 1: ");
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
				System.out.println("N�MERO PRIMO");
			}
		} else {
			System.out.println("�Le he pedido un n�mero entero mayor que 1!");
		}

	}

}
