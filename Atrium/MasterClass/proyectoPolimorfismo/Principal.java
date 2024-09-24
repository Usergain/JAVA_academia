package proyectoPolimorfismo;

import java.util.ArrayList;

public class Principal {

public static ArrayList<SeleccionFutbol> integrantes = new ArrayList<SeleccionFutbol>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//SeleccionFutbol casillas = new SeleccionFutbol();   No se puede crear un objeto de la clase abstracta.!!!!!!!!!!
		
		SeleccionFutbol delBosque = new Entrenador(1,"Vicente","del Bosque",65,28489);
		
		SeleccionFutbol iniesta = new Futbolista(2,"Andrés","Iniesta",35,6,"Interior derecha");
		
		SeleccionFutbol raulMartinez = new Masajista(3,"Raúl","Martinez",46,"Licenciado en fisoterapia", 20);
		
		
		integrantes.add(delBosque);
		integrantes.add(iniesta);
		integrantes.add(raulMartinez);
		
		// Los ponemos a concentrarse a todos.
		System.out.println("Los ponemos a concentrarse a los integrantes de la selección de futbol:");
		for (SeleccionFutbol integrante : integrantes) {
			System.out.println(integrante.getNombre() + "  "+ integrante.getApellidos());
			integrante.concentrarse();
		}
		
		// Los ponemos a viajar a todos.
		System.out.println("\nLos ponemos a viajar a los integrantes de la selección de futbol: ");
		for (SeleccionFutbol integrante: integrantes) {
			System.out.println(integrante.getNombre()+"  "+integrante.getApellidos());
			integrante.Viajar();
		}
		
		// Los ponemos a entrenar a todos.
		System.out.println("\nLos ponemos a entrengar a todos los integrantes de la selección de futbol: ");
		for (SeleccionFutbol integrante : integrantes) {
			System.out.println( integrante.getNombre() + "  "+integrante.getApellidos());
			integrante.entrenamiento();
		}
		
		// Los ponemos a todos a jugar un partido.
		System.out.println("\nLos ponemos a jugar un partido de futbol: ");
		for (SeleccionFutbol integrante : integrantes) {
			System.out.println(integrante.getNombre()+ "   "+ integrante.getApellidos());
			integrante.partidoFutbol();
		}
		
	}
}
