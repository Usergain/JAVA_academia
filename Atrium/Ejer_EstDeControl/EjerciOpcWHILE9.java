import java.util.Scanner;

//Escriba un programa que calcule la descomposici�n en factores primos de un n�mero.

public class EjerciOpcWHILE9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado=new Scanner(System.in);
		int num;
		System.out.println("DESCOMPOSICI�N DE N�MEROS PRIMOS ");
		System.out.println("");
		System.out.printf("Ingrese un n�mero (>1): ");
        num= teclado.nextInt();

        if (num <= 1) {
            System.out.printf("Debe ingresar un n�mero mayor que uno");
        } else {
            descomponer_factores(num);
        }
    }
	
	private static void descomponer_factores(int num) {
		int factor_primo=2;
		do {
			if(num % factor_primo ==0) {
				num /= factor_primo;
				System.out.printf("%d", factor_primo);
				System.out.print(" ");
			}else {
				factor_primo++;
			}
			
		}while(num>1);
	}
} 

