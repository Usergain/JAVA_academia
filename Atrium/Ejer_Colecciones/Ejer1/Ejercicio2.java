package Ejer1;

import java.util.ArrayList;
import java.util.Scanner;

import Colecciones.Arraylist;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lista = new ArrayList();
		Scanner teclado = new Scanner(System.in);
		int numero = 1;
		int suma = 0;
		int cont = 0;
		int media;

		while (numero != 0) {
			System.out.println("Dame un numero");
			numero = teclado.nextInt();
			lista.add(numero);
			suma += numero;
			if (numero != 0) {
				cont++;
			}

		}

		media = suma / cont;

		// System.out.println(cont);
		System.out.println("suma: " + suma);
		System.out.println("media: " + media);
		for (Integer integer : lista) {
			System.out.println(integer);
		}

	}

}
