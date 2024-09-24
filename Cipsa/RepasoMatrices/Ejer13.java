//Crea una función que dada una matriz de valores sustituya por 0 todos los valores negativos

import java.util.Arrays;

public class Ejer13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[]m=new int[]{5,-9,10,8,6,11,8,0};
				System.out.println(Arrays.toString(m));
				
				sustitucion(m);
				System.out.println(Arrays.toString(m));

			}
			
			static void sustitucion(int[]matriz){
				for (int i = 0; i < matriz.length; i++) {
					if(matriz[i]<0){
						matriz[i]=0;
					}
				}

	}

}
