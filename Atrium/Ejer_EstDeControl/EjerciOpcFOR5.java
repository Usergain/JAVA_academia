import java.util.Scanner;

public class EjerciOpcFOR5 {

	// Escriba un programa que pregunte cu�ntos n�meros se van a introducir, pida
	// esos n�meros y escriba cu�ntos negativos ha introducido

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int num;
		int numeros;
		int cont = 0;

		System.out.println("NUMEROS NEGATIVOS");
		System.out.println(" ");
		System.out.print("�Cuantos valores va a introducir? ");
		numeros = teclado.nextInt();
		if (numeros > 0) {
			for (int i = 0; i < numeros; i++) {
				System.out.print("Escriba el numero " + i + " : ");
				num = teclado.nextInt();
				if (num < 0) {
					cont++;
				}

			}
			System.out.println("Ha escrito " + cont + " n�mero negativo ");

		}

		else if (numeros == 0) {
			System.out.println("No ha escrito ning�n n�mero negativo");
		} else {
			System.out.println("�Imposible!");
		}

	}

}
