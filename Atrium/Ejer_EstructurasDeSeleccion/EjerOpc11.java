import java.util.Scanner;

public class EjerOpc11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int anio=0;
		
		Scanner teclado=new Scanner(System.in);
		
		System.out.println("COMPROBADOR DE AÑOS BISIESTOS");
		System.out.println("Escriba un año y le diré si es bisiesto: ");
		anio=teclado.nextInt();
		
		if(anio%400==0) {
			System.out.println("El año " + anio + " es un año bisiesto porque es múltiplo de 400 ");
		}
		
		else if(anio%4==0 && anio%100!=0) {
			System.out.println("El año " + anio + " es un año bisiesto porque es múltiplo de 4 sin ser múltiplo de 100 ");
		}
		
		else if(anio%100==0 && anio%4!=0){
			System.out.println("El año " + anio + " es un año bisiesto porque es múltiplo de 100 sin ser múltiplo de 4 ");
		}
		
		else {
			System.out.println("El año " + anio + " no es un año bisiesto");
		}

	}

}
