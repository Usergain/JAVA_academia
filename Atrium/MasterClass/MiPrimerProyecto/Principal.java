package MiPrimerProyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(42, 59, 80, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(142, 56, 258, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tu Nombre es:");
		lblNewLabel_1.setBounds(42, 96, 109, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 93, 225, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		// Este codigo del combo lo hemos movido para que pueda interacturar con los demas botones, va antes de los demás
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"}));
		comboBox.setBounds(285, 190, 120, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText("Has pulsado el boton");
				//textField_1.setText("Has pulsado el boton");
				if (textField.getText().length()!=0)
				{
					textField_1.setText(textField.getText()); // imprimiria en el textbox 2 lo introducido en el textbox1, esto lo implementamos
					textField.enable(false); // despues de meter dato no puedo modificarlo, no está abilitado
					JOptionPane.showConfirmDialog(btnNewButton, comboBox.getSelectedItem().toString());	
				}
				else
				{
					JOptionPane.showConfirmDialog(btnNewButton, "No hay datos introducidos en el textbox, por favor rellenalo antes"); // para que diese un mensane, implementado por nosotros
				}
			}
		});
		btnNewButton.setBounds(90, 229, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}

