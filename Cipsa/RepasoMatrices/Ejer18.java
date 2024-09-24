//•	Crea una función que dada una matriz y un valor modifique todos los valores de la matriz multiplicándolos por el valor indicado. 
public class Ejer18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[]m=new int[] {1,6,4,9,3,7};
				int n=2;
				
		        System.out.println("ANTES: ");
		        mostrar(m);
		        modificaMatriz(m,n);
		        
		        System.out.println("DESPUES: ");
		        mostrar(m);

			}
			
			static void modificaMatriz(int[]matriz,int numero) {
		        for (int i = 0; i < matriz.length; i++) {
		        matriz[i] *= numero; 
		        }
		    }
		    
		    static void mostrar( int[] matriz ) {
		        for( int i = 0; i < matriz.length; i++) {
		                System.out.println(String.format("m[%d] -> %d", i, matriz[i]));
		        }

	}

}
