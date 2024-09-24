import java.util.Scanner;

public class EjerciOpcWHILE5 {

	// Escriba un programa que pida números mientras no se escriba un número
	// negativo. El programa terminará escribiendola suma de los números
	// introducidos.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero1;
		int numero2;
		int auxiliar;
		int numPositivos;
		Scanner teclado = new Scanner(System.in);

		System.out.println("SUMA DE NÚMEROS ");
		System.out.println("");
		System.out.println("Escriba un número: ");
		numero1 = teclado.nextInt();
		if (numero1 > 0) {
			
			numPositivos =+numero1;
			do{
				
				System.out.println("Escribe otro número: ");
				numero2 = teclado.nextInt();
				if(numero2>0) {
					numPositivos=numPositivos+numero2;
				}
			}while(numero2>0); 
			System.out.println("La suma de los números positivos introducidos es " + numPositivos);
		} else {
			System.out.println("La suma de los números positivos introducidos es 0.");
		}

	}

}
