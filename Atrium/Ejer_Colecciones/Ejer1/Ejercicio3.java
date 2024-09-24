package Ejer1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lista = new ArrayList();
		Scanner teclado = new Scanner(System.in);
		int numero = 1;
		int suma = 0;
		int cont = 0;
		int media;
		boolean existe = false;

		while (numero != 0) {
			System.out.println("Dame un numero");
			numero = teclado.nextInt();
			
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i) == numero) {
					existe = true;
					break;
				}
			}
			
			if(!existe  && numero != 0) {
				lista.add(numero);
				suma += numero;
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
