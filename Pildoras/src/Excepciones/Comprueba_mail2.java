package Excepciones;

import javax.swing.JOptionPane;

public class Comprueba_mail2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String el_email=JOptionPane.showInputDialog("Introduce mail");
		
		try {
		
		examina_mail(el_email);

		System.out.println("La direccion de email no es correcta");
		
		}catch(Exception e){
			
			System.out.println("La direccion no es correcta");
			
			e.printStackTrace(); //pila de errores, para que aparezca por pantalla. Que tipo de errores
		}
	}
	
	
	static void examina_mail(String mail) throws Longitud_mail_erronea {
		
		int arroba=0;
		boolean punto=false;
		
		if(mail.length()<=3){
			
			throw new Longitud_mail_erronea("El mail no puede tener menos de tres caracteres");
			
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

class Longitud_mail_erronea extends Exception{ //Una exception propia-siempre dos constructores.
	
	public Longitud_mail_erronea() {}//Constructor sin parámetros
	
	public Longitud_mail_erronea(String msj_error) {//constructor
		super(msj_error); //Llamando al constructor de la clase padre y pasando del parametro msj_error
	}
	
	
}
	
	


