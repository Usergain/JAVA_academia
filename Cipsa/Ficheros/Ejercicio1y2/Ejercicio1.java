package Ejercicio1y2;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre;
		int cont = 0;
		Scanner sc = new Scanner(System.in);
		ArrayList<String> nombres = new ArrayList();

		System.out.println("Dame 5 nombres:");
		nombre = sc.nextLine();
		nombres.add(nombre);
		cont++;
		while (cont < 5) {
			System.out.println("Dame otro nombre");
			nombre = sc.nextLine();
			nombres.add(nombre);
			cont++;
		}
		
		EscribirFichero(nombres);
	}
//-----------------------------------------------------------------

	public static void EscribirFichero(ArrayList<String> nombres) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("C:/Users/userg/Documents/CIPSA/frases.txt");
			for (String nombre : nombres) {
				pw.println(nombre);
			}
		} catch (Exception e) {
			System.out.println("Error E/S");
		} finally {
			try {
				if (null != pw) {
					pw.flush();
					pw.close();
					System.out.println("Archivo guardado con exito");
				}
			} catch (Exception e2) {

			}
		}
	}

}
