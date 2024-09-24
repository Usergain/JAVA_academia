package ExpresionesLambda_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona[] datos = { new Persona("Roger", 20, 1.95f), new Persona("Victor", 24, 1.68f),
				new Persona("Patrov", 17, 1.74f), new Persona("Simon", 16, 1.84f), new Persona("Anna", 18, 1.92f) };

		ArrayList<Persona> datos1 = new ArrayList<>();
		datos1.add(new Persona("Roger", 20, 1.95f));
		datos1.add(new Persona("Victor", 24, 1.68f));
		datos1.add(new Persona("Patrov", 17, 1.74f));
		datos1.add(new Persona("Simon", 16, 1.84f));
		datos1.add(new Persona("Anna", 18, 1.92f));
		datos1.add(new Persona("Anna", 18, 1.92f));

		// Filtrado -> Obtención de las personas edad >= 18
		ArrayList<Persona> mayores = new ArrayList<Persona>();
		for (Persona p : datos)
			if (p.edad >= 18)
				mayores.add(p);
		// Ordenado -> Ordenado de los objetos filtrados por la altura
		Collections.sort(mayores, (p1, p2) -> Float.compare(p1.altura, p2.altura));
		ArrayList<Float> alturas = new ArrayList<Float>();
		// Mapeo -> Obtencion de las alturas de los objetos filtradas.
		for (Persona p : mayores)
			alturas.add(p.altura);
		// Visualizacion de la coleccion de resultados.
		System.out.println(alturas.toString());

//-------------------------------------------------------------------------------	
		// Obtencion de un stream a partir de una matriz.
		Stream<Persona> steam = Arrays.stream(datos);

//-------------------------------------------------------------------------------
		// Obtencion de un stream a partir de una coleccion .
		Stream<Persona> stream1 = datos1.stream();

//---------------------------------------------------------------------------------
		// Obtencion Stream a partir de una secuencia de valores dada.
		Stream<Persona> stream2 = Stream.of(new Persona("Roger", 20, 1.95f), new Persona("Victor", 24, 1.68f),
				new Persona("Patrov", 17, 1.74f), new Persona("Simon", 16, 1.84f), new Persona("Anna", 18, 1.92f));
//-----------------------------------------------------------------------------------
		System.out.println("");

//------------------------------------ FILTRADO (FILTER) -------------------------------------------------------------

		// Filtrado y obtención de colección de resultados
		List<Persona> resultados = datos1.stream().filter(p -> p.edad >= 20).collect(Collectors.toList());
		// Visualizacion de los objetos Persona filtrados.
		System.out.println(resultados.toString());

		System.out.println("");

		// Filtrado, mapeo y obtención de colección de resultados
		List<String> resultados2 = datos1.stream().filter(p -> p.edad >= 20).map(p -> p.nombre)
				.collect(Collectors.toList());
		// Visualizacion
		System.out.println(resultados2.toString());

		System.out.println("");

//------------------------ STREAM Y METODOS DE ORDENACION (SORT) -------------------------------------------------------

		// Reordenado y coleccion de nombres
		List<String> resultados3 = datos1.stream().map(p -> p.nombre).sorted().collect(Collectors.toList());
		// Visualizacion
		System.out.println(resultados3.toString());

		System.out.println("");

		// Reordenado y coleccion de nombres
		List<Persona> resultados4 = datos1.stream().sorted().collect(Collectors.toList());
		// Visualizacion
		System.out.println(resultados4.toString());

		System.out.println("");

		List<Persona> resultados5 = datos1.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(resultados5.toString());

		List<Persona> resultados6 = datos1.stream().sorted((a, b) -> Float.compare(a.altura, b.altura))
				.collect(Collectors.toList());
		// Visualizacion
		System.out.println(resultados6.toString());

//--------------------------------- OPERACIONES INTERMEDIAS --------------------------------------------------------------

		// Lista de valores origen
		List<Integer> valores = Arrays.asList(11, 25, 32, 39, 5, 11, 25, 35, 20);
		// Lista de valores sin repeticiones
		List<Integer> resultados7 = valores.stream().distinct().collect(Collectors.toList());
		System.out.println(resultados7);

		System.out.println("");

		// Reordenado y coleccion de nombres --> Habrá queredefinir los métodos equals()
		// y hashCode()
		List<Persona> resultados8 = datos1.stream().distinct().collect(Collectors.toList());
		System.out.println(resultados8);

//--------------------------------------- OPERACIONES FINALES BASICAS ------------------------------------------------------------
		List<Integer> origen = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> resultado9 = origen.stream().map(v -> v * v).collect(Collectors.toList());
		System.out.println(resultado9);

		System.out.println("");
//------------------------------------------------ REDUCCION ------------------------------------------------------------------
		Optional<Persona> resultado10 = datos1.stream().reduce((a, b) -> (a.edad > b.edad) ? a : b);
		if (resultado10.isPresent())
			System.out.println(resultado10.get());
		else
			System.out.println("No hay nadie.");

		System.out.println("");

		List<Integer> valores2 = Arrays.asList(10, 20, 30, 40, 50);
		int sumatorio = valores2.stream().reduce(0, (acc, valor) -> acc + valor);
		System.out.println(sumatorio);
		
		System.out.println("");

		// ------------------------------------------- CONSUMO FOREACH ---------------------------------------------------------
		// Reordenado y consumo de datos.
		datos1.stream().sorted((p1, p2) -> Float.compare(p1.altura, p2.altura)).forEach(p -> {
			System.out.println(String.format("%s\t\t\t%d\t%.2f", p.nombre, p.edad, p.altura));
		});
		
		System.out.println("");
		
		//--------------------------------------- OPERACIONES TERMINALES -------------------------------------------------------
		// count()
		long mayores_edad = datos1.stream().filter(p -> p.edad >= 18).count();
		System.out.println(String.format("Hay %d personas mayores de edad", mayores_edad));
		
		System.out.println("");
		
		//allMatch(), anyMatch(), noneMatch()
		
		// Comparacion a todos. 
		 boolean mayores18 = datos1.stream().allMatch(p -> p.edad >= 18); 
		 if ( mayores18 ) 
		 System.out.println("Todos son mayores de 18"); 
		 else 
		 System.out.println("Hay menores"); 
		 // Comparación a alguno
		 boolean hayMenores = datos1.stream().anyMatch(p -> p.edad < 18); 
		 if ( hayMenores ) 
		 System.out.println("Hay menores de edad"); 
		 else
		 System.out.println("No hay menores de edad"); 
		 // Comparacion a ninguno
		 boolean ningunMenor = datos1.stream().noneMatch(p -> p.edad < 18 ); 
		 if ( ningunMenor ) 
		 System.out.println("No hay ningún menor"); 
		 else 
		 System.out.println("Hay al menos un menor.");
		 
		 System.out.println("");
		 
		// findFirst()
		Optional<Persona> resultado11 = datos1.stream().filter(p -> p.nombre.equals("Anna")).findFirst();
		if (resultado11.isPresent())
			System.out.println(resultado11.get().toString());
		else
			System.out.println("No hay ninguna persona con el nombre Anna");
		
		System.out.println("");
		
		//--------------------------------------- RECOLECTORES INF. AGREGADA ------------------------------------------------------
		List<Persona> datos2 = Arrays.asList(new Persona[] { 
				 new Persona("Roger", 28, 1.95f, "A"), 
				 new Persona("Victor", 24, 1.68f, "B"), 
				 new Persona("Patrov", 25, 1.74f, "B"), 
				 new Persona("Simon", 16, 1.84f, "C"), 
				 new Persona("Anna", 18, 1.92f, "C"), 
				 new Persona("Yulius", 28, 1.95f, "A"), 
				 new Persona("Ivan", 24, 1.68f, "A"), 
				 new Persona("Peter", 25, 1.74f, "A"), 
				 new Persona("Alexei", 23, 1.84f, "B"), 
				 new Persona("Mihail", 26, 1.92f, "B"), 
				 new Persona("Artyom", 32, 1.97f, "A"), 
				 new Persona("Arthur", 35, 1.63f, "A"), 
				 new Persona("Williams", 29, 1.72f, "A"), 
				 new Persona("Eva", 21, 1.84f, "C"), 
				 new Persona("Irina", 19, 1.82f, "C"), 
				 new Persona("Tania", 25, 1.85f, "C"), 
				 new Persona("Priscila", 32, 1.65f, "B"), 
				 new Persona("Tatiana", 33, 1.34f, "B"), 
				 new Persona("Anton", 27, 1.34f, "A") 
				 }); 
		; 
		 // Obtencion del nº de personas mayores de edad. 
		 Long mayores_edad2 = datos2.stream() 
		 .filter(p -> p.edad > 18) 
		 .collect(Collectors.counting()); 
		 System.out.println("Personas mayores de 18: " + mayores_edad); 
		 
		 System.out.println("");
		 
		 // Sumatorio de edades de las personas de la categoría A
		 int sumatorio_edad = datos2.stream() 
		 .filter(p -> p.categoria.equals("A")) 
		 .collect(Collectors.summingInt(p->p.edad)); 
		 System.out.println("Sumatorio de las edades de personas de categoría A: " + sumatorio_edad); 
		 
		 System.out.println("");
		 
		 // Media de alturas de las personas de la categoría B
		 double altura_media = datos2.stream() 
		 .filter(p -> p.categoria.equals("B")) 
		 .collect(Collectors.averagingDouble(p->p.edad)); 
		 System.out.println(String.format("Altura media de la categoría B: %.2f", altura_media)); 
		 
		 System.out.println("");
		 
		 // Obtener persona de mayor edad conforme a implementación de Comparable en clase Persona
		 Optional<Persona> persona_mas_edad = datos2.stream() 
		 .collect(Collectors.maxBy(Comparator.naturalOrder())); 
		 System.out.println("Persona de mayor edad: " + persona_mas_edad.toString()); 
		 
		 System.out.println("");
		 
		 // Obtener persona de menor altura
		 Optional<Persona> persona_mas_baja = datos2.stream() 
		 .collect(Collectors.minBy((p1, p2)->Float.compare(p1.altura, p2.altura))); 
		 System.out.println("Persona mas baja: " + persona_mas_baja.toString());
		 
		 System.out.println("");
		 
		 // Mapa de objetos Persona agrupados por categoría
			Map<String, List<Persona>> agrupamiento = datos2.stream().collect(Collectors.groupingBy(p -> p.categoria));
			// Visualizacion de datos.
			agrupamiento.keySet().stream().forEach(cat -> {
				System.out.println("Categoria: " + cat);
				agrupamiento.get(cat).stream().forEach(p -> System.out.println(p));
			});
			
			// Mapa de objetos Persona agrupados por categoria mostrando la persona mayor
			// por grupo (según implementaxion del interfaz Comparable en la clase Persona
			Map<Object, Optional<Persona>> agrupamiento_edad = datos2.stream()
					.collect(Collectors.groupingBy(p -> p.categoria, Collectors.maxBy(Comparator.naturalOrder())));
			System.out.println("Agrupados por categoria mostrando persona mayor.");
			agrupamiento_edad.keySet().stream().forEach(cat -> {
				System.out.println("Categoria: " + cat);
				System.out.println(agrupamiento_edad.get(cat));
			});
			// Mapa de objetos Persona agrupados por categoria mostrando la persona mas baja
			// por grupo
			Map<Object, Optional<Persona>> agrupamiento_altura = datos2.stream().collect(Collectors
					.groupingBy(p -> p.categoria, Collectors.minBy((p1, p2) -> Float.compare(p1.altura, p2.altura))));

			System.out.println("Agrupados por categoria mostrando persona mas baja.");
			agrupamiento_altura.keySet().stream().forEach(cat -> {
				System.out.println("Categoria: " + cat);
				System.out.println(agrupamiento_altura.get(cat));
			});
			// Mapa de objetos Persona agrupados por categoria mostrando la altura media por
			// grupo
			Map<String, Double> agrupamiento_categoria_altura_media = datos2.stream()
					.collect(Collectors.groupingBy(p -> p.categoria, Collectors.averagingDouble(o -> o.altura)));
			System.out.println("Agrupados por categoria mostrando altura media.");
			agrupamiento_categoria_altura_media.keySet().stream().forEach(cat -> {
				System.out.println("Categoria: " + cat);
				System.out.println(String.format("%.2f", agrupamiento_categoria_altura_media.get(cat)));
			});
			// Mapa de objetos Persona agrupados por categoria mostrando el total de
			// personas
			Map<String, Long> agrupamiento_contador = datos2.stream()
					.collect(Collectors.groupingBy(p -> p.categoria, Collectors.counting()));
			System.out.println("Agrupados por categoria mostrando numero de personas por grupo.");
			agrupamiento_contador.keySet().stream().forEach(cat -> {
				System.out.println("Categoria: " + cat);
				System.out.println(agrupamiento_contador.get(cat));
			}); 
	
		//--------------------------------------- LIMITADOR DE RESULTADOS ----------------------------------------------------------

		// Calcula el número de paginas en funcion de la cantidad de valores a mostrar
		int paginas = (int) (datos2.size() / 5.0f);
		// Bucle de visualizacion de páginas
		for (int pagina = 0; pagina <= paginas; pagina++) {
			System.out.println("Pagina : " + pagina);
			System.out.println(datos2.stream().sorted().skip(pagina * 5) // Elimina los primeros valores
					.limit(5) // Limita los restantes
					.collect(Collectors.toList()));
		}
//----------------------------------------------------------------------------------------------------------------------------

		}

	

}
	

