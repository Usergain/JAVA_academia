package graficos;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaAcciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAccion1 mimarco = new MarcoAccion1();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoAccion1 extends JFrame {

	public MarcoAccion1() {
		setTitle("Botone y Eventos_1");
		setVisible(true);
		setBounds(300, 300, 500, 350);
		LaminaBotones1 lamina = new LaminaBotones1();
		add(lamina);
	}
}

class LaminaBotones1 extends JPanel implements ActionListener {

	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonVerde = new JButton("Verde");
	JButton botonRojo = new JButton("Rojo");

	public LaminaBotones1() {

		add(botonAmarillo);
		botonAmarillo.addActionListener(this);
		add(botonVerde);
		botonVerde.addActionListener(this);
		add(botonRojo);
		botonRojo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object botonPulsado = e.getSource();
		if (botonPulsado == botonAmarillo) {
			setBackground(Color.YELLOW);
		} else if (botonPulsado == botonVerde) {
			setBackground(Color.GREEN);
		} else if (botonPulsado == botonRojo) {
			setBackground(Color.RED);
		}
	}

}


