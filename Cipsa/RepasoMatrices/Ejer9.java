import java.util.Arrays;

//Crea una función que dada una matriz de valores enteros y un valor entero a buscar retorne la
//posición en la que se encuentra dicho valor o -1 si no está presente. 

public class Ejer9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Por el metodo indexOf, con este método de la clase String te devolvería -1 si no encuentra el 
		valor a buscar
		/*
		 * 
		 */
		Integer[] z = {5,-9,10,8,6,11,8,0};
		int getIndex = Arrays.asList(z).indexOf(8);
		System.out.println("8 esta en la posicion "+getIndex+" index");
		
		
		int[]m=new int[]{5,-9,10,8,6,11,8,0};
		
		System.out.println(BuscarNumero2(m,5));
		
		System.out.println(BuscarNumero(m,6));

		}
		
		static int BuscarNumero(int[]matriz,int numero){
			int index=-1;
			for (int i = 0; i < matriz.length && index == -1; i++) {
				if(matriz[i]==numero){
					index=i;
				}
			}
			return index;
		}
		//con la manera de while 
		
		static int BuscarNumero2(int[]matriz,int numero){
			int index=-1;
			int i = 0; 
			while( i < matriz.length && index == -1 ) {
				if(matriz[i]==numero){
					index=i;
				} else {
					i++;
				}
			}
			return index;

	}

}
