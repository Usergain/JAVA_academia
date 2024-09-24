package Ejercicio3;

import java.util.*;

public class Main {

	static HashSet<Vagon> coleccion_vagones = new HashSet<Vagon>();
	static Hashtable<String, Tren> infoTrenes = new Hashtable<String, Tren>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tren tren = null;
		Vagon vagon = null;
		// Vagon<>vagones> = new Vagon<>;

		Scanner teclado = new Scanner(System.in); //Para meter los datos

		int opcion;
		boolean salir = false;

		while (!salir) {

			System.out.println("0- Finalizar programa");
			System.out.println("1- Registrar un tren");
			System.out.println("2- Mostrar datos de un tren");
			System.out.println("3- Listado de trenes");

			Scanner sc = new Scanner(System.in); //Para el panel de opciones
			opcion = sc.nextInt();

			switch (opcion) {

			case 1: {
				System.out.println(" Introduzca la matrícula del tren ");
				String matricula = teclado.next();

				System.out.println(" Introduzca empresa ");
				String empresa = teclado.next();

				tren = new Tren(matricula, empresa);

				System.out.println("Siguiente vagon (S/N)?");
				char siguiente = teclado.next().toUpperCase().charAt(0);

				System.out.println(" Informacion de vagones:");

				do {

					System.out.println("Dame mercancia que transporta vagon ");
					String mercancia = teclado.next();

					System.out.println(" Dame toneladas de mercancia que transporta el vagon ");
					float tonelada = teclado.nextFloat();

					vagon = new Vagon(mercancia, tonelada);
					coleccion_vagones.add(vagon);

					tren.insertarVagon(vagon);
					infoTrenes.put(tren.getMatricula(), tren);

					System.out.println("Vagón creado --> " + vagon.toString());

					System.out.println("Siguiente vago (S/N)?");
					siguiente = teclado.next().toUpperCase().charAt(0);

				} while (siguiente == 'S');

				System.out.println("Tren creado exitosamente !!!");

			}
				break;

			case 2: {
				System.out.println(" Dame la matricula del tren ");
				String matricula = teclado.next();

				tren = buscarTren(matricula);

				if (tren != null) {
					System.out.println(tren.toString());
					tren.listar_vagones();

				} else {
					System.out.println("No existe ningún tren con esa matrícula: " + matricula);
				}
			}
				break;

			case 3: {
				System.out.println("El listado de trenes: \n ");
				
				infoTrenes.forEach((k, v) -> {
					System.out.println(v.toString());
					v.listar_vagones();
				});

			}
				break;

			case 0: {
				System.out.println("Fin del programa");
				System.exit(0);
				break;
			}

			default:
				System.out.println("Debes seleccionar una opción válida entre 0 y 3");
			}
		}

	}

	public static Tren buscarTren(String matricula) {

		Tren t = null;

		if (infoTrenes.get(matricula).getMatricula().equalsIgnoreCase(matricula)) {
			t = infoTrenes.get(matricula);
		}

		return t;
	}

}
