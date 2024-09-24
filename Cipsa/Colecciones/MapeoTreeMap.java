import java.util.Map;
import java.util.TreeMap;

public class MapeoTreeMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer, String> mapa = new TreeMap<Integer, String>(); 
		 // Insercion de valores cadena empleando valores enteros como clave
		 mapa.put(329309, "Roger Petrov"); 
		 mapa.put(423449, "Ivan Gregroriev"); 
		 mapa.put(343559, "Yuri Demidovich"); 
		 mapa.put(756756, "Pavel Piskunov"); 
		 mapa.put(347899, "Andrei Stepanovich"); 
		 // Recorrido y visualización de valores restantes
		 java.util.Set<Map.Entry<Integer, String>> conjunto = mapa.entrySet(); 
		 for( Map.Entry<Integer, String> entrada : conjunto ) {
		 System.out.println( "CLAVE: " + entrada.getKey() + " -> VALOR: " 
		 + entrada.getValue() ); 
		 }
	}

}
