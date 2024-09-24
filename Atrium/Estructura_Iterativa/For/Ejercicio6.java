package For;

public class Ejercicio6 {
	
	//Hallar los números impares menores de 30 y que aparezcan en orden descendente

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 30; i > 0; i--) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
		}

	}

}