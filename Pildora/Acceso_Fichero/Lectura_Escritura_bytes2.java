import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lectura_Escritura_bytes2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int byte_leido;
		int bytes_leidos = 0;
		int datos_entrada[]=new int[55640];
		FileInputStream archivo_lectura = null;
		try {
			archivo_lectura = new FileInputStream("C:/Users/userg/Documents/Pildoras/imagen.jpg");
			byte_leido = archivo_lectura.read();
			while (byte_leido != -1) {
				bytes_leidos++;
				System.out.println(byte_leido);
				byte_leido = archivo_lectura.read();
				
				
				if(byte_leido!=-1) {
					datos_entrada[bytes_leidos]=byte_leido;
					
				}
				
			}
			//datos_entrada[bytes_leidos]=byte_leido;
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {
			if (archivo_lectura != null) {
				try {
					archivo_lectura.close();
				} catch (IOException ex) {
				}
			}
			System.out.println(String.format("Archivo cerrado. %d bytes leidos", bytes_leidos));
			
			crea_fichero(datos_entrada);
		}

	}
	
	static void crea_fichero(int datos_nuevo_fichero[]) {
		try {
			FileOutputStream fichero_nuevo=new FileOutputStream("C:/Users/userg/Documents/Pildoras/imagen_copia.jpg"); // --> crear fichero
			for (int i = 0; i < datos_nuevo_fichero.length; i++) {
				fichero_nuevo.write(datos_nuevo_fichero[i]); //--> almacenamos en un array un fichero
			}
			
			fichero_nuevo.close();
			
		}
		catch(IOException e){
			System.out.println("Error al crear el archivo");
		}
	}

}
