
public class Ejer_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     int[][] matriz1 = new int[][]{{1, 2}, {0, 5}};
	        int[][] matriz2 = new int[][]{{3, 4}, {5, 8}};

	        int[][] resultado = new int[2][2];

	        for (int fila= 0; fila<matriz1.length; fila++){
	            for (int columna = 0; columna < matriz1[fila].length; columna++){
	                resultado[fila][columna] = matriz1[fila][columna] + matriz2[fila][columna];
	            }
	        }

	        for (int [] fila : resultado){
	            for (int dato : fila){
	                System.out.print(dato + " ");
	            }
	            System.out.println("");
	        }

	}

}
