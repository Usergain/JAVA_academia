import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leer_Buffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Leer_fichero leyendo=new Leer_fichero();

		leyendo.leer();
	}
}

	class Leer_fichero {

		public void leer() {
			try {
				FileReader entrada = new FileReader("C:/Users/userg/Documents/Pildoras/ejemplo2.txt");

				BufferedReader mibuffer = new BufferedReader(entrada);

				String linea = "";

				while (linea != null) {

					linea = mibuffer.readLine();
					
					if(linea!=null) {
						System.out.println(linea);
					}

					
				}

				entrada.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("No se ha encontrado el archivo");
			}
		}

	}


