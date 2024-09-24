import java.util.Scanner;

public class EjerciOpcFOR15 {
	/*Escriba un programa que genere una multiplicación de dos números del 11 al 99 al azar, pregunte por el resultado 
	 * y diga si se ha dado la respuesta correcta, si está a menos del 10% del valor correcta o a menos del 30%.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0;
		int num2=0;
		int resultado;
		int respuesta;
		int desv;
		Scanner teclado=new Scanner(System.in);

		System.out.println(" TABLA DE MULTIPLICAR ");
			for (int i = 0; i < 2; i++) {	
				num1=(int)(Math.random()*(100-11)+11);
				num2=(int)(Math.random()*(100-11)+11);
				resultado=num1*num2;
				System.out.print(" ¿Cuanto es " + num1 + " x " + num2 + " ? ");
				respuesta=teclado.nextInt();
				desv=((100*respuesta)/resultado);
				System.out.println(desv);
				System.out.println(resultado%10);
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


