//Crea una función que dada una matriz de valores enteros retorna otra matriz con los valores positivos 
//contenidos en la original.

import java.util.Arrays;

public class Ejer10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[]m=new int[]{5,-9,10,8,6,11,8,0};
				int[]r;
				System.out.println(Arrays.toString(m));
				r = NumerosEnteros(m);
				System.out.println(Arrays.toString(r));

			}
			
			static int[] NumerosEnteros(int[]matriz){
				int contador=0;
				for (int i = 0; i < matriz.length; i++) {
					if(matriz[i]>0){
						contador++;
					}
				}
				int[] resultado = new int[contador]; 
				int aux=0;
				for (int i = 0; i < matriz.length; i++) {
					if(matriz[i]>0){
						resultado[aux] = matriz[i]; 
						aux++; 
					}			
				}
				return resultado; 
	}

}
