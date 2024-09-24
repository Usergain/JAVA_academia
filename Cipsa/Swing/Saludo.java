import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Saludo extends JFrame {

	private JPanel contentPane;
	private JTextField jtxtfield;
	private JLabel jlblSaludo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saludo frame = new Saludo();
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
	public Saludo() {
		setTitle("SALUDAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jlblSaludo = new JLabel("");
		jlblSaludo.setIcon(new ImageIcon(Saludo.class.getResource("/iconos/497738.png")));
		jlblSaludo.setBounds(35, 119, 266, 58);
		contentPane.add(jlblSaludo);
		
		jtxtfield = new JTextField();
		jtxtfield.setBounds(35, 24, 146, 26);
		contentPane.add(jtxtfield);
		jtxtfield.setColumns(10);
		
		JButton btnNewButton = new JButton("Saludar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnSaludar_Click(e);
			}
		});
		btnNewButton.setBounds(212, 23, 115, 29);
		contentPane.add(btnNewButton);
	}
	

	// Método de atención al evento 
	private void jbtnSaludar_Click( ActionEvent e ) { 
		// Se lee el nombre escrito en la caja de texto. 
		 String nombre = this.jtxtfield.getText(); 
		// ¿Es el nombre vacio? 
		 if ( !nombre.isEmpty()) { 
		 this.jlblSaludo.setText("HOLA " + nombre ); 
		 } else { 
		 // Se muestra mensaje de advertencia. 
		 javax.swing.JOptionPane.showMessageDialog(this, 
		 "Debe introducir un nombre", "Falta nombre", 
		 javax.swing.JOptionPane.INFORMATION_MESSAGE); 
		 } 
		 
	 }

}
