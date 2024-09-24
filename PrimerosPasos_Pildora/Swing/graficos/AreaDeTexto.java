package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AreaDeTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAreaTexto mimarco = new MarcoAreaTexto();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoAreaTexto extends JFrame {

	public MarcoAreaTexto() {

		setTitle("AreaTexto");
		setBounds(500, 300, 450, 300);
		LaminaAreaTexto milamina = new LaminaAreaTexto();
		add(milamina);
		setVisible(true);
	}
}

class LaminaAreaTexto extends JPanel {
	
	private JTextArea miarea;
	
	public LaminaAreaTexto() {
		miarea=new JTextArea(8,20);
		
		JScrollPane laminaBarras=new JScrollPane(miarea);// barra de desplazamiento vertical
		
		miarea.setLineWrap(true);// para que haga salto de linea directamente
		add(laminaBarras);
		
		JButton miboton=new JButton("Dale");
		miboton.addActionListener(new GestionArea());
		add(miboton);
	}
	
	private class GestionArea implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(miarea.getText());
		}
		
	}

}




