package FicheroDirectorio;

import java.io.File;

public class Eliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ruta = new File("C:" + File.separator + "Users" + File.separator + "userg" + File.separator + "Documents"
				+ File.separator + "Pildoras" + File.separator + "otraPruebaMas.txt");
		
		ruta.delete();
	}

}
