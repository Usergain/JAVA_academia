import java.util.Scanner;

public class EjerciOpcWHILE6 {

	// Escriba un programa que pida un valor l�mite positivo y a continuaci�n pida
	// n�meros hasta que la suma de los n�meros introducidos supere el
	// l�mite inicial.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int limite;
		int numero;
		int suma = 0;

		System.out.println("HASTA EL LIMITE");
		System.out.println("");

		System.out.println("Escriba el valor limite: ");
		limite = teclado.nextInt();

		while (limite <= 0) {
				System.out.println("El l�mite debe ser mayor que 0. Intentelo de nuevo: ");
				limite = teclado.nextInt();
	
		}
				System.out.println("Escriba un n�mero: ");
				numero = teclado.nextInt();
				teclado.nextLine();

				while (numero < limite) {
					suma = suma + numero;
					System.out.println("Escriba otro n�mero: ");
					numero = teclado.nextInt();
				}
				System.out.println("Ha superado el limite. La suma de los n�meros introducidos es " + suma);
			
		}

	

}
