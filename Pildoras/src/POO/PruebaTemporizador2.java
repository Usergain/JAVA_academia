package POO;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Reloj mireloj=new Reloj(3000,true); Solo para constructor de clase interna.
		
		Reloj mireloj=new Reloj();
		
		mireloj.enMarcha(3000,true); // clase interna local
		
		JOptionPane.showInternalMessageDialog(null, "Pulsa aceptar para terminar");
		System.exit(0);
		

	}

}

class Reloj{
	
	//Se necesita constructor para clase interna
	/*public Reloj(int intervalo, boolean sonido) {
		this.intervalo=intervalo;
		this.sonido=sonido;
		
	}*/
	
	public void enMarcha(int intervalo, final boolean sonido) {
		
		class DameLaHora2 implements ActionListener{ //Esta es la clase interna local en vez de la clase interna del anterior ejercicio
			public void actionPerformed(ActionEvent evento) {
				
				Date ahora=new Date();
				System.out.println("Te pongo la hora cada 3 seg." + ahora);
				if(sonido) { //teine que llevar final para parametros que se utilizen en clases  interna locales
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		
		ActionListener oyente=new DameLaHora2();//DameLaHora2 quiero que sea una clase interna
		Timer mitemporizador=new Timer(intervalo,oyente);
		mitemporizador.start();
		
	}
	
	
	//Como clase interna
	
	/*private int intervalo;
	
	private boolean sonido;*/
	
	
	/*private class DameLaHora2 implements ActionListener{ //Esta es la clase interna. Por eso accede a los campos de ejemplar sin utilizar un get ni set
		public void actionPerformed(ActionEvent evento) {
			Date ahora=new Date();
			System.out.println("Te pongo la hora cada 3 seg." + ahora);
			if(sonido) {
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}*/
}