package POO_2;

import java.util.Date;

/* Se plantea desarrollar un programa en Java que permita la gesti�n de los neum�ticos de una escuder�a de competici�n. Esta escuder�a participa en varios tipos de carreras, circuitos, rallies y 
karts.
El cliente nos da una serie de caracter�sticas de los neum�ticos que quieren almacenar en nuestro programa y se nos pide hacer una estructura de clases (El modelo) para los diferentes tipos de 
neum�ticos.
Recuerda que al crear las clases debes tener encuenta todo lo visto en el tema, como herencias, interfaces, etc.
Los datos que nos proporciona el cliente son:
 
Neum�ticos de competici�n para pista: 
Marca (String), caducidad (String o Date), dureza (int), adherencia (int), temperatura (float) color (String), dibujo (Pueden ser de Mojado, seco o intermedios).

Neum�ticos de competici�n para rallies: 
Marca (String), caducidad (String o Date), dureza (int), presi�n (float), color (String), profundidadDibujo (int), dibujo (Pueden ser de Mojado, seco o intermedios).

Neum�ticos de competici�n para karts: 
Marca (String), caducidad (String o Date), dureza (int), llanta (int), color (String), dibujo (Pueden ser de Mojado, seco o intermedios).

El cliente tambi�n nos pide que tenemos que cerciorarnos de que una de las funcionabilidades del programa sea:
 - Poder impirmir por pantalla la marca del neum�tico y su cadudidad en una sola l�nea.
 - Un m�todo para que si la dureza es inferior a 10 nos lo indique por la terminal como "blando", si est� entre 10 y 50 como "medio" y m�s de 50 como "duro".

 Cada clase debe disponer de constructor y permitir establecer (set) y recuperar (get) el valor de sus atributos y tener un m�todo que permita mostrar la informaci�n del objeto. Crear una clase 
 test con el m�todo main donde se cree un objeto de cada tipo y se muestren los datos de cada uno de los objetos creados. 

Adem�s de probar los m�todos de dureza e impresi�n de marca y caducidad que nos ped�a el cliente. */

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date fecha=new Date("21/11/2023");
		NeumaticoKart neumatico= new NeumaticoKart("Michelin",fecha, 50, "negro","SECO",21);
		
		@SuppressWarnings("deprecation")
		Date fecha1=new Date("15/08/2022");
		NeumaticoRally neumatico1= new NeumaticoRally("Bridgstone", fecha1, 9, "blanco", "MOJADO", 20.5f, 8);
		
		Date fecha2=new Date("01/01/2024");
		NeumaticoPista neumatico2=new NeumaticoPista("Dunlop" , fecha2, 15, "negro", "INTERMEDIO", 20 , 100);
		
		System.out.println(neumatico);
		System.out.println(neumatico1);
		System.out.println(neumatico2);
		
		System.out.println(neumatico1.tipoDibujo());
		System.out.println(neumatico1.Mostrar());
		
		System.out.println(neumatico2.tipoDibujo());
		System.out.println(neumatico2.Mostrar());
		
		System.out.println(neumatico.tipoDibujo());
		System.out.println(neumatico.Mostrar());
		
	}

}
