package graficos;
import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		miMarco marco1=new miMarco();
	
	}

}

class miMarco extends JFrame{
	
	public miMarco() {

		//setSize(500, 300);
		
		//setLocation(500,300);
		
		setBounds(400,100,550,550);//abarca los dos metodos anteriores, (posicion y tamaño)
		
		//setResizable(false); //Para no poder maximizar ni cambiar el tamaño
		
		//setExtendedState(Frame.MAXIMIZED_BOTH); //Maximiza a toda la pantalla.
		
		setTitle("Mi ventana");

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
