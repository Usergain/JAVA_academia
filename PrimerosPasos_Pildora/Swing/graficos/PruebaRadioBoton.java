package graficos;

import javax.swing.*;

public class PruebaRadioBoton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			MarcoRadioBoton mimarco = new MarcoRadioBoton();
			mimarco.setVisible(true);
			mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	class MarcoRadioBoton extends JFrame {

		public MarcoRadioBoton() {

			setTitle("Prueba RadioBoton");
			setBounds(500, 300, 450, 300);
			LaminaRadioBoton milamina = new LaminaRadioBoton();
			add(milamina);
			setVisible(true);
		}
	}

	class LaminaRadioBoton extends JPanel {

		public LaminaRadioBoton() {
			
			ButtonGroup migrupo1=new ButtonGroup();
			ButtonGroup migrupo2=new ButtonGroup();
			
			JRadioButton boton1=new JRadioButton("Azul", false);
			JRadioButton boton2=new JRadioButton("Rojo", true);
			JRadioButton boton3=new JRadioButton("Verde", false);
			
			JRadioButton boton4=new JRadioButton("Masculino", false);
			JRadioButton boton5=new JRadioButton("Femenino", false);
			
			migrupo1.add(boton1);
			migrupo1.add(boton2);
			migrupo1.add(boton3);
			migrupo2.add(boton4);
			migrupo2.add(boton5);
			
			add(boton1);
			add(boton2);
			add(boton3);
			add(boton4);
			add(boton5);
	}

}
