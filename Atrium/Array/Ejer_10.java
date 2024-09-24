
public class Ejer_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numeros = {{3, 4, 5, 78},
				{0, 0, 0, 0},
				{1, 1, 1, 1},
				{6, 6, 6, -1}};

		for (int[] fila : numeros) {
			System.out.print("{");
			for (int dato : fila) {
				System.out.print(dato + " ");
			}
			System.out.println("}");
		}


	}

}
