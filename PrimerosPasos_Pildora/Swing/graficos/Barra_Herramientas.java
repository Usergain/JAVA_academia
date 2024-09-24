package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Barra_Herramientas {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBarraHerramientas mimarco = new MarcoBarraHerramientas();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}
}

class MarcoBarraHerramientas extends JFrame {

	private JPanel lamina;

	public MarcoBarraHerramientas() {
		
		setTitle("Marco con Barra");
		setVisible(true);
		setBounds(300, 300, 500, 350);
		lamina = new JPanel();
		add(lamina);
		
		Action accionAmarillo = new AccionColor("Amarillo", new ImageIcon("Swing/graficos/Amarillo.gif"), Color.yellow);
		Action accionVerde = new AccionColor("Verde", new ImageIcon("Swing/graficos/verde.gif"), Color.green);
		Action accionRojo = new AccionColor("Rojo", new ImageIcon("Swing/graficos/rojo.gif"), Color.red);
		Action accionSalir = new AbstractAction("Salir", new ImageIcon("Swing/graficos/salir.gif")) {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		};
		
		JMenu menu=new JMenu("Color");
		menu.add(accionAmarillo);
		menu.add(accionRojo);
		menu.add(accionVerde);
		
		JMenuBar barra_menu=new JMenuBar();
		barra_menu.add(menu);
		
		setJMenuBar(barra_menu);
		
		//Construccion barra de herramientas
		
		JToolBar barra=new JToolBar();
		barra.add(accionRojo);
		barra.add(accionVerde);
		barra.add(accionAmarillo);
		barra.addSeparator();
		barra.add(accionSalir);
		
		//Para poder arrastrar la barra a donde queramos
	
		add(barra, BorderLayout.NORTH);
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------
	private class AccionColor extends AbstractAction {

		public AccionColor(String nombre, ImageIcon icono, Color c) {
			// TODO Auto-generated constructor stub
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color" + nombre);
			putValue("color_de_fondo", c);
		}

		public void actionPerformed(ActionEvent e) {

			Color c = (Color) getValue("color_de_fondo");

			lamina.setBackground(c);

			System.out.println("Nombre:" + getValue(Action.NAME));
		}

	}

}


