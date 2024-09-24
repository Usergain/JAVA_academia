import java.util.Scanner;

public class EjerciOpcWHILE3 {
	
	//Escriba un programa que pida números enteros mientras sean cada vez más grandes.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			 Scanner teclado=new Scanner(System.in);
			 int num1;
			 int num2;
			 int aux;
			 
			 System.out.println("CADA VEZ MÁS GRANDES");
			 
			 System.out.println("Escribe un número");
			 num1=teclado.nextInt();
			 
			 System.out.println("Escriba otro numero mayor que " + num1 + ": ");
			 num2=teclado.nextInt();
			 
			 if(num2>num1) {
				 do {
					 System.out.println("Escriba un numero mayor que " + num2 + "");
					 num2=teclado.nextInt(); 
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
