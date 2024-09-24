import java.util.Scanner;

public class EjerciOpcArrays9 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("�Cu�ntos d�as quieres registrar?");
		int totalDias = teclado.nextInt();

		int[] minimas = new int[totalDias];
		int[] maximas = new int[totalDias];

		for (int i = 0; i < totalDias; i++) {
			int dia = i + 1;

			int min = (int) (Math.random() * (20 - 1) + 1);
			int max = (int) (Math.random() * (40 - 20) + 20);

			minimas[i] = min;
			maximas[i] = max;
		}

		listarTemperaturas(minimas, maximas);
		System.out.println("");
		mostrarTemperaturaMin(minimas);

	}

	public static void listarTemperaturas(int[] minimas, int[] maximas) {

		for (int i = 0; i < minimas.length; i++) {

			int dia = i + 1;
			System.out.println("Temperatura minima del d�a: " + dia + " es: " + minimas[i]);
			System.out.println("Temperatura m�xima del d�a: " + dia + " es: " + maximas[i]);

			double tempMedia = (minimas[i] + maximas[i]) / 2;
			System.out.println("Temperatura media del d�a: " + dia + " es: " + tempMedia);

			System.out.println("");
		}

	}

	public static void mostrarTemperaturaMin(int[] minimas) {

		int tempMinina = minimas[0];
		int pos = 0;

		for (int i = 0; i < minimas.length; i++) {
			if (minimas[i] < tempMinina) {
				tempMinina = minimas[i];
				pos = i;
			}
		}

		System.out.print("Temperatura m�nima de: " + tempMinina + " los d�as: ");
		for (int i = 0; i < minimas.length; i++) {
			if (minimas[i] == minimas[pos]) {
				System.out.print((i + 1) + ", ");
			}
		}

	}

}
