package graficos;

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
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class VariasFuente_unicoOyente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAccion3 mimarco = new MarcoAccion3();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}
}

class MarcoAccion3 extends JFrame {

	public MarcoAccion3() {
		setTitle("Botone y Eventos_3");
		setVisible(true);
		setBounds(300, 300, 500, 350);
		PanelAccion3 lamina = new PanelAccion3();
		add(lamina);
	}
}

class PanelAccion3 extends JPanel { 

	public PanelAccion3() {

		AccionColor3 accionAmarillo = new AccionColor3("Amarillo", new ImageIcon("Swing/graficos/Amarillo.gif"), Color.yellow);
		AccionColor3 accionVerde = new AccionColor3("Verde", new ImageIcon("Swing/graficos/verde.gif"), Color.green);
		AccionColor3 accionRojo = new AccionColor3("Rojo", new ImageIcon("Swing/graficos/rojo.gif"), Color.red);

		add(new JButton(accionAmarillo));
		add(new JButton(accionVerde));
		add(new JButton(accionRojo));
		
		//Crear un Mapa de entrada
		InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//Crear atajo de teclado y Asignando un key-value
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl V"), "fondo_verde");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
		//Asignar el objeto a la accion
		ActionMap mapaAccion=getActionMap();
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_verde", accionVerde);
		mapaAccion.put("fondo_rojo", accionRojo);
	}

	private class AccionColor3 extends AbstractAction {

		public AccionColor3(String nombre, ImageIcon icono, Color color_boton) {
			// TODO Auto-generated constructor stub
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color" + nombre);
			putValue("color_de_fondo", color_boton);
		}

		public void actionPerformed(ActionEvent e) {

			Color c = (Color) getValue("color_de_fondo");

			setBackground(c);

			System.out.println("Nombre:" + getValue(Action.NAME));
		}

	}

}

