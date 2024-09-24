//•	Crea una función que dada una matriz ordene todos los valores de la matriz en sentido decreciente

import java.util.Arrays;

public class Ejer20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int[]m=new int[] {1,6,4,9,3,7};
		System.out.println(Arrays.toString(m));
		ordenDecreciente(m);
		System.out.println(Arrays.toString(m));		

	}

	static void ordenDecreciente(int[]matriz) {
		int aux;
		boolean ordenado;	
		do {
			ordenado=true;
			for (int i = 0; i < matriz.length-1; i++) {
				if(matriz[i]<matriz[i+1]) {
					aux=matriz[i+1];
					matriz[i+1]=matriz[i];
					matriz[i]=aux;
					ordenado=false;
				}
			}
		}while(ordenado==false);

	}

}
