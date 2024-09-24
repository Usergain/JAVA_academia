
import javax.swing.*; 

public class Entrada_Numeros {

	public static void main(String[] args) {
		//double x=10000.0;
		
		//System.out.printf("%1.2f",x/3);
		
		String num1=JOptionPane.showInputDialog("Introduce un número"); //al se estatico la clase va por delante del metodo.
		
		double num2=Double.parseDouble(num1); // al ser estatico la clase va por delante del metodo. Estamos pasando un dato tipo String a double.
		
		System.out.print("La raiz de " + num2 + " es ");
		
		System.out.printf("%1.2f",Math.sqrt(num2));
	}

}
