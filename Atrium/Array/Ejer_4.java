
public class Ejer_4 {

	public static void main(String[] args) {

		int[] array1 = new int[]{1, 2, 3, 4, 5};
		int[] array2 = new int[]{334, 23, 4};

		int[] array3 = new int[array1.length + array2.length];

		int posicionArray3 = 0;

		for(int i = 0; i< array1.length; i++){
			array3[posicionArray3] = array1[i];
			posicionArray3++;
		}

		for(int i = 0; i< array2.length; i++){
			array3[posicionArray3] = array2[i];
			posicionArray3++;
		}

		for(int dato : array3){
			System.out.print(dato + " ");
		}
		System.out.println("");

	}

}
