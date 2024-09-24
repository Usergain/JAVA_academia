// Crea una función que dada una matriz de enteros retorna la cantidad de valores positivos

public class Ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int m[]=new int[]{-5,5,-1,0,8,-7,-10};
		System.out.println(ValoresEnteros(m));

	}

	static int ValoresEnteros(int matriz[]){
		int positivos = 0;
		for (int i : matriz) {
			if(i>=0){
				positivos++;
			}
		}
		return positivos;

	}

}
