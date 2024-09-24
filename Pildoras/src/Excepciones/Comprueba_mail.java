package Excepciones;

import java.io.EOFException;

import javax.swing.*;

public class Comprueba_mail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String el_email=JOptionPane.showInputDialog("Introduce mail");
		
		try {
	
		examina_mail(el_email);

	}catch(EOFException e) {
		System.out.println("La direccion de email no es correcta");
	}
	
	}
	
	static void examina_mail(String mail) throws EOFException { //End Of File Exception. error al encontrar un fichero.
		
		int arroba=0;
		boolean punto=false;
		
		if(mail.length()<=3){
			
			//ArrayIndexOutOfBoundsException mi_excepcion=new ArrayIndexOutOfBoundsException(); excepción no controlada. No obligado a crear un try-catch
			throw new EOFException(); //throw sin s final != throws. Esta Exception va a ser provocado si o si. Se instancia la clase directamente
			
			
		}else {
		
		for(int i=0; i<mail.length(); i++) {
			if(mail.charAt(i)=='@') {
				arroba++;
			}
			if(mail.charAt(i)=='.') {
				punto=true;
			}
			
		}
		
		if(arroba==1 && punto==true) {
			System.out.println("Es correcto");
		}
		else {
			System.out.println("No es correcto");
		}
	}
		
	}

}
