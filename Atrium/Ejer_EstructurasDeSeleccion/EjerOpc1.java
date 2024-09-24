import java.util.Scanner;

public class EjerOpc1 {

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
		else {
			System.out.println("Uno de los dos valores que ha escrito no son correctos ");
			System.out.println("Ejecute de nuevo el porgrama para vollver a intentarlo. ");
		}
	}

}
