package FicheroDirectorio;

import java.io.*;

public class Prueba_rutas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = new File("bin"); //--> por defecto workspace donde guardo proyectos
		
		System.out.println(archivo.getAbsolutePath());
		System.out.println(archivo.exists());
	}

}
