package Ejercicio3y4;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Ejercicio4.Cliente;
import Persona.Persona;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 2L;

	static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private String user;
	private long log;

	public Usuario(String user, long log) {
		this.user = user;
		this.log = log;
	}

	public Usuario(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getLog() {
		return log;
	}

	public void setLog(long log) {
		this.log = log;
	}

	public static long getSerialVersionuid() {
		return serialVersionUID;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public static void GuardarPersona(Usuario u) {
		ObjectOutputStream ostream = null;

		try {
			ostream = new ObjectOutputStream(new FileOutputStream("C:/Users/userg/Documents/CIPSA/claves.dat"));
		} catch (FileNotFoundException e) {
			System.out.println("1" + e.getMessage());
		} catch (IOException e) {
			System.out.println("2" + e.getMessage());
		} finally {
			try {
				if (ostream != null) {
					ostream.flush();
					ostream.close();
					System.out.println("Datos introducidos con exito");
				}
			} catch (IOException e) {
				System.out.println("3" + e.getMessage());
			}
		}
	}

	public static void GuardarUsuarios(Usuario[] listadoUsuario) {
		ObjectOutputStream ostream = null;

		try {
			ostream = new ObjectOutputStream(new FileOutputStream("C:/Users/userg/Documents/CIPSA/claves.dat"));
		} catch (FileNotFoundException e) {
			System.out.println("1" + e.getMessage());
		} catch (IOException e) {
			System.out.println("2" + e.getMessage());
		} finally {
			try {
				if (ostream != null) {
					ostream.flush();
					ostream.close();
					System.out.println("Datos introducidos con exito");
				}
			} catch (IOException e) {
				System.out.println("3" + e.getMessage());
			}
		}
	}

	// Deserializa el objeto Persona:
	public static Usuario[] LeerUsuario() {

		ArrayList<Usuario> listadoUsuario = new ArrayList<Usuario>();
		ObjectInputStream istream = null;
		Usuario u;

		try {
			istream = new ObjectInputStream(
					new FileInputStream("C:/Users/userg/Documents/CIPSA/personaSerializable.dat"));
			while (true) {
				u = (Usuario) istream.readObject(); // el objeto deserializado puede pertenecer a cualquier
													// clase(Instancia Objeto) casting
				listadoUsuario.add(u);
			}

		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Error E/S ");
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no existe");
		} finally {

			try {
				if (istream != null)
					istream.close();
				System.out.println("Fichero_Binario cerrado");
			} catch (IOException e) {
			}
		}
		Usuario[] pArray = new Usuario[listadoUsuario.size()];

		return listadoUsuario.toArray(pArray);
	}

	public static void mostrarLista(Usuario[] usuarios) {
		for (int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
	}

	public static void busqueda(String user, long log) {

		String usuario = null;
		Long password = (long) 0;

		boolean encontrado = false;  
		for (int i = 0; i < listaUsuarios.size() && !encontrado; i++) {
			if (listaUsuarios.get(i).getUser().equals(user)) {
				usuario = user;
				if (listaUsuarios.get(i).getLog() == (log)) {
					password = log;
					System.out.println("Bienvenido" + " " + user);	
					encontrado = true;
				} else {
					System.out.println("Contraseña incorrecta");
					encontrado = true; 
				}
			}
		}
		if (usuario.equals(null) && password == 0) {
			System.out.println("Usuario no reconocido");
		}
	}

	@Override
	public String toString() {
		return "Usuario [user=" + user + ", log=" + log + "]";
	}

}
