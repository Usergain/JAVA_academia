import java.util.Scanner;

public class EjerOpc8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado=new Scanner(System.in);
		int anio1;
		int anio2;
		int difAnios=0;
		
		System.out.println(" COMPARADOR DE A�OS");
		System.out.println("�En que a�o estamos?: ");
		anio2=teclado.nextInt();
		System.out.println("Escriba un a�o cualquiera: ");
		anio1=teclado.nextInt();
		
		difAnios=anio1-anio2;
		
		if(difAnios==1) {
			System.out.println("Para llegar al a�o " + anio2 + " falta " + difAnios + " a�o. ");
		}
		else if(difAnios>1) {
			System.out.println("Para llegar al a�o " + anio2 + " faltan " + difAnios + " a�os. ");
		}
		else {
			System.out.println("� Son el mismo a�o.!");
		}

	}

}
