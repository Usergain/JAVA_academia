
public class Ejer17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[]m=new int[] {1,6,4,9,3,7};
				
				System.out.println("Los valores de la matriz invertida son : " );
				
				invertirMatriz(m);

			}
			
			static void invertirMatriz(int[]matriz) {
				for (int i = matriz.length-1; i >=0; i--) {
					System.out.print(matriz[i] + " ");
				}
				System.out.println();

	}

}
