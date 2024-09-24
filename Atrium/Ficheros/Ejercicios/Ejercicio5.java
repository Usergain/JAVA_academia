package Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Ejercicio5 {

	public static void main(String[] args) {
		String fich1, fich2;
		InputStreamReader flujo = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(flujo);
		try {
			System.out.println("Introduce fichero a copiar ");
			fich1 = teclado.readLine();
			System.out.println("Introduce nombre fichero de copia ");
			fich2 = teclado.readLine();
			FileReader flE = new FileReader(fich1);
			BufferedReader fE = new BufferedReader(flE);
			FileWriter flS = new FileWriter(fich2);
			BufferedWriter fS = new BufferedWriter(flS);
			String texto = "";
			while (texto != null) {
				texto = fE.readLine();
				if (texto != null) {
					fS.write(texto);
					fS.newLine();
				}
			}
			fE.close();
			fS.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}


