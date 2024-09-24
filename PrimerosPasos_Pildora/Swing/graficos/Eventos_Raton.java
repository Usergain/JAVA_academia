package graficos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Eventos_Raton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRaton mimarco = new MarcoRaton();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoRaton extends JFrame {
	public MarcoRaton() {
		setVisible(true);
		setBounds(700, 300, 600, 450);
		
		EventosDeRaton raton=new EventosDeRaton();
		addMouseListener(raton);
		//addMouseMotionListener(raton); Para detectar el movimiento del raton
	}
}

class EventosDeRaton implements MouseListener, MouseMotionListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Has hecho click: " + "Coordenada X: " + e.getX() +" Coordenada Y: " + e.getY() );
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("Has pulsado el boton izquierdo");
		}
		else if(e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK) {
			System.out.println("Has pulsado la rueda");
		}

		else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK) {
			System.out.println("Has pulsado el buton derecho");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	System.out.println("Acabas de entrar");	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de salir");
	}
//metodos de MouseMotionMoved
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Estas moviendo el raton");
	}
	
}