import java.util.Scanner;

//Ampl�e el programa anterior, haciendo que el programa pida cu�ntas operaciones se deben acertar para terminar el programa. Al terminar, el programa indicar� cu�ntos intentos han sido necesarios.

public class EjerciOpcWHILE15 {
	/*
	 * �Cu�ntas operaciones correctas debe contestar para terminar el programa? 0
	 * 
	 * El n�mero de operaciones debe ser mayor que cero.
	 * 
	 * �Cu�ntas operaciones correctas debe contestar para terminar el programa? 1
	 */

	//log: por que en el while de abajo si le pongo cont==opCorrectas, se para en el primer bucle? y si le pongo <= 5 tengo que acertar 6?
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opCorrectas = 0;
		int resultado;
		int cont = 0;
		int correcto = 0;

		Scanner teclado = new Scanner(System.in);

		System.out.println("OPERACIONES II ");
		System.out.println(" �Cu�ntas operaciones correctas debe contestar para terminar el programa? ");
		opCorrectas = teclado.nextInt();

		do {
			int num1 = (int) Math.floor(Math.random() * 100 + 1);
			int num2 = (int) Math.floor(Math.random() * 100 + 1);
			int algoritmo = num1 + num2;

			
			
			//bucle de repetici�n hasta que no te de un n�mero mayor que 0
			
			if (opCorrectas == 0) {

				do {
					System.out.println(" �Cu�ntas operaciones correctas debe contestar para terminar el programa? ");
					opCorrectas = teclado.nextInt();

				} while (opCorrectas < 0);
			}

			System.out.println(" Escriba el resultado de la siguiente operaci�n ");
			System.out.print(num1 + " + " + num2 + " = ");
			resultado = teclado.nextInt();
			cont++;

			if (resultado == algoritmo) {
				correcto++;
				System.out.println("Ha acertado " + correcto + " operaciones en " + cont );
			}

		} while (correcto < opCorrectas);
		
		

	}

}

