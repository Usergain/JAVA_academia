// Crea una función que dada una matriz de valores y un determinado valor sustituya todas las apariciones 
//de dicho valor por 0 y retorna la cantidad de sustituciones realizadas.

import java.util.Arrays;

public class Ejer14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[]r;
				int[]m=new int[]{5,-9,10,8,6,11,8,0};
				System.out.println(Arrays.toString(m));
				
				r=aparicion(m,8);
				System.out.println(Arrays.toString(r));
			}
			
			/*static void aparicion(int[]matriz, int numero){
				int sustitucion=0;
				int contador=0;
				for (int i = 0; i < matriz.length; i++) {
					if(matriz[i]==numero){
						matriz[i]=sustitucion;
						contador++;
					}
				}
				System.out.println(Arrays.toString(matriz));
				System.out.println(" El numero de veces que se ha sustituido el numero es:" + contador);
			}*/
			
			static int[]aparicion(int[]matriz, int numero){
				int sustitucion=0;
				int contador=0;
				for (int i = 0; i < matriz.length; i++) {
					if(matriz[i]==numero){
						matriz[i]=sustitucion;
						contador++;
				}
			}
			return matriz;

	}

}
