import java.util.Random;
import java.util.Scanner;

public class EjerciOpcFOR12 {

	//Escriba un programa que genere una multiplicación de dos números del 2 al 10 al azar, pregunte por el resultado y diga 
	//si se ha dado la respuesta correcta.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1=0;
		int num2=0;
		int resultado;
		int respuesta;
		Scanner teclado=new Scanner(System.in);


		System.out.println(" TABLA DE MULTIPLICAR ");
		for (int i = 0; i < 2; i++) {	
			num1=(int)(Math.random()*(11-2)+2);
			num2=(int)(Math.random()*(11-2)+2);
			resultado=num1*num2;
			System.out.print(" ¿Cuanto es " + num1 + " x " + num2 + " ? ");
			respuesta=teclado.nextInt();
			if(resultado==respuesta){
				System.out.println("La respuesta es correcta");
			}
			else {
				System.out.println("La respuesta es incorrecta");
			}

		}

	}

}

