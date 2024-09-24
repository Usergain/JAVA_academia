package Fichero_Propiedad;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instanciación del objeto Properties
		Properties props = new Properties();
		InputStream is = Aplicacion.class.getClassLoader()
				.getResourceAsStream("Fichero_Propiedad/app.properties");
		try {
			// Carga del fichero de propiedades
			props.load(is);
			// Obtención y visualización de valores de propiedades
			System.out.println("IP: " + String.valueOf(props.getProperty("Ip")));
			System.out.println("Usuario: " + String.valueOf(props.getProperty("Usuario")));
			System.out.println("Clave: " + String.valueOf(props.getProperty("Pass")));
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
}


	