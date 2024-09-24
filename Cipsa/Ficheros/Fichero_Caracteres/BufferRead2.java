package Fichero_Caracteres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Persona.Persona;

public class BufferRead2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona[] lineas = leerPersonas(); 
		
		 for( Persona linea : lineas) { 
		 System.out.println( linea ); 
		 } 
	}

	public static Persona[] leerPersonas() {
		// Coleccion de objetos.
		java.util.ArrayList<Persona> coleccion = new java.util.ArrayList<Persona>();
		BufferedReader br = null;
		String linea;
		try {
			// Apertura de flujo de entrada de caracteres
			br = new BufferedReader(new FileReader("C:/Users/userg/Documents/CIPSA/flujoCaracteres_PrintWriter_Personas.txt"));
			// Bucle de lectura de fichero linea a linea.
			linea = br.readLine();
			while (linea != null) {
				// Fragmentacion de cada linea para separar campos
				String[] campos = linea.split(",");
				// Comprobacion de numero de campos.
				if (campos.length == 4) {
					// Obtencion y conversion de campos
					String dni = campos[0];
					int edad = Integer.parseInt(campos[1]);
					boolean estado = (campos[2].equals("true"));
					float altura = Float.parseFloat(campos[3]);
					// Instanciacion de objeto Persona y añadido a coleccion.
					coleccion.add(new Persona(dni, edad, estado, altura));
				} else
					throw new IOException("Error de formato en linea");
				// Lectura de siguiente linea en fichero
				linea = br.readLine();
			}
		} catch (IOException ex) {
			System.out.println("Error de E/S" + ex.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
			}
		}
		// Conversion de coleccion en matriz de resultados.
		Persona[] matriz = new Persona[coleccion.size()];
		
		return coleccion.toArray(matriz);
	}

}
