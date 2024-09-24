import java.util.Scanner;

public class EjerOpc3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado=new Scanner(System.in);
		int par;
		int impar;
		
		System.out.println("PAR E IMPAR");
		System.out.println("Escriba un numero par: ");
		par=teclado.nextInt();
		System.out.println("Escriba un numero impar: ");
		impar=teclado.nextInt();
		
		if(par%2==0 && impar%2!=0) {
			
			System.out.println("¡Gracias por su colaboracion! ");
		}
		else if(par%2!=0 && impar%2!=0){
			System.out.println("No ha escrito un numero par ");
			System.out.println("Ejecute de nuevo el programa para volver a intentarlo. ");
		}
		else if(par%2==0 && impar%2!=0) {
			System.out.println("No ha escrito un numero impar ");
			System.out.println("Ejecute de nuevo el programa para volver a intentarlo. ");
		}
		else {
			System.out.println("No ha escrito un numero par ");
			System.out.println("No ha escrito un numero impar ");
		}

	}

}
