import java.util.ArrayList;
import java.util.Arrays;

public class ArraylistDinamico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] valores = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		ArrayList<Integer> lista = new ArrayList<Integer>(Arrays.asList(valores));

		System.out.println(lista);

		lista.add(2);
		lista.add(4);
		lista.add(6);
		lista.add(1);
		lista.add(2);
		lista.add(4);
		lista.add(5);

		System.out.println(lista);

		lista.set(0, 500);

		System.out.println(lista);

		// recorre bucle for
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("lista[" + i + "] = " + lista.get(i));
		}

		// recorrer bucle foreach
		for (Integer integer : lista) {
			System.out.println(integer);
		}

		Integer[] matriz = new Integer[lista.size()];
		// Relleno de la matriz con los valores de la lista
		matriz = lista.toArray(matriz);
		// Visualizacion de los valores de la matriz
		System.out.println(Arrays.toString(matriz));

		System.out.println(matriz);

		// ------------------------------------------------------------------------------------------------------

		String[] datos = { "Roger", "Yuri", "Ivan", "Artyon", "Ivan" };
		ArrayList<String> lista2 = new ArrayList<String>(Arrays.asList(datos));

		System.out.println("Lista original:");
		for (int indx = 0; indx < lista2.size(); indx++) {
			System.out.println("[" + indx + "] ->" + lista2.get(indx));
		}
		// Eliminacion del valor "Ivan"
		if (lista2.remove("Ivan"))
			System.out.println("El valor Ivan fue eliminado.");
		else
			System.out.println("No se encontró el valor a eliminar");

		System.out.println("Lista resultante:");
		for (int indx = 0; indx < lista2.size(); indx++) {
			System.out.println("[" + indx + "] ->" + lista2.get(indx));
		}
//------------------------------------------------------------------------------------------------------------------
		String[] datos2 = { "Roger", "Yuri", "Ivan", "Artyon", "Ivan" };
		ArrayList<String> lista3 = new ArrayList<String>(Arrays.asList(datos2));

		System.out.println("Lista original:");
		for (int indx = 0; indx < lista3.size(); indx++) {
			System.out.println("[" + indx + "] ->" + lista3.get(indx));
		}
		// Eliminacion de todas las apariciones de los valores "Ivan" y "Roger"
		lista3.removeAll(Arrays.asList(new String[] { "Ivan", "Roger" }));

		System.out.println("Lista resultante:");
		for (int indx = 0; indx < lista3.size(); indx++) {
			System.out.println("[" + indx + "] ->" + lista3.get(indx));
		}
		// ----------------------------------------------------------------------------------------------------------------
		String[] datos3 = { "Roger", "Yuri", "Ivan", "Artyon", "Ivan" };
		ArrayList<String> lista4 = new ArrayList<String>(Arrays.asList(datos3));

		System.out.println("Lista original:");
		for (int indx = 0; indx < lista4.size(); indx++) {
			System.out.println("[" + indx + "] ->" + lista4.get(indx));
		}
		// Eliminación del primer valor
		System.out.println("El primer nombre era: " + lista4.remove(0));
		// Eliminacion del ultimo valor
		System.out.println("El último nombre era: " + lista4.remove(lista4.size() - 1));

		System.out.println("Lista resultante:");
		for (int indx = 0; indx < lista4.size(); indx++) {
			System.out.println("[" + indx + "] ->" + lista4.get(indx));
		}
//-------------------------------------------------------------------------------------------------------------------		
		lista4.clear();

		for (int indx = 0; indx < lista4.size(); indx++) {
			System.out.println("[" + indx + "] ->" + lista4.get(indx));
		}
//--------------------------------------------------------------------------------------------------------------------
		
		String[] datos4 = { "Lucas", "Lucy", "Kevin", "Ivan", "Jhonny", "Alex", "Jhonny", "Michael" };
		ArrayList<String> lista5 = new ArrayList<String>(Arrays.asList(datos4));
		// Busqueda de la primera aparicion
		int primera_posicion = lista5.indexOf("Jhonny");
		// Búsqueda de la última aparicion
		int ultima_posicion = lista5.lastIndexOf("Jhonny");
		System.out.println("Primera aparicion de 'Jhonny' en indx: " + primera_posicion);
		System.out.println("Última aparicion de 'Jhonny' en indx: " + ultima_posicion);
		// Comprobacion de existencia de valor en la lista
		if (lista5.contains("Lucas"))
			System.out.println("Lucas está contenido en la lista");
		else
			System.out.println("Lucas no está contenido en la lista"); 	
		
	}

}
