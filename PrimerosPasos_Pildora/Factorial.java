import javax.swing.*;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Long resultado=1L;
		
		int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
		
		for(int i=numero;i>0;i--) {  //i=4=numero --> 4*1=4; i=3=numero --> 3*4=12; i=2=numero --> 2*12=24; i=1=numero -->1*24=24; i=0 -->no se ejecuta
			
			resultado=resultado*i; 
		}
	
		System.out.println("El factorial de " + numero + " es " +resultado);
	}
	
}
