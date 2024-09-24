import java.util.Arrays;

//Crea una función que dada una matriz de valore y dos posiciones, retorna otra matriz con los contenidos 
//entre ambas posiciones en la matriz de origen (la primera posición incluida y la última excluida)
public class Ejer12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[]m=new int[] {1,6,4,9,3,7};
				int[]r;
				int indxInicio=m[2];
				int indxFin=m[5];
				
				System.out.println(Arrays.toString(m));
				
				r=extraer(m,indxInicio,indxFin);
				System.out.println(Arrays.toString(r));

			}
			
			static int[] extraer(int[]matriz,int indxInicio,int indxFin){
				for (int i = 0; i < matriz.length; i++) {
					if(i==indxInicio && i!=indxFin){
						while(i==indxFin){	
							//Hay falta asiganr los nuevos valores de las matrices
							matriz[i]=i;
						}
					}
				}
				return matriz; //retornar la matriz resultado para no manipular la matriz inicial
	}

}
