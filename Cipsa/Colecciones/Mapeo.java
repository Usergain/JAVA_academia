import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Mapeo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instanciación de coleccion
		Hashtable<Integer, String> mapa = new Hashtable<Integer, String>();
		// Insercion de valores cadena empleando valores enteros como clave
		mapa.put(329309, "Roger Petrov");
		mapa.put(423449, "Ivan Gregroriev");
		mapa.put(343559, "Yuri Demidovich");
		mapa.put(756756, "Pavel Piskunov");
		mapa.put(347899, "Andrei Stepanovich");
		// Existe algun trabajador con código: 756756?
		if (mapa.containsKey(756756)) {
			System.out.println("El trabajador nº756756 es : " + mapa.get(756756));
		} else {
			System.out.println("No existe el trabajador nº756756");
		}
		
		System.out.println("");
		
		// Existe el trabajador "Pavel Piskunov"
		if (mapa.containsValue("Pavel Piskunov")) {
			System.out.println("El trabajados está registrado.");
		} else {
			System.out.println("El trabajador no está registrado.");
		}
		
		System.out.println("");
		
		// Obtencion conjunto de claves almacenadas
		java.util.Set<Integer> claves = mapa.keySet();
		// Bucle recorrido de claves
		System.out.println("Claves del mapa: ");
		for (Integer clave : claves) {
			System.out.println(clave);
		}
		
		System.out.println("");
		
		// Obtencion coleccion de valores almacenados
		java.util.Collection<String> valores = mapa.values();
		// Bucle de recorrido de valores.
		System.out.println("Valores del mapa:");
		for (String valor : valores) {
			System.out.println(valor);
		}
		
		System.out.println("");
		
		Set<Map.Entry<Integer, String>> conjunto = mapa.entrySet(); 
		for( Map.Entry<Integer, String> entrada : conjunto ) {
		 System.out.println( "CLAVE: " + entrada.getKey() + " -> VALOR: " + 
		entrada.getValue() ); 
		} 
	}

}
