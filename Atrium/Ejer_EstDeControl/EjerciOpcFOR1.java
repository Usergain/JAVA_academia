import java.util.Scanner;

//Escriba un programa que pida dos n�meros enteros y escriba qu� n�meros son pares y cu�les impares desde el primero hasta el segundo.

public class EjerciOpcFOR1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 0;
		int num2 = 0;

		Scanner teclado = new Scanner(System.in);

		System.out.println(" Pares e impares ");
		System.out.println(" ");
		System.out.print("Escriba un numero entero : ");
		num1 = teclado.nextInt();
		System.out.print("Escriba un n�mero entero mayor o igual que " + num1);
		num2 = teclado.nextInt();

		if (num2 >= num1) {

			for (int i = num1; i <= num2; i++) {

				if (i % 2 == 0) {
					System.out.println("El numero " + i + " es par ");
				} else {
					System.out.println("El numero " + i + " es impar ");
				}

			}

		} else {
			System.out.println("�Le he pedido un n�mero entero mayor o igual que " + num1);
		}

	}
}
