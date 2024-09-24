import java.util.Scanner;

public class EjerOpc10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado=new Scanner(System.in);
		int num1;
		int num2;
		int num3;
		
		System.out.println("COMPARADOR DE TRES NÚMEROS");
		System.out.println("Escriba un numero: ");
		num1=teclado.nextInt();
		System.out.println("Escribe otro numero: ");
		num2=teclado.nextInt();
		System.out.println("Escribe otro numero más: ");
		num3=teclado.nextInt();
		
		if(num1==num2 && num1==num3 && num2==num3) {
			System.out.println("Ha escrito tres veces el mismo numero.");
		}
		
		else if(num1!=num2 && num2!=num3 && num1!=num3) {
			System.out.println("Los tres numeros que has escrito son distintos.");
		}
		else {
			System.out.println("Ha escrito uno de los numeros dos veces.");
		}
		

	}

}
