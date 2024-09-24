// Crea una función que dada una matriz de valores enteros devuelva la media

public class Ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int[]m=new int[]{5,-9,10,8,6,11,8,0};
		System.out.println(MediaMatriz(m));

	}

	static float MediaMatriz(int[]matriz){
		float media=0;
		int contador=0;
		int suma=0;

		for (int i = 0; i < matriz.length; i++) {
			contador++;
			suma+=matriz[i];
		}
		media=(float)suma/contador;
		return media;
	}

}
