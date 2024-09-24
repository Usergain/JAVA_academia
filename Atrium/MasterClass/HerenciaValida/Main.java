package HerenciaValida;

import java.util.ArrayList;

public class Main {

public static ArrayList<SeleccionFutbol> integrantes = new ArrayList<SeleccionFutbol>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		Futbolista iniesta = new Futbolista(13,"Francisco","Iniesta Martin", 42, 17,"delantero");
		iniesta.Concentrarse();
		System.out.println("Futlbolista: "+ iniesta.getNombre()+ " "+iniesta.getApellidos());
		*/
		
		Entrenador delBosque = new Entrenador(1,"Vicente","Del Bosque",60,"12341234");
		Futbolista iniesta = new Futbolista(2,"Andres","Iniesta",41,6,"Interior derecha");
		Masajista raulMartinez = new Masajista(3,"Raul","Martinez", 45,"Licenciado en Fisoterapia",20);
		
		integrantes.add(delBosque);
		integrantes.add(iniesta);
		integrantes.add(raulMartinez);
		
		//Los concentramos
		System.out.println("Todos los integrantes se van a concentrar: ");
		for (SeleccionFutbol i : integrantes)
		{
			System.out.print(i.getNombre()+" "+i.getApellidos()+ "->");
			i.Concentrarse();
		}
		
		// Los ponemos a viajar.
		System.out.println("Los ponemos a viajar a los integrantes: ");
		for (SeleccionFutbol i : integrantes)
		{
			System.out.print(i.getNombre()+" "+i.getApellidos()+ "->");
			i.Viajar();
		}
		
		//Entrenamos todos.
		System.out.println("");
		System.out.println("Los ponemos a entrenar a todos los integrantes: ");
		System.out.println(delBosque.getNombre() + "  " + delBosque.getApellidos());
		delBosque.dirigirEntrenamiento();
		System.out.println(iniesta.getNombre()+ "  "+iniesta.getApellidos());
		iniesta.entrenar();
		
		//A dar masaje.
		System.out.println("");
		System.out.println("El masajista va a dar un masaje: ");
		System.out.println(raulMartinez.getNombre() + "  " + raulMartinez.getApellidos());
		raulMartinez.darMasaje();
		
		//Los ponemos a jugar
		System.out.println("");
		System.out.println("Los ponemos a jugar un partido a todos los integrantes: ");
		System.out.println(delBosque.getNombre() + "  " + delBosque.getApellidos());
		delBosque.dirigirPartido();
		System.out.println(iniesta.getNombre()+ "  "+iniesta.getApellidos());
		iniesta.jugarPartido();
		
	}

}
