// Crea una función que dada una matriz de valores enteros retorne otra matriz con los valores de la matriz original sin duplicados. 

import java.util.Arrays;

public class Ejer22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int[]m=new int[]{5,1,1,9,8,7,8,10};
		System.out.println(length_no_dupl(m));
		int[]r = noDuplicado( m );
		System.out.println(Arrays.toString(m));
		System.out.println(Arrays.toString(r));
	}

	/**
	 * Devuelve una matriz sin duplicados.
	 * @param matriz Matriz de origen
	 * @return Matriz de destino
	 */
	static int[] noDuplicado(int[]matriz){ 
		int[] resultado = new int[length_no_dupl(matriz)];
		int valor; 
		int indx_origen = 0; 
		int indx_destino = 0; 
		for( indx_origen = 0; indx_origen < matriz.length; indx_origen++) {
			valor = matriz[indx_origen];
			if ( !in(resultado, valor, indx_destino )) {
				resultado[indx_destino] = valor; 
				indx_destino++; 
			}
		}
		return resultado; 
	}

	/**
	 * Devuelve el nº de valores sin duplicados presentes en una matriz
	 * @param array Matriz a examinar
	 * @return Cantidad de valores sin duplicas
	 */
	static int length_no_dupl( int[] array ) {
		int longitud = 0; 
		int valor; 
		for( int i = 0; i < array.length; i++) {
			valor = array[i];
			if ( !in( array, valor, i))
				longitud++; 
		}
		return longitud; 
	}

	/**
	 * Retorna un valor lógico indicando si el valor dado está contenido en la matriz en la seccion comprendida por los primeros valores indicados
	 * @param array Matriz a examinar
	 * @param value Valor a buscar
	 * @param count Longitud de la seccion a comprobar
	 * @return TRUE si el valor está contenido FALSE si no.
	 */
	static boolean in( int[] array, int value, int count ) {
		for( int i = 0; i < count; i++) {
			if ( array[i] == value) 
				return true; 
		}
		return false; 
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int foo( int a, int b ) {
		return 0;

	}

}
