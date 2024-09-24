import java.util.Scanner;

public class EjerciOpcFOR11 {

	//Escriba un programa que pida un número entero mayor que cero y calcule su factorial.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero=0;
		int factorial=1;
		Scanner teclado=new Scanner(System.in);

		System.out.println("FACTORIAL");
		System.out.println("Escribe un numero mayor que cero");
		numero=teclado.nextInt();
		
		if(numero>=0) {
			for (int i = 1; i <= numero; i++) {
				factorial=factorial*i;
			}
			
			System.out.println(factorial);
		}
		else {
			System.out.println("Le he pedido un numero entero mayor que cero");
		}



	}

}
