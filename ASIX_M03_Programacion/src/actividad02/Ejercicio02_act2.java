package actividad02;



public class Ejercicio02_act2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[][] memoria = { { 8.1, 3.2, 9.8}, { 5.4, 8.5, 7.3}, { 10, 9.6, 6.2}, { 4.7, 7.2, 8.8} };
		int opcion;
		double ac;
		System.out.println(" *********** RESULTADOS ESTADISTICOS ***************");
		System.out.println("Los valores introducidos en la memoria son:");
		imprimirArray(memoria);
		System.out.println("Todas las puntuaciones indicadas por el primer experto:");
		imprimirArrayExpertoPrimero(memoria);
		System.out.println("La media obtenida por la segunda canción");
		System.out.println(MediaValoresSegundaCancion(memoria)); 
		System.out.println("El peor valor de la tercera canción:");
		System.out.println(MenorValor(memoria));
	}
	
	// Funciones :

	static void imprimirArray(double[][] memoria) {
		
		for(int i=0;i<4;i++)// filas
		 {
			System.out.print("[ ");
			 for (int j=0;j<3;j++) //columnas
			 {
				
					System.out.print(memoria[i][j]+" ");
			 }
			 System.out.println("]");
		 }
	}
	
	static void imprimirArrayExpertoPrimero(double[][] memoria) {

		for (int i = 0; i < 1; i++)// filas
		{
			System.out.print("[ ");
			for (int j = 0; j < 3; j++) // columnas
			{

				System.out.print(memoria[i][j] + " ");
			}
			System.out.println("]");
		}
	}
	
	static double MediaValoresSegundaCancion(double[][] memoria) {
		double mediaNotas=0;
		for(int i=0;i<4;i++)// filas
		 {
			 for (int j=1;j<2;j++) //columnas
			 {
				mediaNotas += memoria[i][j];
			 }
			 
		 }
		mediaNotas = mediaNotas /4 ;
		
		return mediaNotas;
	}

	static double MenorValor(double[][] memoria) {
	
		double menor = memoria[0][2];
		for (int i = 0; i < 4; i++) {
			
			for (int j = 2; j < 3; j++) {

				if (memoria[i][j] < menor) {
					menor = memoria[i][j];
				}
			}

		}
		return menor;
	}
	
}


