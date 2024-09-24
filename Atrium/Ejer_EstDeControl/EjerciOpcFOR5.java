import java.util.Scanner;

public class EjerciOpcFOR5 {

	// Escriba un programa que pregunte cuántos números se van a introducir, pida
	// esos números y escriba cuántos negativos ha introducido

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int num;
		int numeros;
		int cont = 0;

		System.out.println("NUMEROS NEGATIVOS");
		System.out.println(" ");
		System.out.print("¿Cuantos valores va a introducir? ");
		numeros = teclado.nextInt();
		if (numeros > 0) {
			for (int i = 0; i < numeros; i++) {
				System.out.print("Escriba el numero " + i + " : ");
				num = teclado.nextInt();
				if (num < 0) {
					cont++;
				}

			}
			System.out.println("Ha escrito " + cont + " número negativo ");

		}

		else if (numeros == 0) {
			System.out.println("No ha escrito ningún número negativo");
		} else {
			System.out.println("¡Imposible!");
		}

	}

}
