//Crea una funci�n que dada una matriz de valores enteros devuelva la posici�n del valor m�nimo.

public class Ejer4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]m=new int[]{5,-9,10,8,6,11,8,0};
		int indx_minimo = ValorMinimo(m); 
		int valor_minimo = m[indx_minimo]; 
		
		System.out.println("Posicion: " + indx_minimo + " esta el valor " + valor_minimo);

	}
	
	static int ValorMinimo(int[]matriz){
		int index=0;
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[i] < matriz[index]){
				index = i; 
			}
		}
		return index;
		
	}

}
