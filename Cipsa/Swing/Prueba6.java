import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;

public class Prueba6 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba6 frame = new Prueba6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prueba6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider slider = new JSlider();
		// Configuracion del componente
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setValue(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);
		slider.setBounds(27, 94, 378, 76);

		// Coleccion de etiquetas
		Hashtable<Integer, JLabel> coleccion;
		coleccion = new Hashtable<Integer, JLabel>();
		coleccion.put(0, new JLabel("HELADO"));
		coleccion.put(50, new JLabel("LIQUIDO"));
		coleccion.put(100, new JLabel("HIRVIENDO"));
		slider.setLabelTable(coleccion);

		contentPane.add(slider);
	}

}
