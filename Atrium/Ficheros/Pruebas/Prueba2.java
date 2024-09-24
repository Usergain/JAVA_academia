package Pruebas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Prueba2 {

	public static void main(String[] args) {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("c:\\datos2.xml")));

			System.out.println(properties.get("DRIVER"));
			System.out.println(properties.get("URL"));
			System.out.println(properties.get("USUARIO"));
			System.out.println(properties.get("CLAVE"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}