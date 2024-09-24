import java.util.Scanner;

public class EjerOpc8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado=new Scanner(System.in);
		int anio1;
		int anio2;
		int difAnios=0;
		
		System.out.println(" COMPARADOR DE AÑOS");
		System.out.println("¿En que año estamos?: ");
		anio2=teclado.nextInt();
		System.out.println("Escriba un año cualquiera: ");
		anio1=teclado.nextInt();
		
		difAnios=anio1-anio2;
		
		if(difAnios==1) {
			System.out.println("Para llegar al año " + anio2 + " falta " + difAnios + " año. ");
		}
		else if(difAnios>1) {
			System.out.println("Para llegar al año " + anio2 + " faltan " + difAnios + " años. ");
		}
		else {
			System.out.println("¡ Son el mismo año.!");
		}

	}

}
