import java.util.Scanner;

public class EjerOpc6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		int dividendo = 0;
		int divisor=0;
		int cociente=0;
		int resto=0;
		
		System.out.println(" DIVISOR DE NUMEROS ");
		System.out.println("Escriba el dividendo: ");
		dividendo=teclado.nextInt();
		
		System.out.println("Escriba el divisor: ");
		divisor=teclado.nextInt();
		
		if(divisor!=0) {
			cociente=(dividendo/divisor);
			resto=dividendo-(divisor*cociente);
			
			if(resto==0) {
				System.out.println("La division es exacta. Cociente: " + cociente + " Resto: " + resto );
			}
			else if(resto!=0) {
				System.out.println("La division no es exacta. Cociente: " + cociente + " Resto: " + resto );
			}
		}
		else {
		
			if(divisor==0) {
				System.out.println("No se puede dividir por cero. ");
			}
			
			
		}
	

	}

}
