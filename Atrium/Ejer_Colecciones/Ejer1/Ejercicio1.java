package Ejer1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] numeros = new Integer[10];
		ArrayList<Integer> lista = new ArrayList<>(numeros.length);
		Scanner teclado = new Scanner(System.in);
		int numero = 0;
		int suma = 0;
		int media;

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Dame un numero");
			numero = teclado.nextInt();
			lista.add(numero);
			suma += numero;
		}

		media = suma / 10;

		System.out.println("suma: " + suma);
		System.out.println("media: " + media);
		for (Integer integer : lista) {
			System.out.println(integer);
		}

	}

}
