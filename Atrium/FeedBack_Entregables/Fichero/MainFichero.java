package Fichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/*Realiza una aplicación que cree un archivo de texto con frases celebres introducidas desde la terminal por el usuario.

El programa preguntara el número de de frases que el usuario va a introducir y una vez las escriba por la terminal el programa debera imprimir cada una de las frases gardadas en el fichero y mostrar el número de caracteres que tiene la frase.

Ejemplo de salida:

- Frase celebre.... : contiene n caracteres.

- Frase celebre.... : contiene n caracteres.

- Frase celebre.... : contiene n caracteres.*/

public class MainFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] lineas = new String[] { "Nunca es tarde para bien hacer; haz hoy lo que no hiciste ayer.",
				"Cuando fuiste martillo no tuviste clemencia, ahora que eres yunque, ten paciencia.", 
				"A quien Dios no le dio hijos, el diablo le dio sobrinos.", 
				"Más rápido se coge al mentiroso que al cojo.", 
				"Quien da pan a perro ajeno, pierde el pan y pierde el perro." 
				};
		EscribirFichero(lineas);

		String[] lineas1 = LeerFicheroTexto();
		for (String linea : lineas1) {
			System.out.println(linea);
		}
	}

	public static void EscribirFichero(String[] lineas) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("C:/Users/userg/eclipse-workspace/Atrium/FeedBack_Entregables/Fichero/flujo.txt");

			for (String linea : lineas) {
				pw.println(linea);
			}
		} catch (Exception e) {
			System.out.println("Error E/S");
		} finally {
			try {
				if (null != pw) {
					pw.flush();
					pw.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	public static String[] LeerFicheroTexto() {

		java.util.ArrayList<String> lineas = new java.util.ArrayList<String>();
		String linea;
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new FileReader("C:/Users/userg/eclipse-workspace/Atrium/FeedBack_Entregables/Fichero/flujo.txt"));

			linea = br.readLine();
			while (linea != null) {
				lineas.add(linea);
				linea = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Error E/S");
		} finally {
			try {
				if (null != br) {
					br.close();
				}
			} catch (Exception e2) {
			}
		}
		String[] matriz = new String[lineas.size()];
		return lineas.toArray(matriz);
	}

}
