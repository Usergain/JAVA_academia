import java.util.Scanner;

public class EjerciOpcFOR8 {

	// Escriba un programa que pregunte cuantos números se van a introducir, pida
	// esos números (que puedan ser decimales) y calcule su suma.
	public static void main(String[] args) {

		int valores = 0;
		float numero = 0;
		float suma = 0;
		Scanner teclado = new Scanner(System.in);

		do {

			System.out.println(" SUMA DE VALORES ");
			System.out.println(" ");
			System.out.print(" ¿Cuantos valores va a introducir? ");
			valores = teclado.nextInt();
		} while (valores < 0);

		for (int i = 0; i < valores; i++) {
			System.out.println(" Escriba el número");
			numero = teclado.nextFloat();
			suma+=numero;
		}

		System.out.println(" La suma de los números que ha escrito es " + suma);

	}

}
