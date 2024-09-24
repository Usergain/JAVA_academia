import java.util.Scanner;
/*Escriba un programa que pida números pares mientras el usuario indique que quiere seguir introduciendo números. Para indicar 
 * que quiere seguir escribiendo números, el usuario deberá contestar S o s a la pregunta.  la pregunta se repita si el usuario no contesta S, s,
 *  N o n.
 */
public class EjerciOpcWHILE8 {
	
	//logs: me repite la pregunta ¿Quieres... dos veces, cuando le tecleo n (NO) me vuleve a pedir un numero par y termina.
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		int par = 0;
		String jugar = "S";
		int cont = 0;
		// boolean jugar=true;
		System.out.println(" CUENTA PARES ");		
		

		while (!jugar.equalsIgnoreCase("N")) {
			
			if(jugar.equalsIgnoreCase("S") || jugar.equalsIgnoreCase("N")) {
				
				System.out.println("Escriba un número par: ");
				par = teclado.nextInt();
				
				if (par % 2 == 0) {
					
					cont++;
					
				}else {
					
					System.out.println(par + " no es un número par. Inténtelo de nuevo: ");
					
				}
				
				
				System.out.println("¿Quiere escribir otro número par?(S/N): ");
				jugar = teclado.next();

			}else {
				
				System.out.println("Las opciones válidas son S / N. Debes introducir un caracter válido");
				System.out.println("¿Quiere escribir otro número par?(S/N): ");
				jugar = teclado.next();
			}

		}

		System.out.println(" Has escrito " + cont + " numeros pares ");
	}
}


