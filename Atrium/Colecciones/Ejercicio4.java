
import java.util.HashMap;

public class Ejercicio4 {

	public static void main(String[] args) {

		HashMap<String, Integer> notas = new HashMap<String, Integer>();

		notas.put("Juan", 5);
		notas.put("Luis", 6);
		notas.put("David", 9);
		notas.put("José", 7);
		notas.put("Alejandro", 5);
		notas.put("Javier", 7);

		System.out.print("David tiene un ");
		System.out.println(notas.get(new String("David")));
	}

}
