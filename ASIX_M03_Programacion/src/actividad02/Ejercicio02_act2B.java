package actividad02;

import java.util.Scanner;

public class Ejercicio02_act2B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[][] memoria = { { 5.5, 6.4, 7.2, 0.7 }, { 3.4, 5.6, 4.2, 8.9 }, { 4.4, 9.6, 7.2, 9.9 } };
		int opcion;
		double ac;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println(" ********** MENÚ PRINCIPAL ********** ");

			System.out.println("0.-SALIR");
			System.out.println("1.-TODAS LAS NOTAS POR EXPERTO");
			System.out.println("2.-LAS MEDIAS POR EXPERTO ");
			System.out.println("3.-LA PEOR NOTA POR EXPERTO");

			System.out.println(" ************************************ ");

			sc = new Scanner(System.in);
			opcion = sc.nextInt();

			switch (opcion) {
			case 1: {
				imprimirArray(memoria);
			}
				break;
			case 2: {
			}
				imprimirVector(MediaValores(memoria));
				break;
			case 3: {

			}

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

		} while (opcion != 0);

	}

	// Funciones :

	static void imprimirVector(double matriz[]) {
		System.out.print("[");
		for (int i = 0; i < matriz.length; i++) {
			System.out.print(matriz[i] + " ");
		}
		System.out.println("]");
	}

	static void imprimirArray(double[][] memoria) {

		for (int i = 0; i < 3; i++)// filas
		{
			System.out.print("[ ");
			for (int j = 0; j < 4; j++) // columnas
			{

				System.out.print(memoria[i][j] + " ");
			}
			System.out.println("]");
		}
	}

	static double[] MediaValores(double[][] memoria) {
		double[] mediaNotas = new double[memoria.length];
		for (int i = 0; i < 3; i++)// filas
		{
			double suma = 0;
			for (int j = 0; j < 4; j++) // columnas
			{
				suma += memoria[i][j];
			}
			double promedio = suma / 4;
			mediaNotas[i] = promedio;
		}

		return mediaNotas;
	}

	static void MenorValor(double[][] memoria) {
		float menor = 0;
		for (int i = 0; i < memoria.length; i++) {
			for (int j = 0; j < memoria.length; j++) {

			}
		}
	}

}
