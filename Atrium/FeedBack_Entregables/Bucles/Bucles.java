package Bucles;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*Escriba un programa que te permita jugar a la �primitiva�.  Para facilitar la labor de depuraci�n de errores, cada vez que el usuario introduzca un n�mero se mostrar� el boleto con los n�meros que debe acertar.
Las condiciones del ejercicio son:
El programa debe generar una secuencia de n�meros no repetidos como si fuera un boleto (9 n�meros; mayores de 10 y menores de 100).
12 21 35 46 88 72 94 49 27
Despu�s el usuario escribir� un numero: 
Si existe, mostrar� lo siguiente: 
12 21 35 XX 88 72 94 49 27
Si no existe, mostrar� lo siguiente:
N�mero 78 no existe
12 21 35 46 88 72 94 49 27
Se puede salir de la aplicaci�n cuando el usuario escriba 0.
En caso de tener todos los n�meros tachados, se mostrar�:
Te ha tocado la primitiva. Eres millonario.
Existir� un n�mero m�ximo de 15 intentos para acertar los n�meros del boleto.
Ayuda
Para crear un n�mero aleatorio en Java
int valor = Math.floor(Math.random()*99+10);*/

public class Bucles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int empezar = 1;
		int respuesta;
		Scanner teclado = new Scanner(System.in);
		
		int[]primitiva;
		String[] primitiva2 = new String[9];
		int cuenta = 0;
		int contador=15;

		System.out.println("Bienvenido al juego de la Primitiva:                       ");
		System.out.println("Tendr�s que acertar los 9 n�meros para llevarte un pellizco");
		System.out.println("���� MUCHA SUERTE !!!!");
		System.out.println();
		
		primitiva=new Random().ints(10, 99).distinct().limit(9).toArray();
		
		for (int i=0;i<9;i++ ) {
            primitiva2[i]=String.valueOf(primitiva[i]);
        }

		while (cuenta != 9 && contador!=0 && empezar==1 ) {

			System.out.println("********************PRIMITIVA******************************");
			System.out.println(" Este es el n�mero de Primitiva es : ");
			
			System.out.println(Arrays.toString(primitiva2));
			contador--;

			System.out.println("Dame un n�mero entre el 10-99, ambos incluidos");
			respuesta=teclado.nextInt();
			
			 for (int i=0;i<primitiva.length;i++) {
	                if (String.valueOf (respuesta).equals (primitiva2[i])) {
	                    primitiva2[i] = "XX";
	                    cuenta++;
	                    System.out.println ("acierto quedan " + contador + " intentos");
	                }
	            }
			 
			 System.out.println("�Quieres seguir jugando? SI(1)/NO(0)");
			 empezar = teclado.nextInt();
			 teclado.nextLine();	 

		}
		
		if(cuenta==9){
            System.out.println("\nFelicidades as Ganado");
        }else{
            System.out.println("\nSuerte para la proxima te faltaron los siguientes numeros");
            System.out.println(Arrays.toString(primitiva2));
        }

	}

}