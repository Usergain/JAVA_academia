package For;

public class Ejercicio8 {
	/*Con los 20 primeros números decir con cada uno por cual es divisible: ejemplo: 1 –> es divisible por 1
2 –> es divisible por 1 es divisible por 2 …*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 1; i <= 20; i = i + 1) {
            System.out.println();
            System.out.println("El " + i + " es divisible por:");
            System.out.println();
            
            for (int j = 1; j <= 20; j = j + 1) {
                if (i % j == 0) {
                    if (j != 1 && j != i) {
                        System.out.println("Es divisible por " + j);
                    } else if (j == 1) {
                        System.out.println("Por 1");
                    } else {
                        System.out.println("Por si mismo");
                    }
                }
            }
        }

	}

}
