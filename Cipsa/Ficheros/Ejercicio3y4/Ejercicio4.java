package Ejercicio3y4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Ejercicio4.CuentaCorriente;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Usuario>listaUsuarios= new ArrayList<Usuario>();
		
		Usuario u= new Usuario ("Joaquin",65345234);
		listaUsuarios.add(u);
		Usuario u2= new Usuario ("Bernarda", 69696969);
		listaUsuarios.add(u2);
		Usuario u3= new Usuario ("Andres",789453216);
		listaUsuarios.add(u3);
		Usuario u4= new Usuario ("Jose", 14883803);
		listaUsuarios.add(u4);
		Usuario u5= new Usuario ("fdklsjfklj",87657465);
		listaUsuarios.add(u5);
		Usuario u6=new Usuario ("DFAKLS",98765321);
		listaUsuarios.add(u6);
		
		Usuario usuario=new Usuario(listaUsuarios);
		
		//public static HashMap<String, long> usuarios = new HashMap<>();
		
		Scanner sc=new Scanner(System.in);
		String user;
		Long log;
		//HashMap<Integer, Long> map = new HashMap<>();
		
		System.out.println("Dame nombre de Usuario:");
		user=sc.nextLine();
		System.out.println("Dame contraseña de Usuario:");
		log=sc.nextLong();
		
		//Usuario userg=new Usuario(user,log);
		
		usuario.busqueda(user,log);
		
	}


}
