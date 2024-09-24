import java.util.ArrayDeque;

public class ColasPilas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayDeque<String> cola = new ArrayDeque<String>();
		// Agrega valores al final de la cola
		cola.add("A");
		cola.add("L");
		cola.add("E");
		cola.add("X");

		// Devuelve el siguiente elemento de la cola SIN EXTRAERLO.
		System.out.println("Siguiente elemento a extraer: " + cola.peek());

		// Extrae secuencualmente los valores de la cola
		while (cola.size() > 0) {
			System.out.println("Extrae elemento: " + cola.poll());
		}
		
		ArrayDeque<String> pila = new ArrayDeque<String>(); 
		 // Agrega valores al final de la cola
		 pila.push("A"); 
		 pila.push("L"); 
		 pila.push("E"); 
		 pila.push("X"); 
		 
		 // Devuelve el siguiente elemento de la pila SIN EXTRAERLO
		 System.out.println( "Siguiente elemento a extraer: " + pila.peek()); 
		 
		 // Extrae secuencialmente los valores de la pila. 
		 while( pila.size() > 0 ) { 
		 System.out.println( "Extrae elemento: " + pila.pop()); 
		 } 
	}

}
