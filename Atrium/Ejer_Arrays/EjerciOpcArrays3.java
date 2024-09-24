/*Se quiere realizar un programa que lea por teclado las 5 notas obtenidas por un alumno (comprendidas entre 0 
 * y 10). A continuación debe mostrar todas las notas, la nota media, la nota más alta que ha sacado y la menor.
 */
public class EjerciOpcArrays3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		float[] notas = { 3.2F, 5.6F, 6.9F, 7.9F, 8.2F };
		float minimo = notas[0];
		float maximo = notas[0];
		float media = 0;
		int cont = 0;
		float suma = 0;

		for (int i = 0; i < notas.length; i++) {

			if (notas[i] < minimo) {
				minimo = notas[i];
			}
			if (notas[i] > maximo) {
				maximo = notas[i];
			}
			cont++;
			suma += notas[i];
			media = suma / cont;
		}

		System.out.println(" La nota mas alta ha sido " + maximo);
		System.out.println(" La nota mas baja ha sido " + minimo);
		System.out.println(" La nota media ha sido " + media);
	}

}
