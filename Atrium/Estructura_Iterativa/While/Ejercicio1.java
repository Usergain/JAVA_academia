package While;

public class Ejercicio1 {
	
	//Calcular el factorial de 25

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double fact=1;
		int cont=1;
		int numero=1;
		int i=25;
		
		while(numero<=i) {
			fact = fact * i;
			System.out.println(fact);
			numero++;
			
		}
		
        System.out.println(fact);


	}

}

