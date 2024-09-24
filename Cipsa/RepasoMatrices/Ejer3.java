//Crea una función que dada una matriz de valores enteros devuelve el valor máximo

public class Ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]m=new int[]{5,-9,10,8,6,11,8,0};
		System.out.println(MaximoValor(m));
	}

	static int MaximoValor(int[]matriz){
		int maximo=0;
		for (int i : matriz) {
			if(i>maximo){
				maximo=i;
			}
		}
		return maximo;

	}

}
