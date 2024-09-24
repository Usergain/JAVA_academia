import java.util.Scanner;

public class EjerciOpcWHILE6 {

	// Escriba un programa que pida un valor límite positivo y a continuación pida
	// números hasta que la suma de los números introducidos supere el
	// límite inicial.

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
				System.out.println("El límite debe ser mayor que 0. Intentelo de nuevo: ");
				limite = teclado.nextInt();
	
		}
				System.out.println("Escriba un número: ");
				numero = teclado.nextInt();
				teclado.nextLine();

				while (numero < limite) {
					suma = suma + numero;
					System.out.println("Escriba otro número: ");
					numero = teclado.nextInt();
				}
				System.out.println("Ha superado el limite. La suma de los números introducidos es " + suma);
			
		}

	

}
