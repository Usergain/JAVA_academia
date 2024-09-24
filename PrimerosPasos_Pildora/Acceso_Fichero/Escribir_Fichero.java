import java.io.FileWriter;
import java.io.IOException;

public class Escribir_Fichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Escribiendo accede_es = new Escribiendo();
		accede_es.escribir();

	}

}

class Escribiendo {

	public void escribir() {

		String frase = ". Ahora estamos escribiendo respentando el fichero realizado";

		try {
			FileWriter escritura = new FileWriter("C:/Users/userg/Documents/Pildoras/ejemplo2.txt",true); // true para ir agregando cosas

			for (int i = 0; i < frase.length(); i++) {

				escritura.write(frase.charAt(i));

			}

			escritura.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


