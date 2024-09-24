//Crea una función que dada una matriz de valores enteros y un valor entero a buscar retorna un 
//valor lógico indicando si el valor indicado está o no contenido en la matriz.

public class Ejer8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]m=new int[]{5,-9,10,8,6,11,8,0};
		System.out.println(BuscarNumero(m,8));

	}

	static boolean BuscarNumero(int[]matriz,int numero){
		boolean busqueda=false;

		for (int i = 0; i < matriz.length; i++) {
			if(matriz[i]==numero){
				busqueda=true;
			}
		}
		return busqueda;

	}

}
