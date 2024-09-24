package DoWhile;

public class Ejercicio3 {
	
	//Calcular la suma de los números pares comprendidos entre 10 y 50

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int suma = 0;
        int n = 10;
        do {
            if (n % 2 == 0) {
                suma = suma + n;
            }
            n = n + 1;
        } while (n <= 50);
        System.out.println(suma);

	}

}
