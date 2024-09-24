/* Realizar un programa que defina un vector llamado “vector_numeros” de 10 enteros, a continuación lo 
 * inicialice con valores aleatorios (del 1 al 10) y posteriormente muestre en pantalla cada elemento del 
 * vector junto con su cuadrado y su cubo.
 */

public class EjerciOpcArrays1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] vector_numeros = new int[10];
		int aleatorio;

		for (int i : vector_numeros) {
			aleatorio = (int) (Math.random() * (11 - 1) + 1);
			vector_numeros[i] = aleatorio;
			System.out.println(vector_numeros[i] + " --> " + Math.pow(vector_numeros[i], 2) + " --> "
					+ Math.pow(vector_numeros[i], 3));
		}

	}

}
