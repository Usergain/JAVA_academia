package Ejercicio7;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int[] numeros;
		boolean salir = false;
		int conjunto;
		int opcion = 10;
		int indx;
		int valor;
		Scanner sc = new Scanner(System.in);

		GestionFichero gestion = new GestionFichero();

		while (!salir) {

			System.out.println("1.- INTRODUCIR NUMEROS: ");
			System.out.println("2.- NUMERO DE LA POSICION: ");
			System.out.println("3.- LISTAR LOS VALORES GUARDADOS: ");
			System.out.println("4.- SUSTITUIR EL VALOR EN LA POSICION: ");
			System.out.println("0.- SALIR");

			opcion = sc.nextInt();

			switch (opcion) {

			case 0:

				salir = true;
				break;

			case 1:

				System.out.println("Cuantos numeros quieres introducir como valores en el conjunto? : ");
				conjunto = sc.nextInt();

				numeros = new int[conjunto];

				for (int i = 0; i < numeros.length; i++) {
					System.out.println("Dame un numero: ");
					num = sc.nextInt();
					gestion.agregarValor(num);
				}
				break;

			case 2:

				System.out.println(" Dame la posicion del archivo que quieres que imprima por pantalla: ");
				indx = sc.nextInt();
				System.out.println(gestion.devolverValor(indx)); 
				break;

			case 3:
				
				System.out.println("El litado de numeros guardados en le fichero es: ");
				int[] lista = gestion.listaValores();
				gestion.listarNumeros(lista);
				
				break;
				
			case 4:
				
				System.out.println("Dame la posicion y el numero ue quieres sustituir: ");
				indx = sc.nextInt();
				System.out.println("Dame el numero que quieres sustituir: ");
				valor = sc.nextInt();
				gestion.modificarValor(indx, valor);
				
				break;
			}

		}

	}

}
		
