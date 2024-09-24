import java.util.Scanner;

public class EjerciOpcWHILE7 {
	
	/*Escriba un programa que pida primero dos números enteros (mínimo y máximo) y que después pida números enteros situados entre ellos.
	 * El programa terminará cuando se escriba un número que no esté comprendido entre los dos valores iniciales. El programa termina escribiendo la 
	 * cantidad de números escritos.
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
		System.out.println("Escriba un número: ");
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
			System.out.println("No ha escrito ningún número entre " + minimo + " y " + maximo);
		}
		
		else {
			while(numero>minimo && numero<maximo) {
				System.out.println("Escriba un número entre " + minimo + " y " + maximo);
				numero=teclado.nextInt();
				cont++;
			}
			
			System.out.println("Ha escrito " + cont + " números entre " + minimo + " y " + maximo);
		}

	}

}
