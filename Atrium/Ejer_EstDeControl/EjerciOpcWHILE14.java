import java.util.Scanner;

//Escriba un programa que proponga sumas de n�meros positivos (dos n�meros entre 1 y 100) al usuario y compruebe la respuesta. El programa continuar� hasta que se acierten cinco sumas.

public class EjerciOpcWHILE14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub�
		// int num1=0;
		// int num2=0;
		// boolean acierto=false;
		int resultado;
		int cont = 0;

		Scanner teclado = new Scanner(System.in);

		System.out.println("OPERACIONES");

		do {
			int num1 = (int) Math.floor(Math.random() * 100 + 1);
			int num2 = (int) Math.floor(Math.random() * 100 + 1);
			int algoritmo=num1+num2;

			System.out.println(" Escriba el resultado de la siguiente operaci�n ");
			System.out.print(num1 +  " + " + num2 + " = ");
			resultado=teclado.nextInt();
			
			if (resultado==algoritmo) {
				cont++;
			}

		} while (cont <= 5); // es 6 y si pongo condicion == se para en el primer ciclo
		
		System.out.println("Felicidades has acertado cinco sumas.");

	}

}
