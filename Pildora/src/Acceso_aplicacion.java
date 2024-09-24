
import javax.swing.*;

public class Acceso_aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String clave="Arkaitz";
		
		String pass="";
		
		while(clave.equals(pass)==false) { //metodo equals para comparar dos cadenas de texto "String"
			
			pass=JOptionPane.showInputDialog("Introduce la contraseña, por favor");
			
			if(clave.equals(pass)==false) {
				
				System.out.println("Contraseña incorrecta");
			}
			
		}
		
		System.out.println("Contraseña correcta. Acceso permitido");
	}

}

