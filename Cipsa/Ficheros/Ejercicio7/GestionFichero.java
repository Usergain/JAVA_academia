package Ejercicio7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/*
• void modificarValor( int indx, int valor )  Modifica en el fichero el valor almacenado 
en la posición indicada por el parámetro indx con el valor indicado en el parámetro 
valor. Si la posición excede la longitud del fichero el método debe lanzar la excepción 
personalizada ValorFueraDeRangoException.
• Int devolverValor( int indx )  Devuelve el valor almacenado en el fichero en la 
posición indicada, donde 0 se considera el primer valor. Si la posición excede la 
longitud del fichero el método debe lanzar una excepción personalizada 
ValorFueraDeRangoException. 
• Int[] listarValores()  El método devuelve una matriz de enteros con todos los 
valores almacenados en el fichero “numeros.dat”
*/
import java.util.Arrays;

import Ejercicio6.Vehiculo;

public class GestionFichero {

	private int variable;

	private ArrayList<Integer> matriz;

	public GestionFichero() {
		this.matriz = new ArrayList<Integer>();
	}

	public GestionFichero(int variable) {
		this.matriz = new ArrayList<Integer>();
		this.variable = variable;
		this.matriz.add(this.variable);
	}

	public ArrayList<Integer> getMatriz() {
		return this.matriz;
	}

	public void setMatriz(ArrayList<Integer> matriz) {
		this.matriz = matriz;
	}

	@Override
	public String toString() {
		return "GestionFichero [variable=" + variable + ", matriz=" + matriz + "]";
	}

	public void agregarValor(int v) {
		DataOutputStream fwrite = null;

		try {
			fwrite = new DataOutputStream(new FileOutputStream("C:/Users/userg/Documents/CIPSA/numeros.dat", true));
			fwrite.write(v);
			System.out.println("NUM ESCRITO: " + v);
			this.matriz.add(v);
		} catch (IOException ex) {
			System.out.println("Error de E/S");
		} finally {
			if (fwrite != null) {
				try {
					fwrite.flush();
					fwrite.close();
					// System.out.println("Datos escritos");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("No esta cerrado");
				}
			}
		}
	}

	public void modificarValor(int indx, int valor) {
		File archivo = new File("C:/Users/userg/Documents/CIPSA/numeros.dat");
		int[] listado = new int[contarNumerosFichero()];

		int contador = 0;

		try {

			FileInputStream fis = new FileInputStream(archivo);

			while (fis.available() > 0) {
				Integer v = fis.read();
				listado[contador] = v;
				contador++;
			}

			for (int i = 0; i < listado.length; i++) {
				if (i == indx) {
					System.out.println(listado[i]);
					listado[i] = valor;
					System.out.println(listado[i]);
				}
			}

		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		
		DataOutputStream fdout = null;
		try {

			fdout = new DataOutputStream(new FileOutputStream(archivo));
			
			for (int i = 0; i < listado.length; i++) {
				if (listado[i] != 0) {
					fdout.write(listado[i]);	
				}
			}

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

		/*DataOutputStream fwrite = null;

		try {
			fwrite = new DataOutputStream(new FileOutputStream(archivo));
			for (int i = 0; i < listado.length; i++) {
				if (listado[i]==indx) {
					fwrite.writeInt(listado[i]);
				}
			}
		} catch (IOException ex) {
			System.out.println("Error de E/S");
		} finally {
			if (fwrite != null) {
				try {
					fwrite.flush();
					fwrite.close();
					// System.out.println("Datos escritos");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("No esta cerrado");
				}
			}
		}*/
		System.out.println("El fichero ha sido cambiando");
	}
	}

	public int devolverValor(int indx) {

		File archivo = new File("C:/Users/userg/Documents/CIPSA/numeros.dat");
		int[] listado = new int[contarNumerosFichero()];

		int contador = 0;
		int valor=0;

		try {

			FileInputStream fis = new FileInputStream(archivo);

			while (fis.available() > 0) {
				Integer v = fis.read();
				listado[contador] = v;
				contador++;
			}

			for (int i = 0; i < listado.length; i++) {
				if (i == indx) {
					valor=listado[i];
				}
			}

			fis.close();

		} catch (

		Exception e) {

			System.out.println("Error" + e.getMessage());
		}

		return valor;

	}

	public int contarNumerosFichero() {

		File archivo = new File("C:/Users/userg/Documents/CIPSA/numeros.dat");
		int contador = 0;

		try {

			FileInputStream fis = new FileInputStream(archivo);

			while (fis.available() > 0) {
				Integer v = fis.read();
				contador++;
			}

			fis.close();

		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
		return contador;
	}

	public int[] listaValores() {

		int[] listado = new int[contarNumerosFichero()];

		File archivo = new File("C:/Users/userg/Documents/CIPSA/numeros.dat");
		int contador = 0;

		try {

			FileInputStream fis = new FileInputStream(archivo);

			// ObjectInputStream leer;

			while (fis.available() > 0) {
				// leer = new ObjectInputStream(fis);

				Integer v = fis.read();
				listado[contador] = v;
				contador++;
			}

			fis.close();

		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
		return listado;
	}

	public void listarNumeros(int[] listado) {
		for (int i = 0; i < listado.length; i++) {
			if (listado[i] != 0) {
				System.out.println("numero: " + listado[i]);
			}
		}
	}
	
}
