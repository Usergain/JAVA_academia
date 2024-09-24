package graficos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class CambioEstado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoEstado mimarco=new MarcoEstado();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoEstado extends JFrame{
	
	public MarcoEstado(){
		setVisible(true);
		setBounds(300,300,500,350);
		
		CambiaEstado nuevo_estado=new CambiaEstado();
		addWindowStateListener(nuevo_estado);
	}
}

class CambiaEstado implements WindowStateListener{

	@Override
	public void windowStateChanged(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("La ventana a cambiado de estado");
		
		//System.out.println(e.getNewState()); te da un numero segun su estado
		
		if(e.getNewState()==6) {
			System.out.println("La ventana está a pantalla completa");
		}
		else if(e.getNewState()==0) {
			System.out.println("La pantalla está en pantalla normal");
		}
		else if(e.getNewState()==Frame.ICONIFIED) {
			System.out.println("La ventana está minimizada");
		}
		
	}
	
}
