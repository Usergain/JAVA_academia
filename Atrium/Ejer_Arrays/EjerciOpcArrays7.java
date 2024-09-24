import java.util.Arrays;
import java.util.Scanner;

/*Programa que declare tres vectores ‘vector1’, ‘vector2’ y ‘vector3’ de cinco enteros cada uno, 
pida valores para ‘vector1’ y ‘vector2’ y calcule vector3=vector1+vector2.*/

public class EjerciOpcArrays7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tam = 5;
		int[] vector1 = new int[tam];
		int[] vector2 = new int[tam];
		int[] vector3 = new int[tam];
		Scanner teclado = new Scanner(System.in);

		for (int i = 0; i < vector1.length; i++) {
			System.out.print(" Dame un numero de la posicion " + i + " del vector1 :");
			vector1[i] = teclado.nextInt();
		}

		for (int i = 0; i < vector2.length; i++) {
			System.out.print(" Dame un numero de la posicion " + i + " del vector2 :");
			vector2[i] = teclado.nextInt();
		}

		vector3 = sum(vector1, vector2, tam);

		System.out.print(" La suma de : vector1+vector2 es : " + Arrays.toString(vector3));
	}

	public static int[] sum(int[] a1, int[] a2, int n) {

		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			result[i] = a1[i] + a2[i];
		}

		return result;
	}

}
