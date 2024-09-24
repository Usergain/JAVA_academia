package FicheroDirectorio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// --> asi no hay problemas con distintos sist.operativos
		File ruta = new File("C:" + File.separator + "Users" + File.separator + "userg" + File.separator + "Documents"
				+ File.separator + "Pildoras" + File.separator + "nuevo_directorio");
		ruta.mkdir(); // crear nuevo directorio

		File ruta2 = new File("C:" + File.separator + "Users" + File.separator + "userg" + File.separator + "Documents"
				+ File.separator + "Pildoras" + File.separator + "otraPruebaMas.txt");

		String archivo_destino = ruta2.getAbsolutePath();
		try {
			ruta2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Escribiendo accede_es = new Escribiendo();

		accede_es.escribir(archivo_destino);
	}

}

class Escribiendo {
	public void escribir(String ruta_archivo) {

		String frase = "Esto es un ejemplo. Espero que salga";
		FileWriter escritura;

		try {

			escritura = new FileWriter(ruta_archivo);
			for (int i = 0; i < frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			escritura.close();

		} catch (IOException e) {

		}
	}
}
