import javax.swing.*;

public class Entrada_ejemplo2 {

	public static void main(String[] args) {
		
		String nombre_usuario=JOptionPane.showInputDialog("Introduce un nombre, por favor");
		
		String edad=JOptionPane.showInputDialog("Introduce la edad, por favor"); //lo declaramos como String por que el metodo solo devuelve String
		
		//System.out.println("Hola " + nombre_usuario + " . El a�o que viene tendr�s " + (edad+1) + " a�os"); //al ser tipo String al sumar edad+1 lo concatena :181 a�os
		
		int edad_usuario=Integer.parseInt(edad);
		
		System.out.println("Hola " + nombre_usuario + " . El a�o que viene tendr�s " + (edad_usuario+1) + " a�os");
		
	}

}
