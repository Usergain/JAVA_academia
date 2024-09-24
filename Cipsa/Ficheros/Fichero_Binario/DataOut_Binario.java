package Fichero_Binario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import Persona.*;

public class DataOut_Binario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona[] persona = new Persona[5];
		Persona p = new Persona("78920987-Y", 38, false, 1.78f);
		Persona p2 = new Persona("90556987-B", 59, true, 1.72f);
		Persona p3 = new Persona("78920987-Y", 14, false, 1.48f);
		Persona p4 = new Persona("78920987-Y", 65, true, 1.57f);
		Persona p5 = new Persona("78920987-Y", 3, false, 1.78f);

		guardarPersona(p);
		guardarPersona(p2);
		guardarPersona(p3);
		guardarPersona(p4);
		guardarPersona(p5);

		Persona[] lista = leerPersona();
		leerArray(lista);

		System.out.println(leerNumeros().toString());

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------

	public static void guardarPersona(Persona p) {
		DataOutputStream fdout = null;
		try {

			fdout = new DataOutputStream(new FileOutputStream("C:/Users/userg/Documents/CIPSA/persona.dat", true));
			fdout.writeUTF(p.getDni());
			fdout.writeInt(p.getEdad());
			fdout.writeBoolean(p.casado());
			fdout.writeFloat(p.getAltura());

		} catch (IOException ex) {
			System.out.println("Error de E/S");
		} finally {
			if (fdout != null) {
				try {
					fdout.flush();
					fdout.close();
				} catch (IOException e) {
					System.out.println("No esta cerrado");
				}
			}
		}
	}

	public static Persona[] leerPersona() {

		DataInputStream fdin = null;
		Persona p = null;
		Persona[] personas = new Persona[5];

		try {

			fdin = new DataInputStream(new FileInputStream("C:/Users/userg/Documents/CIPSA/persona.dat"));

			for (int i = 0; i < personas.length; i++) {

				String dni = fdin.readUTF();
				int edad = fdin.readInt();
				boolean estado = fdin.readBoolean();
				float altura = fdin.readFloat();

				p = new Persona(dni, edad, estado, altura);
				personas[i] = p;

			}

		} catch (IOException ex) {

		} finally {
			try {
				if (fdin != null) {
					fdin.close();
				}
			} catch (IOException es) {
			}
		}

		return personas;
	}

	public static void leerArray(Persona[] personas) {
		for (int i = 0; i < personas.length; i++) {
			System.out.println(personas[i].toString());
		}
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------

	public static Vector<Integer> leerNumeros() {
		// Declaracion del objeto Flujo
		DataInputStream fdin = null;
		Vector<Integer> listaValores = new Vector<Integer>();
		try {
			// Apertura de flujo.
			fdin = new DataInputStream(new FileInputStream("C:/Users/userg/Documents/CIPSA/persona.dat"));
			// Recuperar valores
			while (true) {
				listaValores.add(fdin.readInt());
			}
		} catch (EOFException ex) {
			System.out.println("Fin de fichero alcanzado.");
		} catch (IOException ex) {
			System.out.println("Error de E/S");
		} finally {
			try {
				if (fdin != null)
					fdin.close();
			} catch (IOException ex) {
			}
		}
		return listaValores;
	}

}

