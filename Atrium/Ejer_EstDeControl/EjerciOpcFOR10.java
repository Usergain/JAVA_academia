import java.util.Scanner;

public class EjerciOpcFOR10 {
	/*Escriba un programa que pregunte cuántos números se van a introducir, pida esos números, y escriba el mayor, el menor y la media aritmética.

Se recuerda que la media aritmética de un conjunto de valores es la suma de esos valores dividida por la cantidad de valores.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valores;
		int numeros=0;
		int minimo=0;
		int maximo=0;
		int contador=0;
		int acumulador=0;
		float media;
		Scanner teclado= new Scanner(System.in);

		System.out.println(" MAYOR, MENOR Y MEDIA ARITMETICA ");
		System.out.print("¿Cuantos valores vas a introducir? ");
		valores=teclado.nextInt();
		if(valores>=0) {
			for (int i = 1; i <= valores; i++) {
				if(i==1) {
					System.out.print("Escribe el valor " + i + " --> ");
					numeros=teclado.nextInt();
					maximo=numeros;
					minimo=numeros;
				}
				else {
					System.out.print("Escribe el valor " + i + " --> ");
					numeros=teclado.nextInt();
					System.out.println(i);

					acumulador += numeros;
					contador++;
					if(numeros<minimo) {
						minimo=numeros;
					}

					else if(numeros>maximo) {
						maximo=numeros;
					}

				}

			}
			media=acumulador/contador;
			System.out.println(minimo);
			System.out.println(maximo);
			System.out.println(acumulador);
			System.out.println(media);

		}
		else {
			System.out.println("¡Imposible!");
		}

	}


}
