package Ejercicio6;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Ejercicio3.Vagon;

public class GestionVehiculo implements Serializable {

	private ArrayList<Vehiculo> ListaVehiculos = new ArrayList<Vehiculo>();

	private static final long serialVersionUID = 3L;

	public GestionVehiculo() {
		this.ListaVehiculos = new ArrayList<Vehiculo>();
	}

	public void alta(Vehiculo v) {

		try {

			File archivo = new File("C:/Users/userg/Documents/CIPSA/vehiculos1.dat");

			FileOutputStream fos = new FileOutputStream(archivo, true);

			ObjectOutputStream ostream = new ObjectOutputStream(fos);

			ostream.writeObject(v);
			ListaVehiculos.add(v);

			ostream.flush();
			ostream.close();
			fos.close();

		} catch (Exception e) {
			System.out.println("Error al escribir en el archivo. " + e.getMessage());
		}
	}

	public void mostraLista() {
		File archivo = new File("C:/Users/userg/Documents/CIPSA/vehiculos1.dat");

		try {

			FileInputStream fis = new FileInputStream(archivo);

			ObjectInputStream leer;

			while (fis.available() > 0) {
				leer = new ObjectInputStream(fis);

				Vehiculo v = (Vehiculo) leer.readObject();
				System.out.println(v);
			}

			fis.close();

		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
	}

	public Vehiculo buscar(String mat) {
		Vehiculo vehiculo = null;

		File archivo = new File("C:/Users/userg/Documents/CIPSA/vehiculos1.dat");

		try {

			FileInputStream fis = new FileInputStream(archivo);

			ObjectInputStream leer;

			while (fis.available() > 0) {
				leer = new ObjectInputStream(fis);

				Vehiculo v = (Vehiculo) leer.readObject();
				if (v.getMatricula().equalsIgnoreCase(mat)) {
					vehiculo = v;
				}
			}
			
			fis.close();

		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		}

		return vehiculo;
	}

}
