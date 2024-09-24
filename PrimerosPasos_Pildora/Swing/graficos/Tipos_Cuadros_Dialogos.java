package graficos;

import java.awt.event.*;
import javax.swing.*;


public class Tipos_Cuadros_Dialogos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadros_Dialogos mimarco=new Cuadros_Dialogos();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class Cuadros_Dialogos extends JFrame{
	public Cuadros_Dialogos() {
		setBounds(500,300,400,250);
		add(new Lamina_Cuadros_Dialogos());
	}
}

class Lamina_Cuadros_Dialogos extends JPanel{
	
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	
	public Lamina_Cuadros_Dialogos() {
		
		boton1=new JButton("boton 1");
		boton2=new JButton("boton 2");
		boton3=new JButton("boton 3");
		boton4=new JButton("boton 4");
		
		boton1.addActionListener(new Accion_botones());
		boton2.addActionListener(new Accion_botones());
		boton3.addActionListener(new Accion_botones());
		boton4.addActionListener(new Accion_botones());
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
	
	}

	private class Accion_botones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == boton1) {
				//System.out.println("Has pulsado el boton 1");
				//JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this, "Mensaje de prueba");
				JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this, "Mensaje de prueba", "Advertencia", 0);// El ultimo algumento es el tipo de icono
			} else if (e.getSource() == boton2) {
				//System.out.println("Has pulsado el boton 2");
				JOptionPane.showInputDialog(Lamina_Cuadros_Dialogos.this, " Introduce nombre", "datos", 2);
			} else if (e.getSource() == boton3) {
				//System.out.println("Has pulsado el boton 3");
				JOptionPane.showConfirmDialog(Lamina_Cuadros_Dialogos.this, "Elige opcion",	 "V confirmar", 1);
			} else if (e.getSource() == boton4) {
				//System.out.println("Has pulsado el boton 4");
				JOptionPane.showOptionDialog(Lamina_Cuadros_Dialogos.this, "Elige opcion",	 "V confirmar", 1, 1, null, null, null);
			}
		}

	}
}