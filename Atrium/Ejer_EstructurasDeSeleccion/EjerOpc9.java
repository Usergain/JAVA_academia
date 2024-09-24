import java.util.Scanner;

public class EjerOpc9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado=new Scanner(System.in);
		int num1;
		int num2;
		
		System.out.println("COMPARADOR DE MULTIPLOS");
		System.out.println("Escriba un numero: ");
		num1=teclado.nextInt();
		
		if(num1>=0) {
			System.out.println("Escriba otro numero: ");
			num2=teclado.nextInt();
			
			if(num2>=0) {
		
				if(num1%(num2)==0){
					System.out.println(num1 + " es múltiplo de " + num2);
					}
				else {
					System.out.println(num1 + " no es múltiplo de " + num2);
				}
			}
			
			else {
				System.out.println(" Lo siento, este programa no admite valores negativos. ");
			}
		}
		else {
			System.out.println(" Lo siento, este programa no admite valores negativos. ");
		}
		
		
	}

}
