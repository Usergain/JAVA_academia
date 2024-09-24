//Crea una función que dada una matriz de valores enteros devuelva el sumatorio de los valores pares

public class Ejer6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]m=new int[]{5,-9,10,8,6,11,8,0};
		System.out.println(ValoresPares(m));

	}

	static int ValoresPares(int[]matriz){
		int suma=0;

		for (int i = 0; i < matriz.length; i++) {
			if(matriz[i]%2==0){
				suma+=matriz[i];
			}
		}
		return suma;

	}

}
