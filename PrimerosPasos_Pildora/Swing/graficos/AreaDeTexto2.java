package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.AncestorListener;

public class AreaDeTexto2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAreaTexto2 mimarco = new MarcoAreaTexto2();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoAreaTexto2 extends JFrame {

	public MarcoAreaTexto2() {

		setTitle("AreaTexto2");
		setBounds(500, 300, 450, 300);
		setLayout(new BorderLayout());
		laminaBotones = new JPanel();
		botonInsertar = new JButton("Insertar");
		botonInsertar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				areaTexto.append("En un lugar de la Mancha cuyo nombre no quiero acordarme...");
			}
		});
		
		laminaBotones.add(botonInsertar);
		botonSaltoLinea=new JButton("Salto Linea");
		botonSaltoLinea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean saltar=!areaTexto.getLineWrap();
				
				areaTexto.setLineWrap(saltar);
				
				if(saltar) {
					botonSaltoLinea.setText("Quitar salto");
				}else {
					botonSaltoLinea.setText("Salto linea");
				}
				
				/*Operadores ternarios:
				 * botonSaltoLinea.setText(saltar? "Quitar salto" : "Salto Linea");
				 * */
			}
			
		});
		
		laminaBotones.add(botonSaltoLinea);
		add(laminaBotones, BorderLayout.SOUTH);
		
		areaTexto=new JTextArea(8,20);
		
		laminaConBarras=new JScrollPane(areaTexto);
		add(laminaConBarras, BorderLayout.CENTER);

	}
	
	private JPanel laminaBotones;
	private JButton botonInsertar, botonSaltoLinea;
	private JTextArea areaTexto;
	private JScrollPane laminaConBarras;
}





