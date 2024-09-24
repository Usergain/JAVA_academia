package Fichero_Binario;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Persona.*;

public class Serializacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona[] listadoPersonas = { new Persona("29384950L", 20, false, 190.45f),
				new Persona("54543566H", 22, false, 200.04f), new Persona("54643643G", 21, false, 180.44f),
				new Persona("45645656K", 24, false, 179.67f), new Persona("44323445F", 25, true, 200.24f),
				new Persona("34324233Y", 29, true, 195.24f), };

		GuardarPersonas(listadoPersonas);

		Persona[] lista = LeerPersona();
		mostrarLista(lista);

	}

//--------------------------------------------------------------------------------------------------------------------------------

	public static void GuardarPersonas(Persona[] listadoPersonas) {
		// Flujo de salida de objetos.
		ObjectOutputStream ostream = null;
		Persona p;
		try {
			// Apertura de flujo de salida.
			ostream = new ObjectOutputStream(new FileOutputStream("C:/Users/userg/Documents/CIPSA/personaSerializable.dat"));

			for (int i = 0; i < listadoPersonas.length; i++) {

				p = new Persona(listadoPersonas[i].getDni(), listadoPersonas[i].getEdad(),listadoPersonas[i].casado(), listadoPersonas[i].getAltura());
				ostream.writeObject(p);

			}
		} catch (FileNotFoundException e) {
			System.out.println("1" + e.getMessage());
		} catch (IOException e) {
			System.out.println("2" + e.getMessage());
		} finally {
			try {
				if (ostream != null) {
					ostream.close();
				}
			} catch (IOException e) {
				System.out.println("3" + e.getMessage());
			}
		}
	}

	// ----------------------------------------------------------------------------------------------------------------------------------
// Deserializa el objeto Persona:
	public static Persona[] LeerPersona() {

		ArrayList<Persona> listadoPersonas = new ArrayList<Persona>();
		ObjectInputStream istream = null;
		Persona p;

		try {
			istream = new ObjectInputStream(
					new FileInputStream("C:/Users/userg/Documents/CIPSA/personaSerializable.dat"));
			while (true) {
				p = (Persona) istream.readObject(); // el objeto deserializado puede pertenecer a cualquier
													// clase(Instancia Objeto) casting
				listadoPersonas.add(p);
			}

		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Error E/S ");
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no existe");
		} finally {

			try {
				if (istream != null)
					istream.close();
				System.out.println("Fichero_Binario cerrado");
			} catch (IOException e) {
			}
		}
		Persona[] pArray = new Persona[listadoPersonas.size()];

		return listadoPersonas.toArray(pArray);
	}

	public static void mostrarLista(Persona[] personas) {
		for (int i = 0; i < personas.length; i++) {
			System.out.println(personas[i].toString());
		}
	}
	
}
