import java.util.Scanner;

public class EjerOpc2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		int par=0;
		int impar=1;
		
		System.out.println("PAR E IMPAR");
		System.out.println("Escriba un numero par: ");
		par=teclado.nextInt();
		
			if(par%2!=0) {
					
				System.out.println("No ha escrito un n�mero par");
				System.out.println("Ejecute de nuevo el programa para volver a intentarlo");
			}
				
			else {
	
				System.out.println("Escriba un numero impar: ");
				impar=teclado.nextInt();
				if(impar%2==0) {
					
					System.out.println("No ha escrito un n�mero impar");
					System.out.println("Ejecute de nuevo el programa para volver a intentarlo");
				}
					
				if(par%2==0 && impar%2!=0) {
						
					System.out.println("�Gracias por su colaboracion! ");
				}
		
			}

	}

}
