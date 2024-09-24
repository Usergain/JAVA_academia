import java.util.ArrayList;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = new Integer[10];
		ArrayList lista = new ArrayList();

		for (int i = 0; i < 10; i++) {
			array[i] = new Integer(i);
			lista.add(i, new Integer(i));
		}

		for (int i = 0; i < 10; i++) {
			System.out.print("Array: " + array[i]);
			System.out.println(" Lista: " + lista.get(i));
		}
	}

}
