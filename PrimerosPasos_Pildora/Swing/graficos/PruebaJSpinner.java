package graficos;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class PruebaJSpinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoSpinner mimarco = new MarcoSpinner();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoSpinner extends JFrame {

	public MarcoSpinner() {

		setTitle("Prueba Spinner");
		setBounds(500, 300, 450, 300);
		LaminaSpinner milamina = new LaminaSpinner();
		add(milamina);
		setVisible(true);
	}
}

class LaminaSpinner extends JPanel {

	public LaminaSpinner() {

		// String lista[] =
		// GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		// JSpinner control = new JSpinner(new SpinnerListModel(lista));

		//JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 2));
		
		//JSpinner control = new JSpinner(new MiModeloJspinner());
		
		JSpinner control = new JSpinner(new SpinnerNumberModel(5,0,10,1){ // en vez de crear una clase privada----> podemos crear una clase interna anonima.
			
			public Object getNextValue() {

				return super.getPreviousValue();
			}

			public Object getPreviousValue() {

				return super.getNextValue();
			}
			
		});
		
		Dimension d = new Dimension(200, 20);
		control.setPreferredSize(d);
		add(control);

	}

	/*private class MiModeloJspinner extends SpinnerNumberModel {

		public MiModeloJspinner() {

			super(5, 0, 10, 1);
		}

		// Invirtiendo por defecto de la clase SpinnerNumberModel el sentido de las flechas
		
		public Object getNextValue() {

			return super.getPreviousValue();
		}

		public Object getPreviousValue() {

			return super.getNextValue();
		}
	}*/

}
