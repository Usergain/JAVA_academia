import java.util.Scanner;

public class EjerOpc11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int anio=0;
		
		Scanner teclado=new Scanner(System.in);
		
		System.out.println("COMPROBADOR DE A�OS BISIESTOS");
		System.out.println("Escriba un a�o y le dir� si es bisiesto: ");
		anio=teclado.nextInt();
		
		if(anio%400==0) {
			System.out.println("El a�o " + anio + " es un a�o bisiesto porque es m�ltiplo de 400 ");
		}
		
		else if(anio%4==0 && anio%100!=0) {
			System.out.println("El a�o " + anio + " es un a�o bisiesto porque es m�ltiplo de 4 sin ser m�ltiplo de 100 ");
		}
		
		else if(anio%100==0 && anio%4!=0){
			System.out.println("El a�o " + anio + " es un a�o bisiesto porque es m�ltiplo de 100 sin ser m�ltiplo de 4 ");
		}
		
		else {
			System.out.println("El a�o " + anio + " no es un a�o bisiesto");
		}

	}

}
