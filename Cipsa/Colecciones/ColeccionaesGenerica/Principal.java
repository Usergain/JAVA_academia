package ColeccionaesGenerica;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instanciaci�n de una lista gen�rica para almacenar objetos Punto
		ArrayList<Punto> objLista = new ArrayList<Punto>();

		// Agregado de objetos Punto
		objLista.add(new Punto(2, 3));
		objLista.add(new Punto(1, 2));

		// Obtenci�n de objeto Punto almacenado en la posici�n 0.
		Punto p = objLista.get(0);
		System.out.println(p.x + "," + p.y);
		
		// Instanciaci�n de una lista gen�rica para almacenar objetos Punto
		 ArrayList<Punto> objLista2 = new ArrayList<Punto>(); 
		 
		 // Agregado de objetos Punto
		 objLista2.add(new Punto(2,3)); 
		 objLista2.add(new Punto(1,2)); 
		 
		 // Obtenci�n de objeto Punto almacenado en la posici�n 0.
		 Punto p2 = objLista.get(0); 
		 System.out.println( p2.x + "," + p2.y );

	}

}
