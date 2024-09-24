

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Prueba extends JFrame {

	private JPanel contentPane;
	private JLabel lblContador;
	
	private int contador;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
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
	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMas = new JButton("+");
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control(e);
			}
		});
		btnMas.setBounds(26, 96, 115, 29);
		contentPane.add(btnMas);
		
		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control(e);
			}
		});
		btnMenos.setBounds(266, 96, 115, 29);
		contentPane.add(btnMenos);
		
		lblContador = new JLabel("0");
		lblContador.setBounds(192, 100, 20, 20);
		contentPane.add(lblContador);
	}
	private void control( ActionEvent ev) { 
		 switch( ev.getActionCommand()) { 
		 case "+": 
		 contador++; break; 
		 case "-": 
		 contador--; break; 
		 } 
		 // visualizacion del valor actualizado
		 this.lblContador.setText(String.valueOf(contador)); 
		 }
}
