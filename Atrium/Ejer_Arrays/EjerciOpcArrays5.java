import java.util.Arrays;
import java.util.Scanner;

//Hacer un programa que inicialice un vector de números con valores aleatorios, y posterior ordene los elementos de menor a mayor.
public class EjerciOpcArrays5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int aleatorio;
		int numero;
		int aux = 0;
		boolean ordenado;
		Scanner teclado = new Scanner(System.in);

		System.out.print(" Cuantos numeros aleatorios quieres: ");
		numero = teclado.nextInt();
		int[] array = new int[numero];

		for (int i = 0; i < numero; i++) {
			aleatorio = (int) (Math.random() * (101 - 1) + 1);
			array[i] = aleatorio;
		}

		System.out.println(Arrays.toString(array));

		ordenar(array);
		System.out.println(Arrays.toString(array));

	}

	static void ordenar(int[] array) {
		int aux = 0;
		boolean ordenado;
		do {
			ordenado = true;
			for (int indice = 0; indice < array.length - 1; indice++) {
				if (array[indice] > array[indice + 1]) {
					aux = array[indice];
					array[indice] = array[indice + 1];
					array[indice + 1] = aux;
					ordenado = false; // lo volvemos a reiniciar a false para poder recorrer otra vez el bucle for
					// cuando el length sea superior ya no entrará y ordenado=true
				}
			}
		} while (ordenado == false);

	}

}
