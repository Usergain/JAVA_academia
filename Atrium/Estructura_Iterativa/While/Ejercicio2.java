package While;

public class Ejercicio2 {
	
	//Calcular la potencia de 2 elevado a 8

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int exp = 1;
		int cont = 0;
		
		while (cont != 8) {
			exp = exp * 2;
			cont = cont + 1;
		}
		System.out.println(exp);

	}

}
