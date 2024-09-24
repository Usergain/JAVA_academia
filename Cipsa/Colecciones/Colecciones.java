import java.util.Collections;
import java.util.Vector;

public class Colecciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> valores = new Vector<String>();
		Collections.addAll(valores, "pedro", "luis", "manuel", "andres", "juan");
		System.out.println(valores.toString());

		System.out.println("");

		// Declaracion coleccion origen
		Vector<String> origen = new Vector<String>();
		Collections.addAll(origen, "pedro", "luis", "manuel", "andres", "juan");
		// Declaracion coleccion destino
		Vector<String> destino = new Vector<String>();
		// Ajuste del tamaño de la coleccion destino.
		destino.setSize(origen.size());
		// Copia de valores.
		Collections.copy(destino, origen);
		// Visualizacion de valores en lista_destino
		System.out.println(destino.toString());

		System.out.println("");

		Vector<Integer> lista = new Vector<Integer>();
		Collections.addAll(lista, 2, 3, 6, 2, 1, 5, 7, 2, 3);
		// Visualizacion de valores originales
		System.out.println("Lista original.");
		System.out.println(lista.toString());
		// Inversión de orden de valores en lista
		Collections.reverse(lista);
		System.out.println("Inversion de los valores.");
		System.out.println(lista.toString());
		// Reemplazo de valores en lista 2 -> 20.
		Collections.replaceAll(lista, 2, 20);
		System.out.println("Reemplaza todos los valores 2 por 20.");
		System.out.println(lista.toString());
		// El valor más gande
		System.out.println("El valor mayor");
		System.out.println(Collections.max(lista));
		// El valor más pequeño
		System.out.println("El valor menor");
		System.out.println(Collections.min(lista));
	}

}
