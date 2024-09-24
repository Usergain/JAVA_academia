//•	Crea una función que dada una matriz retorna otra matriz con los valores de la matriz original pero ordenados

import java.util.Arrays;

public class Ejer21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int[]m=new int[] {1,6,4,9,3,7};
		int[]r;
		System.out.println(Arrays.toString(m));
		r=ordenar(m);
		System.out.println(Arrays.toString(r));

		System.out.println(Arrays.toString(m));
	}

	static int[]ordenar(int[]array){
		int[]copia=Arrays.copyOf(array, array.length); //copia de la matriz original. Ordeno copia dejando la matriz original sin tocar.
		int aux=0;
		boolean ordenado; 
		do {
			ordenado = true; 
			for(int indice=0;indice < copia.length-1;indice++ ){
				if(copia[indice]>copia[indice+1]){
					aux=copia[indice];
					copia[indice] = copia[indice+1]; 
					copia[indice+1]=aux;
					ordenado = false; 
				}
			}
		} while ( ordenado == false ); 

		return copia;

	}

}
