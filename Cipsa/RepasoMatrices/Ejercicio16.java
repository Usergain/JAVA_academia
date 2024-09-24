import java.util.Arrays;
//Crea una función que dada una matriz devuelva otra con todos los valores de la matriz original invertidos. 

public class Ejercicio16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[]m=new int[]{5,-9,10,8,6,11,8,0};
				int[]r;
				r=matrizInvertida2(m);
				System.out.println(Arrays.toString(m));
				System.out.println(Arrays.toString(r));
			}
						
			static int[] matrizInvertida2(int[]matriz){
				int[]resultado=new int[matriz.length];
				int r = 1; 
				for (int i = 0; i < resultado.length; i++) {
					/*System.out.println("Posicion leida: " + (matriz.length - r));
					System.out.println("Posicion escrita: " + i );*/
					resultado[i] = matriz[matriz.length - r]; 
					r++;
				}
				return resultado;

	}

}
