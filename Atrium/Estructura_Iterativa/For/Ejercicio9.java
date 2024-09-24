package For;

public class Ejercicio9 {
	
	//Hallar la lista de los números primos hasta el 100

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cont;
        cont = 0;
	        for (int i = 1; i <= 100; i = i + 1) {
	            for (int j = 2; j <= (i - 1); j = j + 1) {
	                if (i % j == 0) {
	                    cont = 1;
	                }
	
	            }
	            if (cont == 0) {
	                System.out.println(i);
	            }
	            cont = 0;
	        }
		
	}

}
