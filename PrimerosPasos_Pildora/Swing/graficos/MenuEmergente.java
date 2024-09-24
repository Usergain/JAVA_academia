package graficos;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Document;

public class MenuEmergente {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoEmergente mimarco = new MarcoEmergente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class MarcoEmergente extends JFrame {

	public MarcoEmergente() {
		setTitle("");
		setVisible(true);
		setBounds(300, 300, 500, 350);
		LaminaEmergente lamina = new  LaminaEmergente();
		add(lamina);
	}
}

class LaminaEmergente extends JPanel {

	public LaminaEmergente() {
		setLayout(new BorderLayout());
		JPanel laminamenu=new JPanel();
		
		JMenuBar mibarra=new JMenuBar();
		
		JMenu fuente=new JMenu("Fuente");
		JMenu estilo=new JMenu("Estilo");
		JMenu tamagno=new JMenu("Tamaño");
		
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamagno);
		
		laminamenu.add(mibarra);
		add(laminamenu, BorderLayout.NORTH);
		
		JTextPane miarea=new JTextPane();
		add(miarea, BorderLayout.CENTER);
	//------------------------------------------------------------------------------
		JPopupMenu emergente=new JPopupMenu();
		JMenuItem opcion1=new JMenuItem("Opcion1");
		JMenuItem opcion2=new JMenuItem("Opcion2");
		JMenuItem opcion3=new JMenuItem("Opcion3");
		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);
		miarea.setComponentPopupMenu(emergente);
		
	}

}
