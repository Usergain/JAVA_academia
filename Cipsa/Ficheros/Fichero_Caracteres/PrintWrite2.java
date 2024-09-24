package Fichero_Caracteres;

import java.io.IOException;
import java.io.PrintWriter;

import Persona.Persona;

public class PrintWrite2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona[] listadoPersonas = { new Persona("29384950L", 20, false, 190.45f),
				new Persona("54543566H", 22, false, 200.04f), new Persona("54643643G", 21, false, 180.44f),
				new Persona("45645656K", 24, false, 179.67f), new Persona("44323445F", 25, true, 200.24f),
				new Persona("34324233Y", 29, true, 195.24f), };
		
		guardarPersonas(listadoPersonas);
	}

	public static void guardarPersonas(Persona[] personas) {
		// Declaracion del objeto Flujo
		PrintWriter pw = null;
		try {
			// Apertura de flujo.
			pw = new PrintWriter("C:/Users/userg/Documents/CIPSA/flujoCaracteres_PrintWriter_Personas.txt");
			// Guardado de datos de cada objeto persona
			for (Persona p : personas) {
				pw.print(p.getDni());
				pw.print(",");
				pw.print(p.getEdad());
				pw.print(",");
				pw.print(p.casado());
				pw.print(",");
				pw.println(p.getAltura());
			}
		} catch (IOException ex) {
			System.out.println("Error de E/S");
		} finally {
			if (pw != null) {
				pw.flush();
				pw.close();
			}
		}
	}

}
