package Fichero_Propiedad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {

	public static final String IP = "ip";
	public static final String USUARIO = "Usuario";
	public static final String CLAVE = "clave";
	private Properties props;

	public Propiedades() {
		props = new Properties();
		if (!new File("app.properties").exists()) {
			// Valores por defecto
			this.props.setProperty(IP, "127.0.0.1");
			this.props.setProperty(USUARIO, "admin");
			this.props.setProperty(CLAVE, "1234");
		} else {
			// Carga de valores almacenados.
			try {
				props.loadFromXML(new FileInputStream("app.properties"));
			} catch (IOException e) {
				System.out.println("Error >> " + e.getMessage());
			}
		}
	}

	/**
	 * @param propiedad El valor de la propiedad a recuperar
	 * @return El valor asociado a la propiedad indicada.
	 */
	public String get(String propiedad) {
		return this.props.getProperty(propiedad);
	}

	/**
	 * @param propiedad El valor de la propiedad a modificar
	 * @param valor     El valor a asociar a la propiedad
	 */
	public void set(String propiedad, String valor) {
		this.props.setProperty(propiedad, valor);
	}

	public void update() {
		try {
			this.props.storeToXML(new FileOutputStream("app.properties"), "");
		} catch (IOException ex) {
			System.out.println("Error >> " + ex.getMessage());
		}
	}
}
