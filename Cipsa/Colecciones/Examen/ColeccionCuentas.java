package Examen;

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
import java.util.TreeMap;

import Persona.Persona;

public class ColeccionCuentas implements Serializable{

	private ArrayList<Cuenta> listadocuentas=new ArrayList<Cuenta>();
	private static final long serialVersionUID = 5L;
	//private TreeMap<Integer, Cuenta> mapa = new TreeMap<Integer, Cuenta>();
	//private Cuenta cuenta;

	public ColeccionCuentas() {
		this.listadocuentas = new ArrayList<Cuenta>();
		//this.mapa=mapa.put(cuenta.getCodigo(), cuenta);
	}

	public void alta(Cuenta objCuenta) {
		listadocuentas.add(objCuenta);
		
	}

	public boolean existeCuenta(int numCuenta) {
		boolean resultado = false;
		for (int i = 0; i < listadocuentas.size() && resultado==false; i++)  {
			if (listadocuentas.get(i).getCodigo() == numCuenta) {
				resultado = true;
			} 
		}
		return resultado;
	}
	
	public void baja(int numCuenta) {
		boolean encontrado=false;
		for (int i = 0; i < listadocuentas.size() && encontrado==false; i++) {
			if (listadocuentas.get(i).getCodigo() == numCuenta) {
				listadocuentas.remove(i);
			} 
		}
		
		if(encontrado=false) {
			System.out.println(" ");
		}
	}

	public Cuenta obtener(int numCuenta) {
		boolean encontrado = false;
		Cuenta cuentaaux = null;
		for (int i = 0; i < listadocuentas.size() && encontrado == false; i++) {
			if (listadocuentas.get(i).getCodigo() == numCuenta) {
				encontrado = true;
				cuentaaux = listadocuentas.get(i);
			}
		}
		if (encontrado = false) {
			System.out.println(" ");
		}
		return cuentaaux;

	}
	
	public Cuenta[] listar(){
		Cuenta[] matriz = new Cuenta[listadocuentas.size()];
		matriz = listadocuentas.toArray(matriz);
		return matriz;
	}
	
	public Cuenta[] filtrarSaldoInferior(float saldoMinimo) {
		boolean minimo = false;
		ArrayList<Cuenta> aux = new ArrayList<Cuenta>();
		for (int i = 0; i < listadocuentas.size(); i++) {
			if (listadocuentas.get(i).getSaldo() >= saldoMinimo) {
				aux.add(listadocuentas.get(i));
				minimo = true;
			}
		}
		if (minimo == false) {
			System.out.println(" ");
		}
		Cuenta[] matriz = new Cuenta[aux.size()];
		matriz = aux.toArray(matriz);

		return matriz;

	}
	
	public void guardarDatos(String rutaFichero) {

		ObjectOutputStream ostream = null;
		Cuenta c;
		try {
			// Apertura de flujo de salida.
			ostream = new ObjectOutputStream(new FileOutputStream(rutaFichero));

			for (int i = 0; i < listadocuentas.size(); i++) {
				ostream.writeObject(listadocuentas.get(i));
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

	/*
	public void cargarDatos(String rutaFichero) {
		try (ObjectInputStream istream = 
				new ObjectInputStream( new FileInputStream( rutaFichero )) ) {
			while (true) {
				Cuenta c = (Cuenta) istream.readObject();
				listadocuentas.add(c);
			}
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		} 
	}
*/

	public void cargarDatos(String rutaFichero) {
		try (FileInputStream ifstream = 
				new FileInputStream( rutaFichero )) {
			ObjectInputStream istream = new ObjectInputStream( ifstream ); 
			while (ifstream.available() > 0 ) {
				Cuenta c = (Cuenta) istream.readObject();
				listadocuentas.add(c);
			}
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		} 
	}

	
	
	@Override
	public String toString() {
		return "ColeccionCuentas [listadocuentas=" + listadocuentas + "]";
	}

	public ArrayList<Cuenta> getListadocuentas() {
		return listadocuentas;
	}

	public void setListadocuentas(ArrayList<Cuenta> listadocuentas) {
		this.listadocuentas = listadocuentas;
	}

}
