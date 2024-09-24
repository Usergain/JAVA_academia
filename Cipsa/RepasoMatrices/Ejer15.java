// Crea una función que dada una matriz de valores y dos valores dados sustituya todas las apariciones
// del primer valor indicado por el segundo y retorna el nº de sustituciones realizadas.

import java.util.Arrays;

public class Ejer15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[]s;
				int[]m=new int[]{5,-9,10,8,6,11,8,0};
				
				System.out.println(Arrays.toString(m));
				
				s=sustitucion(m,8,40);	
				System.out.println(Arrays.toString(s));
				

			}
			static int[] sustitucion(int[]matriz,int numero1, int numero2){
				int[]resultado=new int[matriz.length];
				resultado=matriz;
				for (int i = 0; i < matriz.length; i++) { 
					if(matriz[i]==numero1){
						resultado[i]=numero2;
					}
				}
				return resultado;

	}

}
