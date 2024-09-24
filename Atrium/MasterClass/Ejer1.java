import java.util.Scanner;

public class Ejer1 {
	
	/*Escriba un programa que pida dos números enteros. El programa pedirá de nuevo el segundo número mientras no seamayor que el primero. 
	 * El programa terminará escribiendo los dos números.
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
