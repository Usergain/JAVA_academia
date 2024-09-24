import java.util.Scanner;

/*Crear un vector de 5 elementos de cadenas de caracteres, inicializa el vector con datos leídos por el teclado.
 *  Copia los elementos del vector en otro vector pero en orden inverso, y muéstralo por la pantalla.
 */
public class EjerciOpcArrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] letras = new char[5];
		Scanner teclado = new Scanner(System.in);

		for (int i = 0; i < letras.length; i++) {
			System.out.print("Dame una letra ");
			letras[i] = teclado.next().charAt(0);

		}
		for (int i = letras.length - 1; i >= 0; i--) {
			System.out.print(" " + letras[i] + " ");

		}

	}

}
