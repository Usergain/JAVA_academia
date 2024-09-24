import java.util.Scanner;

public class EjerOpc12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float a=0;
		float b=0;
		float solucion;
		Scanner teclado=new Scanner(System.in);
		
		System.out.println("ECUACION AX+ B = 0");
		System.out.println("Escriba el valor del coeficiente a: ");
		a=teclado.nextFloat();
		System.out.println("Escriba el valor del coeficiente b: ");
		b=teclado.nextFloat();
		
		if(a!=0) {
			System.out.println("La ecuacion tiene solucion");
		}
		
		else if(a==0 &&b==0) {
			System.out.println("Todos los numeros tienen solucion");
		}
		
		else {
			System.out.println("La ecuacion no tiene solucion");
		}

	}

}
