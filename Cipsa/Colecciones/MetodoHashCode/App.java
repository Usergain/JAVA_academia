package MetodoHashCode;

import java.util.HashMap;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Identificacion, String> mapa = new HashMap<Identificacion, String>();
		// Inseercion de valores.
		mapa.put(new Identificacion("ANALISIS", 3902), "Roger Petrov");
		mapa.put(new Identificacion("CALCULO", 4845), "Ivan Gregroriev");
		mapa.put(new Identificacion("COMERCIAL", 4853), "Yuri Demidovich");
		mapa.put(new Identificacion("ANALISIS", 2384), "Pavel Piskunov");
		mapa.put(new Identificacion("CALCULO", 3423), "Andrei Stepanovich");
		// Obtencion del trabajador en departamento de analisis con código 2384
		String nombreTrabajador = mapa.get(new Identificacion("ANALISIS", 2384));
		if (nombreTrabajador != null) {
			System.out.println("Trabajador encontrado: " + nombreTrabajador);
		} else {
			System.out.println("Identificacion inexistente.");
		}
		
	}

}
