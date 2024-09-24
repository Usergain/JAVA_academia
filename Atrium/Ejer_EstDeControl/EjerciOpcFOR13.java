import java.util.Scanner;

public class EjerciOpcFOR13 {
	//Amplíe el programa anterior haciendo que el programa pida primero al usuario cuántas multiplicaciones se van a 
	//plantear

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0;
		int num2=0;
		int resultado;
		int respuesta;
		int preguntas;
		Scanner teclado=new Scanner(System.in);


		System.out.println(" TABLA DE MULTIPLICAR ");
		System.out.print(" Numero de preguntas : ");
		preguntas=teclado.nextInt();
		if(preguntas<=0) {
			System.out.println(" El numero de preguntas debe ser al menos 1 ");
		}
		else {
			for (int i = 0; i < preguntas; i++) {	
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

}
