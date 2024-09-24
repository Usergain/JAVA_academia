package graficos;

import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConTexto mimarco=new MarcoConTexto();
		
		Lamina lamina=new Lamina();
		
		mimarco.add(lamina);

	}

}

class MarcoConTexto extends JFrame{
	
	public MarcoConTexto(){
		
		setVisible(true);
		setSize(600,450);
		setLocation(400,200);
		setTitle("Primer texto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Lamina extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawString("Estamos aprendiendo Swing", 200, 100);
	}
}
