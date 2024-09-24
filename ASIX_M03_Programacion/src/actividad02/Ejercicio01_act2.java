package actividad02;

import java.util.Scanner;

public class Ejercicio01_act2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		int opcion;
		boolean salir = false;
		Scanner sc = new Scanner(System.in);
		int[] memoria = new int[7];
		for (int i = 0; i < 7;) {
			System.out.println(i);
			System.out.println("Dame un número entre el 10 y el 50");
			numero = sc.nextInt();
			if (numero >= 10 && numero <= 50) {
				memoria[i] = numero;
				i++;
			} else {
				System.out.println("Has introducido un número no permitido, vuelve a intentarlos");
			}
		}

		while (!salir) {
			System.out.println("");
			System.out.println(" *************************** Menú Principal ************************** ");

			System.out.println(" 0- Salir ");
			System.out.println(" 1- Indicar cuantos valores entre 22 y 32 hay en el array.  ");
			System.out.println(" 2- Calcular la media aritmética de los 7 números ");
			System.out.println(" 3- Mostrar el número más alto  del array");
			System.out.println(" 4- Mostrar el contenido del array de la última a la primera posición");

			System.out.println(" ********************************************************************* ");

			sc = new Scanner(System.in);
			opcion = sc.nextInt();

			switch (opcion) {

			case 1: {
				imprimirBusqueda(memoria);
			}
				;
				break;
			case 2: {
				System.out.println(MediaValor(memoria));
			}
				;
				break;
			case 3: {
				System.out.println(MaximoValor(memoria));
			}
				;
				break;
			case 4: {
				imprimirArray(memoria);
			}
				;
				break;

			case 0: {
				System.out.println("Fin del programa");
				System.exit(0);
				break;
			}
			default:
				System.out.println("Seleccione una opcion valida" + "\n");
				break;
			}

		}
	}
	
	// Funciones:

	static int MaximoValor(int[] matriz) {
		int maximo = 0;
		for (int i : matriz) {
			if (i > maximo) {
				maximo = i;
			}
		}
		return maximo;
	}

	static void imprimirBusqueda(int matriz[]) {
		System.out.print("[");
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i] >= 22 && matriz[i] <= 32) {
				System.out.print(matriz[i] + " ");
			}

		}
		System.out.println("]");
	}

	static float MediaValor(int[] matriz) {
		int media = 0;
		for (int i = 0; i < matriz.length; i++) {
			media += matriz[i];

		}
		media = media / matriz.length;
		return media;
	}

	static void imprimirArray(int matriz[]) {
		System.out.print("[");
		for (int i = 0; i < matriz.length; i++) {
			System.out.print(matriz[i] + " ");
		}
		System.out.println("]");
	}

}
