package ColeccionaesGenerica;

import java.util.Arrays;
import java.util.Iterator;

public class ListaEstatica<T extends java.lang.Comparable<T>>  implements Iterable<T>{
	private T[] valores;
	private int indx = 0;

	// Inicializa la lista con los valores de una matriz
	public ListaEstatica(T[] valores) {
		this.valores = Arrays.copyOf(valores, valores.length);
	}

	// Indica si un determinado valor está en la lista
	public boolean exist(T valor) {
		int pos = 0;
		boolean encontrado = false;
		while (pos < valores.length && !encontrado) {
			encontrado = (this.valores[pos].equals(valor));
			pos++;
		}
		return (encontrado);
	}
	
	public T getMaximo() {
		T max = valores[0];
		for (T valor : this.valores) {
			if (valor.compareTo(max) > 0)
				max = valor;
		}
		return max;
	}

	// Devuelve el primer valor
	public T getPrimero() {
		indx = 0;
		return valores[indx];
	}

	// Devuelve el último valor
	public T getUltimo() {
		indx = valores.length - 1;
		return valores[indx];
	}

	// Devuelve el siguiente valor
	public T getSiguiente() {
		if (indx + 1 < valores.length)
			indx++;
		return valores[indx];
	}

	// Devuelve el último valor
	public T getAnterior() {
		if (indx - 1 >= 0)
			indx--;
		return valores[indx];
	}

	@Override
	public Iterator<T> iterator() {
		// Retorno de un objeto anónimo iterador.
		return new Iterator<T>() {
			// indice de recorrido de valor para el iterador
			int indice = 0;
			@Override
			public boolean hasNext() {
				return indice < valores.length;
			}
			@Override
			public T next() {
				T obj = valores[indice]; // Retorna valor actual
				indice++; // Incrementa indice
				return obj;
			}
		};
	}
}
