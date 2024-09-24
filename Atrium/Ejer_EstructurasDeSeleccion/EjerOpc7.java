import java.util.Scanner;

public class EjerOpc7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado=new Scanner(System.in);
		double num1;
		double num2;
		
		System.out.println("Escriba un número: ");
		num1=teclado.nextDouble();
		System.out.println("Escriba otro número: ");
		num2=teclado.nextDouble();
		
		if(num1<num2) {
			System.out.println(" Menor: " + num1 + " ;Mayor: " + num2);
		}
		else if(num1>num2) {
			System.out.println(" Menor: " + num2 + " ;Menor: " + num1 );
		}
		
		else {
			System.out.println(" Los dos números son iguales. ");
		}
		
		

	}

}
