//Crea una función que dada una matriz de valores enteros una posición y una longitud retorna una matriz 
//de valores con la cantidad de valores indicados de la matriz de origen a partir de la posición indicada.
import java.util.Arrays;

public class Ejer11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[]m=new int[]{5,-9,10,8,6,11,8,0};
				int[]r;
				System.out.println(Arrays.toString(m));
				r=MatrizRedefinida(m,10);
				System.out.println(Arrays.toString(r));

			}
			
			static int[] MatrizRedefinida(int[]matriz,int numero){
				int index=0;
				for (int i = 0; i < matriz.length; i++) {
					if(matriz[i]==numero){
						index=i;
						for (int j = index; j < matriz.length; j++) {
							matriz[index]=matriz[j];
						}
					}
				}
				return matriz; //Hay que cambiarlo a matriz resultado para no manipular la matriz original
	}

}
