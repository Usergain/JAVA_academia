package Ejercicio3y4;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		String user;
		long log;
		
		System.out.println("Dame nombre de Usuario:");
		user=sc.nextLine();
		System.out.println("Dame contraseña de Usuario:");
		log=sc.nextLong();
		
		Usuario usuario=new Usuario(user,log);
		
		usuario.GuardarPersona(usuario);
		
	}

}
