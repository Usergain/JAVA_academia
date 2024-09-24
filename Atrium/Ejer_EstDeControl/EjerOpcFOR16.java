import java.util.Scanner;

public class EjerOpcFOR16 {
	//Amplíe el programa anterior haciendo que el programa pida primero al usuario cuántas multiplicaciones se van a 
	//plantear.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0;
		int num2=0;
		int resultado;
		int respuesta;
		int desv;
		int preguntas;
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
					
				}
				else {
					System.out.println("La respuesta es incorrecta");
					if(respuesta==0) {
						System.out.println(" Has fallado por menos del 30% " + " La respuesta correcta era " + resultado);
					}
					
					else if((desv>resultado*0.90)||(resultado+desv<resultado*1.10)) {
						System.out.println(" Has fallado por menos del 10% " + " La respuesta correcta era " + resultado);
					}
					
					else {
						System.out.println(" Has fallado por menos del 30% " + " La respuesta correcta era " + resultado);
					}
					
				}

			}

	}

}
