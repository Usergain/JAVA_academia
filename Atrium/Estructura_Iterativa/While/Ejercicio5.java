package While;

public class Ejercicio5 {
	
	/*Un numero es perfecto cuando todos sus divisores sumados dan el mismo numero Ejemplo: 6 = 1 + 2 + 3; luego 6 es un numero perfecto
	Mostrar los números perfectos hasta el 100*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int suma = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    suma = suma + j;
                }
            }
            if (i == suma) {
                System.out.println("Numero perfecto: " + i);
            }
            suma = 0;
        }

	}

}
