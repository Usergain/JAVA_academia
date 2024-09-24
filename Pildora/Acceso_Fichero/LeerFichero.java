
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Leyendo accediendo=new Leyendo();

		accediendo.leer();

	}
}

	class Leyendo {
		public void leer() {
			try {
				FileReader entrada = new FileReader("C:/Users/userg/Documents/Pildoras/ejemplo2.txt");

				int c = entrada.read();

				while (c != -1) {
					c = entrada.read();

					char letra = (char) c;// para pasar el codigo unicode a caracteres

					System.out.print(letra);
				}

				entrada.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("No se ha encontrado el archivo");
			}
		}

}
