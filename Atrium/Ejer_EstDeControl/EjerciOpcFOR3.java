import java.util.Iterator;
import java.util.Scanner;

//Escriba un programa que pregunte cu�ntos n�meros se van a introducir, pida esos n�meros, y muestre un mensaje cada vez que un n�mero no sea mayor que el primero.
public class EjerciOpcFOR3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		int numeros=0;
		int primero=0;
		int num;
		
		System.out.println("Mayores que el primero ");
		System.out.println(" ");
		System.out.println(" �Cuantos valores va a introducir?");
		numeros=teclado.nextInt();
		if(numeros>0) {
			System.out.print("Escriba un n�mero: ");
			primero=teclado.nextInt();
			for (int i = 0; i < numeros; i++) {
				System.out.print("Escriba un n�mero: ");
				num=teclado.nextInt();
				if (num<primero){
					System.out.println("Has introducido un numero menor que " + num);
				}
			}
		}

	}

}
