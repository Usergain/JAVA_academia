import java.util.Scanner;

public class EjerciOpcWHILE2 {
	//escriba un programa que pida números decimales mientras el usuario escriba número mayores que el primero.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner teclado=new Scanner(System.in);
		 float num1;
		 float num2;
		 float aux;
		 
		 System.out.println("NUMEROS MAYORES");
		 
		 System.out.println("Dame un número");
		 num1=teclado.nextFloat();
		 
		 System.out.println("Escriba otro numero mayor que " + num1);
		 num2=teclado.nextFloat();
		 
		 if(num2>num1) {
			 do {
				 System.out.println("Escriba otro numero mayor que " + num2);
				 num2=teclado.nextFloat(); 
				 aux=num1;
				 num1=num2;
				
			 }while(num2>aux);
			 
			 System.out.println("El numero " + num2 + " es menor que " + aux);
		 }
		 
		 else if(num1==num2) {
			 System.out.println("El numero " + num1 + " es igual " + num2);
		 }
		 
		 else {
			 System.out.println("El numero " + num1 + " es menor " + num1);
		 }
		 
		 
		 
		 
	}

}
