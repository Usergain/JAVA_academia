package graficos;

import java.awt.Font;

import javax.swing.*;

public class PruebaJSlider {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoSlider mimarco = new MarcoSlider();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoSlider extends JFrame {

	public MarcoSlider() {

		setTitle("Prueba Slider");
		setBounds(500, 300, 450, 300);
		LaminaSlider milamina = new LaminaSlider();
		add(milamina);
		setVisible(true);
	}
}

class LaminaSlider extends JPanel {

	public LaminaSlider() {
		
		//JSlider control=new JSlider(SwingConstants.VERTICAL,20,100,25);
		JSlider control=new JSlider(20,100,25);
		control.setMajorTickSpacing(50);
		control.setMinorTickSpacing(25);
		control.setPaintTicks(true);
		control.setFont(new Font("Serif",Font.ITALIC,12));
		control.setPaintLabels(true);
		control.setSnapToTicks(true); // iman, lleva a la marca siguiente.
		//control.setOrientation(SwingConstants.VERTICAL);
		add(control);

	}

}
