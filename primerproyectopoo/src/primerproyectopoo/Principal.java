package primerproyectopoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		setBounds(100, 100, 895, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Nombre");
		btnNewButton.setBounds(63, 52, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(173, 53, 388, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tu nombre es:");
		lblNewLabel.setBounds(65, 115, 76, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 112, 320, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete"}));
		comboBox.setBounds(546, 210, 76, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText("Has pulsado el boton");
				//textField_1.setText("Has pulsado el boton");
				if (textField.getText().length()!=0) {
					textField_1.setText(textField.getText());
					textField.enable(false);
					JOptionPane.showConfirmDialog(btnNewButton_1, comboBox.getSelectedItem().toString());
				}
				else{
					JOptionPane.showConfirmDialog(btnNewButton_1, "No hay datos introducidos en el textbox, por favor rellenalo antes");
				}
			}
		});
		btnNewButton_1.setBounds(329, 267, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
