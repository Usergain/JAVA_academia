import java.util.Scanner;

public class Ejer1 {
	
	/*Escriba un programa que pida dos n�meros enteros. El programa pedir� de nuevo el segundo n�mero mientras no seamayor que el primero. 
	 * El programa terminar� escribiendo los dos n�meros.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		int numero1;
		int numero2;
		
		System.out.println(" Dame un numero:" );
		numero1=teclado.nextInt();
		
		do {	
			System.out.println(" Dame otro numero: ");
			numero2=teclado.nextInt();
			
		}while(numero2<numero1);
		
		System.out.println("Los numeros introducidos por pantalla son : " + numero1 + " y " + numero2);
		
	}

}
