import java.util.Scanner;

public class EjerciOpcFOR14 {
	/*Amplíe el programa anterior haciendo que el programa lleve la cuenta de las respuestas correctas e incorrectas 
	 * e indique la nota correspondiente. Si la nota es igual o mayor que 9, el programa felicitará al usuario por el resultado.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0;
		int num2=0;
		int resultado;
		int respuesta;
		int preguntas=0;
		int correcto=0;
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
					correcto++;
				}
				else {
					System.out.println("La respuesta es incorrecta");
				}

			}
			
			float nota=(correcto*10/preguntas);
			System.out.println("Ha contestado correctamente " + nota + " preguntas ");
		}


	}

}
