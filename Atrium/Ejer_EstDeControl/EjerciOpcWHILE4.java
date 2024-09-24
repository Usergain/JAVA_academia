import java.util.Scanner;

public class EjerciOpcWHILE4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int positivos;
		int numero;
		int numPositivo=0;

		System.out.println("NUMEROS PISITIVOS");
		System.out.println(" ");
		System.out.println("Escribe la cantidad de números pisitivos a escribir: ");
		positivos = teclado.nextInt();

		if (positivos > 0 && positivos!=1) {
			System.out.println("Escribe un numero: ");
			for (int i = 0; i < positivos; i++) {
				System.out.println("Escribe otro numero: ");
				numero=teclado.nextInt();
				if(numero>0) {
					numPositivo++;
				}
			}
			
			System.out.println("Ha escrito " + positivos + " numeros, " + numPositivo + " de ellos positivos. ");
		}
		
		else if(positivos==1) {
			System.out.println("Escribe un numero: ");
			numero=teclado.nextInt();
			if(numero>0) {
				System.out.println("Has escrito 1 numero positivo");
			}
			else {
				System.out.println("Has escrito un numero negativo");
			}
		}
		else {
			while(positivos>0) {
				System.out.println("La cantidad debe ser mayor que 0. Inténtelo de nuevo");	
			}
			
		}

	}

}
