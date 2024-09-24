import java.util.Random;

//Amplíe el programa anterior, haciendo que el programa indique si hay dos o tres números iguales.

import java.util.Scanner;

public class EjerciOpcWHILE11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		String jugar=null;
		
		System.out.println("Pulse Intro para volver a jugar, otra tecla e Intro para terminar: ");
		jugar=teclado.nextLine();
		
		
		while(jugar.equals("")){
			
			int valor = (int) Math.floor(Math.random() * 6 + 1);
			int valor2 = (int) Math.floor(Math.random() * 6 + 1);
			int valor3 = (int) Math.floor(Math.random() * 6 + 1);
			
			System.out.println(" Tirada: " + valor + " " + valor2 + " " + valor3 + " ");
			
			if(valor!=valor2 && valor!=valor3 && valor2!=valor3) {
				System.out.println(" No hay números iguales ");
			}
			else if(valor==valor2 && valor2==valor3) {
				System.out.println(" Hay tres números iguales ");
			}
			if(valor==valor2  || valor==valor3 || valor2==valor3 ) {
				System.out.println(" Hay dos números iguales ");
			}
			
			System.out.println("Pulse Intro para volver a jugar, otra tecla e Intro para terminar: ");
			jugar=teclado.nextLine();
		}
		
		
	}

}
