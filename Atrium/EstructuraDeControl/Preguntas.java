import java.util.Scanner;

/*Un centro de estudios nos ha solicitado que realicemos un algoritmo para saber la motivación que tienen los alumnos para estudiar programación.

Para ello quiere realizar una serie de preguntas y según la respuesta valorar su interés por estos estudios.

Cada respuesta tendrá un valor de 0 o 1 siendo el resultado el porcentaje total la suma de los valores obtenidos.

Si el valor obtenido en el primer intento es superior al 80% el ejercicio le dará la enhorabuena, si es inferior le pedirá volver a realizar el test con todas las preguntas dos veces mas. (El alumno solo podrá realizar la prueba tres veces).

Una vez realizado el test la tres veces, si la media de los resultados es inferior al 50%, se le pedirá que se lo comente a su profesor. Si es superior el programa terminara y le dará la enhorabuena.

Las preguntas para realizar son:*/

public class Preguntas {
	
	static int contadorSi = 0;
	static int contadorNo = 0;		
	static int contadorRondas = 1;
	static double porcentaje = 0;
	static int numeroRondas;
	public static void main(String[] args) {
		
		Scanner teclado=new Scanner(System.in);
		numeroRondas = 1;
		
		while(contadorRondas <= 3) {	
			
			System.out.println("******** INTENTO " + contadorRondas + " ********");
			
			System.out.println("Te gustan las computadoras.  Si(1)  No(0)");
			sumarContadores(teclado.nextInt());
			System.out.println("Disfrutas con la resolución de problemas. Si(1) No(0)");
			sumarContadores(teclado.nextInt());
			System.out.println("Quieres trabajar en equipo. Si(1) No(0)");
			sumarContadores(teclado.nextInt());
			System.out.println("Te agrada aprender por descubrimiento o prefieres que te indiquen las cosas paso a paso. Si(1) No(0)");
			sumarContadores(teclado.nextInt());
			System.out.println("Eres creativo. Si(1) No(0)");
			sumarContadores(teclado.nextInt());
			System.out.println("Eres resolutivo. Si(1) No(0)");
			sumarContadores(teclado.nextInt());
			System.out.println("Te rindes al primer intento Si(0) No(1)");
			sumarContadores(teclado.nextInt());
			System.out.println("Estas dispuesto a tener que actualizar tu conocimiento a lo largo de tu vida Si(1) No(0)*/");
			sumarContadores(teclado.nextInt());	
			
			if(contadorRondas == 1 || contadorRondas == 2) {
				porcentaje = (porcentaje + (contadorSi * 100) / (contadorSi+contadorNo)) / (contadorRondas);
			}else {
				porcentaje = (porcentaje + (contadorSi * 100) / (contadorSi+contadorNo)) / 2;
			}
			
			
			System.out.println("Porcentaje: " + porcentaje);
			
			contadorRondas++;
			
			if(porcentaje <= 80 && (contadorRondas == 2 || contadorRondas == 3)) {
				System.out.println("No has superado el test. Repite las preguntas !!!");
				System.out.println("El porcentaje de acierto es: " + porcentaje);
				contadorNo = 0;
				contadorSi = 0;
			}

			if(porcentaje >= 80 ){
				if(contadorRondas == 1) {
					contadorRondas = 4;
					System.out.println("Enhorabuena !!!! Has superado el test");
					System.out.println("El porcentaje de acierto es: " + porcentaje);
				}else {
					int intent = contadorRondas - 1;
					System.out.println("Enhorabuena !!!! Has superado el test en el intento: " + intent);
					System.out.println("El porcentaje de acierto es: " + porcentaje);
				}
			}
			
		}
		
	}
	
	public static void sumarContadores(int v) {
		if(v == 1){
			contadorSi++;
		}else {
			contadorNo++;
		}
	}

}
