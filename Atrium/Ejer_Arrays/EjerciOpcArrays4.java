import java.util.Scanner;

public class EjerciOpcArrays4 {

	/*
	 * Programa que declare un vector de diez elementos enteros y pida números para
	 * rellenarlo hasta que se llene el vector o se introduzca un número negativo.
	 * Entonces se debe imprimir el vector (sólo los elementos introducidos).
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] vector_numeros = new int[10];
		Scanner teclado = new Scanner(System.in);
		int numero;

		for (int i = 0; i < vector_numeros.length; i++) {
			System.out.print(" Dame un numero: ");
			numero = teclado.nextInt();
			if (numero >= 0) {
				vector_numeros[i] = numero;
			} else {
				break;
			}

		}

		/*
		 * System.out.println(" Los numeros introducidos son : " + vector_numeros[0]+
		 * "-"+vector_numeros[1]+"-"+vector_numeros[2]
		 * +"-"+vector_numeros[3]+"-"+vector_numeros[4]+"-"+vector_numeros[5]+"-"+
		 * vector_numeros[6]+"-"+vector_numeros[7]
		 * +"-"+vector_numeros[8]+"-"+vector_numeros[9]);
		 */

		for (int i = 0; i < vector_numeros.length; i++) {
			if (vector_numeros[i] > 0) {
				System.out.println(vector_numeros[i]);
			}

		}

	}

}
