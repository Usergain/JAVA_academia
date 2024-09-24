import java.util.Scanner;

public class EjerciOpcWHILE7 {
	
	/*Escriba un programa que pida primero dos n�meros enteros (m�nimo y m�ximo) y que despu�s pida n�meros enteros situados entre ellos.
	 * El programa terminar� cuando se escriba un n�mero que no est� comprendido entre los dos valores iniciales. El programa termina escribiendo la 
	 * cantidad de n�meros escritos.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		int numero;
		int minimo;
		int maximo;
		int cont = 0;
		
		System.out.println(" ENTRE DOS VALORES ");
		System.out.println();
		System.out.println("Escriba un n�mero: ");
		minimo=teclado.nextInt();
		System.out.println("Escriba un numero mayor que " + minimo);
		maximo=teclado.nextInt();
		
		System.out.println(minimo);
		System.out.println(maximo);
		
		
		while(maximo<minimo) {
			System.out.println(maximo + " no es mayor que " + minimo + " Intentelo de nuevo: ");
			maximo=teclado.nextInt();
			System.out.println(minimo);
			System.out.println(maximo);
		}	
		
		System.out.println("Escriba otro numero entre " + minimo + " y " + maximo + " : ");
		numero=teclado.nextInt();
		
		if(numero<minimo || numero>maximo) {
			System.out.println("No ha escrito ning�n n�mero entre " + minimo + " y " + maximo);
		}
		
		else {
			while(numero>minimo && numero<maximo) {
				System.out.println("Escriba un n�mero entre " + minimo + " y " + maximo);
				numero=teclado.nextInt();
				cont++;
			}
			
			System.out.println("Ha escrito " + cont + " n�meros entre " + minimo + " y " + maximo);
		}

	}

}
