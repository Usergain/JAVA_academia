//•	Crea una función que dada una matriz ordene todos los valores de la matriz en sentido creciente

import java.util.Arrays;

public class Ejer19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[]m=new int[] {1,6,4,9,3,7};
				System.out.println(Arrays.toString(m));
				ordenar(m);
				System.out.println(Arrays.toString(m));		

			}
			
			static void ordenar( int[] array ){
				int aux=0;
				boolean ordenado; 
				do {
					ordenado = true; 
					for(int indice=0;indice < array.length-1;indice++ ){
						if(array[indice]>array[indice+1]){
							aux=array[indice];
							array[indice] = array[indice+1]; 
							array[indice+1]=aux;
							ordenado = false; //lo volvemos a reiniciar a false para poder recorrer otra vez el bucle for
											 // cuando el length sea superior ya no entrará y ordenado=true
						}
					}
				} while ( ordenado == false ); 

	}

}
