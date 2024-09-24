import java.util.Scanner;

public class EjerciOpcFOR6 {
	
	//Escriba un programa que pregunte cuántos números se van a introducir, pida esos números, y diga al final cuántos han sido pares y cuántos impares.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		int num;
		int numeros;
		int pares = 0;
		int impares=0;

		System.out.println("CONTADOR DE PARES E IMPARES");
		System.out.println(" ");
		System.out.print("¿Cuantos valores va a introducir? ");
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
			System.out.println("Ha escrito " + impares + " número impares ");
			System.out.println("Ha escrito " + pares + " número pares ");

		}

		else if (numeros == 0) {
			System.out.println("No ha escrito ningún número negativo");
		} else {
			System.out.println("¡Imposible!");
		}

	}

}
