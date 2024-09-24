import java.util.Scanner;

public class EjerciOpcFOR9 {

	// Mejore el programa anterior haciendo que el programa escriba la suma realizada

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int entero = 0;
		int enteroMayor = 0;
		int suma = 0;
		Scanner teclado = new Scanner(System.in);

		do {

			System.out.println(" SUMA ENTRE VALORES ");
			System.out.println(" ");
			System.out.print(" Escriba un número entero positivo --> ");
			entero = teclado.nextInt();
		} while (entero <= 0);

		do {
			System.out.print("Escriba un número entero mayor que " + entero + " --> ");
			enteroMayor
			= teclado.nextInt();
		} while (enteroMayor < entero);




		for (int i = entero; i < enteroMayor; i++) {
			suma+=i;
		}

		System.out.print("La suma de " + entero + " hasta " + enteroMayor + " = " + suma);
		System.out.println(" ");


		for (int i = entero; i <= enteroMayor; i++) {
			if(i<enteroMayor) {
				System.out.print(i + " + ");	
			}else {
				System.out.print(i + " = " + suma);	
			}


		}

	}

}
