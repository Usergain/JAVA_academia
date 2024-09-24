package graficos;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaAccion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAccion2 mimarco = new MarcoAccion2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}
}

class MarcoAccion2 extends JFrame {

	public MarcoAccion2() {
		setTitle("Botone y Eventos_2");
		setVisible(true);
		setBounds(300, 300, 500, 350);
		LaminaBotones2 lamina = new LaminaBotones2();
		add(lamina);
	}
}

class LaminaBotones2 extends JPanel {

	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonVerde = new JButton("Verde");
	JButton botonRojo = new JButton("Rojo");

	public LaminaBotones2() {

		add(botonAmarillo);
		ColorFondo2 Amarillo = new ColorFondo2(Color.yellow);
		botonAmarillo.addActionListener(Amarillo);
		add(botonVerde);
		ColorFondo2 Verde = new ColorFondo2(Color.green);
		botonVerde.addActionListener(Verde);
		ColorFondo2 Rojo = new ColorFondo2(Color.red);
		add(botonRojo);
		botonRojo.addActionListener(Rojo);

	}

	private class ColorFondo2 implements ActionListener {

		private Color colorDeFondo;

		public ColorFondo2(Color c) {
			colorDeFondo = c;
		}

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setBackground(colorDeFondo);
		}

	}

}

