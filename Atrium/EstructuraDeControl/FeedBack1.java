import java.util.Scanner;

/*Un centro de estudios nos ha solicitado que realicemos un algoritmo para saber la motivación que tienen los alumnos para estudiar programación.

Para ello quiere realizar una serie de preguntas y según la respuesta valorar su interés por estos estudios.

Cada respuesta tendrá un valor de 0 o 1 siendo el resultado el porcentaje total la suma de los valores obtenidos.

Si el valor obtenido en el primer intento es superior al 80% el ejercicio le dará la enhorabuena, si es inferior le pedirá volver a realizar el test con todas las preguntas dos veces mas. (El alumno solo podrá realizar la prueba tres veces).

Una vez realizado el test la tres veces, si la media de los resultados es inferior al 50%, se le pedirá que se lo comente a su profesor. Si es superior el programa terminara y le dará la enhorabuena.

Las preguntas para realizar son:

*/
public class FeedBack1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		char bn = teclado.next().toUpperCase().charAt(0);
		int count=0;
		int countTot=0;
		int respt1=0;
		float notaFinal=(respt1*100)/count; 
		float notaFinal2=respt1/countTot;		

		do {
			
		count=0;
		System.out.println("Te gustan las computadoras.  Si(1)  No(0)");
		bn=teclado.next().toUpperCase().charAt(0);
			if(bn==1) {
				respt1++;
			}
		count++;
		
		System.out.println("Disfrutas con la resolución de problemas. Si(1) No(0)");
		bn=teclado.next().toUpperCase().charAt(0);
			if(bn==1) {
				respt1++;
			}
		count++;
		
		System.out.println("Quieres trabajar en equipo. Si(1) No(0)");
		bn=teclado.next().toUpperCase().charAt(0);
			if(bn==1) {
				respt1++;
			}
		count++;
		
		System.out.println("Te agrada aprender por descubrimiento o prefieres que te indiquen las cosas paso a paso. Si(1) No(0)");
		bn=teclado.next().toUpperCase().charAt(0);
			if(bn==1) {
				respt1++;
			}
		count++;
		
		System.out.println("Eres creativo. Si(1) No(0)");
		bn=teclado.next().toUpperCase().charAt(0);
			if(bn==1) {
				respt1++;
			}
		count++;
		
		System.out.println("Eres resolutivo. Si(1) No(0)");
		bn=teclado.next().toUpperCase().charAt(0);
			if(bn==1) {
				respt1++;
			}
		count++;
		
		System.out.println("Te rindes al primer intento Si(0) No(1)");
		bn=teclado.next().toUpperCase().charAt(0);
			if(bn==1) {
				respt1++;
			}
		count++;
		
		System.out.println("Estas dispuesto a tener que actualizar tu conocimiento a lo largo de tu vida Si(1) No(0)*/");
		bn=teclado.next().toUpperCase().charAt(0);
			if(bn==1) {
				respt1++;
			}
		count++;
		
		countTot++;
		
		if(notaFinal>80 && countTot==1 ) {
			
			System.out.println("La nota final es : " + notaFinal + " % y has tenido " + countTot + " intentos " );
			System.out.println("Enhorabuena");	
		}
		
		else if(notaFinal<80 && countTot==1){
			
			System.out.println("La nota final es : " + notaFinal + " % y has tenido " + countTot + " intentos " );
			System.out.println("Vuelve a responder a la encuesta dos veces más ");
		}
		
		else if(notaFinal2>=50 && countTot==3) {
			
			System.out.println("La nota final es : " + notaFinal2 + " % y has tenido " + countTot + " intentos " );
			System.out.println("Enhorabuena");
		}
		
		else {
			
			System.out.println("Habla con tu tutor");
		}
		
		}while(notaFinal>80 && (countTot==1 || countTot==3));
		
			
	}
	
}
	
	

