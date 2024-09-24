import java.util.Scanner;

public class EjerciOpcWHILE1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int numero1;
		int numero2;

		System.out.println(" Dame un numero:");
		numero1 = teclado.nextInt();

		do {
			System.out.println(" Dame otro numero: ");
			numero2 = teclado.nextInt();

		} while (numero2 < numero1);

		System.out.println("Los numeros introducidos por pantalla son : " + numero1 + " y " + numero2);

	}

}


