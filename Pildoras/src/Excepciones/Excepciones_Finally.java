package Excepciones;

import java.util.*;

import javax.swing.JOptionPane;

public class Excepciones_Finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Elige una opcion: \n 1:Cuadrado \n 2:Rectangulo \n 3:Triángulo \n 4:Círculo");
		figura=entrada.nextInt();
		entrada.close();
		
		switch(figura) {
		
			case 1:
				int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
				System.out.println("El area del cuadrado es: " + Math.pow(lado, 2));
				break;
			 
			case 2:
				int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
				int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
				System.out.println("El area del rectangulo es: " + (base*altura));
				break;
			
			case 3:
				base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
				altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
				System.out.println("El area del triangulo es: " + (base*altura)/2);
				break;
				
			case 4:
				int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
				System.out.println("El area del circulo es: " + Math.PI*(Math.pow(radio, 2)));
				break;
				
			default:
				System.out.println("La opcion no es correcta");
				break;
		}
		
		// -------------------------------------------------------------------------------------
		
		int altura= Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm."));
		System.out.println("Si eres hombre tu peso ideal es: " + (altura - 110) + "kg" );
		System.out.println("Si eres mujer tu peos ideal es: " + (altura - 120) + "kg" );
			
		
	}
	
	static int figura;

}
