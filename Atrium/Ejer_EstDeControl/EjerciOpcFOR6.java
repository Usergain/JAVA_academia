import java.util.Scanner;

public class EjerciOpcFOR6 {
	
	//Escriba un programa que pregunte cu�ntos n�meros se van a introducir, pida esos n�meros, y diga al final cu�ntos han sido pares y cu�ntos impares.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		int num;
		int numeros;
		int pares = 0;
		int impares=0;

		System.out.println("CONTADOR DE PARES E IMPARES");
		System.out.println(" ");
		System.out.print("�Cuantos valores va a introducir? ");
		numeros = teclado.nextInt();
		if (numeros > 0) {
			for (int i = 0; i < numeros; i++) {
				System.out.print("Escriba el numero " + i + " : ");
				num = teclado.nextInt();
				if (num %2== 0) {
					pares++;
				}
				else {
					impares++;
				}

			}
			System.out.println("Ha escrito " + impares + " n�mero impares ");
			System.out.println("Ha escrito " + pares + " n�mero pares ");

		}

		else if (numeros == 0) {
			System.out.println("No ha escrito ning�n n�mero negativo");
		} else {
			System.out.println("�Imposible!");
		}

	}

}
