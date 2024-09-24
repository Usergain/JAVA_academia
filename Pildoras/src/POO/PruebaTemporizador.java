package POO;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.*;

public class PruebaTemporizador {

	public static void main(String[] args) {
		
		//ActionListener oyente=new DameLaHora()
		DameLaHora oyente=new DameLaHora();

		Timer miTemporizador=new Timer(5000,oyente); //eventos 
		
		miTemporizador.start(); //Utilizaremos JOptionPane para que se quede en ejecuacion hasta que cerremos sino no no podríamos ver el metodo start
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
		System.exit(0);
	}

}

class DameLaHora implements ActionListener{ //hay que crear interface para poder instanciar clase Timer
	
	public void actionPerformed(ActionEvent e) { //metodo obligatorio para interface ActionListener
		Date ahora=new Date();
		System.out.println("Te pongo la hora cada 5 segundos " + ahora);
		java.awt.Toolkit.getDefaultToolkit().beep(); //para que suene campana de windows Clase abstracta "Toolkit"
		
	}
}
