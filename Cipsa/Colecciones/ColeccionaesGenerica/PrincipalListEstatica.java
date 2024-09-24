package ColeccionaesGenerica;

public class PrincipalListEstatica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] valores = { "Pedro", "Luis", "Ivan", "Juan" };
		ListaEstatica<String> lista = new ListaEstatica<String>(valores);
		// Devuelve el primer valor almacenado
		System.out.println(lista.getPrimero());
		// Devuevle el siguiente valor almacenado ( el Segundo )
		System.out.println(lista.getSiguiente());
		// Devuelve el ultimo valor almacenado
		System.out.println(lista.getUltimo());
		// Devuevle el valor anterior almacenado.
		System.out.println(lista.getAnterior());

		if (lista.exist("Luis")) {
			System.out.println("El valor Luis está almacenado");
		} else {
			System.out.println("Valor no existente");
		}

		Integer[] valores2 = { 2, 6, 1, 7, 4, 2, 8, 4 };
		ListaEstatica<Integer> lista2 = new ListaEstatica<Integer>(valores2);
		System.out.println(lista2.getPrimero());
		System.out.println(lista2.getSiguiente());
		System.out.println(lista2.getUltimo());
		System.out.println(lista2.getAnterior());

		if (lista2.exist(5)) {
			System.out.println("El valor Luis está almacenado");
		} else {
			System.out.println("Valor no existente");
		}
		
		System.out.println("");

		// Instanciacion de ListaEstatica<Integer> con valores dados.
		ListaEstatica<Integer> lista3 = new ListaEstatica<Integer>(new Integer[] { 10, 40, 30, 20 });
		// Obtencion del valor máximo
		Integer valor_maximo = lista3.getMaximo();
		System.out.println("El valor máximo es: " + valor_maximo);
		// Recorrido de los valores almacenados.
		for (Integer valor : lista3)
			System.out.println(valor);
	}

}


