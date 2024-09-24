import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;

public class Prueba5 extends JFrame {

	private JPanel contentPane;
	private JLabel lblValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba5 frame = new Prueba5();
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
	public Prueba5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				int valor = slider.getValue(); 
				lblValor.setText(String.valueOf(valor));
			}
		});
		slider.setBounds(15, 81, 404, 85);
		contentPane.add(slider);
		
		lblValor = new JLabel("");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 26));
		slider.setMinimum(20);
		slider.setMaximum(80);
		slider.setValue(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(5);
		lblValor.setBounds(306, 29, 69, 36);
		contentPane.add(lblValor);
	}

}
