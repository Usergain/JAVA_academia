import java.util.Scanner;

public class EjerciOpcFOR16 {
	/*Amplíe el programa anterior haciendo que el programa lleve la cuenta de las respuestas correctas e incorrectas e 
	 * indique la nota correspondiente. Si la nota es igual o mayor que 9, el programa felicitará al usuario por el resultado.

Si se acierta la respuesta, se contabilizará como 1
Si se acerca menos del 10% a la respuesta correcta, se contabilizará como 0.66.
Si se acerca entre el 10% y el 30% a la respuesta correcta, se contabilizará como 0.33.
Si se aleja más del 30% de la respuesta correcta, se contabilizará como 0*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0;
		int num2=0;
		int resultado;
		int respuesta;
		int desv;
		int preguntas;
		float nota=0;
		Scanner teclado=new Scanner(System.in);

		System.out.println(" TABLA DE MULTIPLICAR II ");
		System.out.print(" Numero de preguntas? ");
		preguntas=teclado.nextInt();
		if(preguntas<1) {
			System.out.println("Lo siento el numero de preguntas debe ser al menos 1 ");
		}
		
			for (int i = 0; i < preguntas; i++) {	
				num1=(int)(Math.random()*(100-11)+11);
				num2=(int)(Math.random()*(100-11)+11);
				resultado=num1*num2;
				System.out.print(" ¿Cuanto es " + num1 + " x " + num2 + " ? ");
				respuesta=teclado.nextInt();
				desv=((100*respuesta)/resultado);
				//System.out.println(desv);
				//System.out.println(resultado%10);
				if(respuesta==resultado){
					System.out.println("La respuesta es correcta");
					nota++;
					
				}
				else {
					System.out.println("La respuesta es incorrecta");
					if(respuesta==0) {
						System.out.println(" Has fallado por menos del 30% " + " La respuesta correcta era " + resultado);
						nota=(float) (nota+0.33);
					}
					
					else if((desv>resultado*0.90)||(resultado+desv<resultado*1.10)) {
						System.out.println(" Has fallado por menos del 10% " + " La respuesta correcta era " + resultado);
						nota=(float) (nota+0.66);
					}
					
					else {
						System.out.println(" Has fallado por menos del 30% " + " La respuesta correcta era " + resultado);
						nota=(float) (nota+0.33);
					}
					
				}

			}
			float notaFinal=(nota*10)/preguntas;
			
			System.out.println(" Le corresponde una nota de " + notaFinal );

	}

}
