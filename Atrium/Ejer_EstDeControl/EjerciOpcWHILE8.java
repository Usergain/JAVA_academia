import java.util.Scanner;
/*Escriba un programa que pida n�meros pares mientras el usuario indique que quiere seguir introduciendo n�meros. Para indicar 
 * que quiere seguir escribiendo n�meros, el usuario deber� contestar S o s a la pregunta.  la pregunta se repita si el usuario no contesta S, s,
 *  N o n.
 */
public class EjerciOpcWHILE8 {
	
	//logs: me repite la pregunta �Quieres... dos veces, cuando le tecleo n (NO) me vuleve a pedir un numero par y termina.
	

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
				
				System.out.println("Escriba un n�mero par: ");
				par = teclado.nextInt();
				
				if (par % 2 == 0) {
					
					cont++;
					
				}else {
					
					System.out.println(par + " no es un n�mero par. Int�ntelo de nuevo: ");
					
				}
				
				
				System.out.println("�Quiere escribir otro n�mero par?(S/N): ");
				jugar = teclado.next();

			}else {
				
				System.out.println("Las opciones v�lidas son S / N. Debes introducir un caracter v�lido");
				System.out.println("�Quiere escribir otro n�mero par?(S/N): ");
				jugar = teclado.next();
			}

		}

		System.out.println(" Has escrito " + cont + " numeros pares ");
	}
}


