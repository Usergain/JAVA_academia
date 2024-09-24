import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Conjunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// orden en que metiste y valores no repetidos
		LinkedHashSet<String> conjunto = new LinkedHashSet<String>();
		conjunto.add("A");
		conjunto.add("L");
		conjunto.add("E");
		conjunto.add("X");
		// Obtención del iterador
		Iterator<String> objIterador = conjunto.iterator();
		// Recorrido
		while (objIterador.hasNext()) {
			System.out.println(objIterador.next());
		}
		
		//---------------------------------------------------------------------------------------
		
		System.out.println(" ");
		// valores no repetidos, ni orden
		HashSet<String> conjunto2 = new HashSet<String>();
		conjunto2.add("A");
		conjunto2.add("L");
		conjunto2.add("E");
		conjunto2.add("X");
		// Obtención del iterador
		Iterator<String> objIterador2 = conjunto2.iterator();
		// Recorrido
		while (objIterador2.hasNext()) {
			System.out.println(objIterador2.next());
		}
		//--------------------------------------------------------------------------------------------------------
		
		System.out.println(" ");

		//TreeSet valores se ordenan segun orden natural (String por orden primera letra, int de 0-1..)
		TreeSet<String> conjunto3= new TreeSet<String>(); 
		 conjunto3.add("ASK"); 
		 conjunto3.add("LPT"); 
		 conjunto3.add("ESE"); 
		 conjunto3.add("EAE"); 
		 conjunto3.add("RTS"); 
		 conjunto3.add("XOR"); 
		 
		 // Obtención del iterador
		 Iterator<String> objIterador3 = conjunto3.iterator(); 
		 // Recorrido
		 while( objIterador3.hasNext()) { 
		 System.out.println( objIterador3.next()); 
		 }
	}
}
