import java.util.ArrayList;
import java.util.Iterator;

public class Recorrer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> coleccion = new ArrayList<String>(); 
		 coleccion.add("A"); 
		 coleccion.add("B"); 
		 coleccion.add("C"); 
		 coleccion.add("D"); 
		 coleccion.add("E"); 
		 
		 // Recorrido de valores mediante bucle FOREACH
		 for( String elemento : coleccion ) { 
		 System.out.println( elemento ); 
		 } 
		 // Recorrido de valores mediante iterador. 
		 Iterator<String> iterador = coleccion.iterator(); 
		 while ( iterador.hasNext()) { 
		 System.out.println( iterador.next()); 
		 }

	}

}
