package laeconBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class insertarAutor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertarAutor frame = new insertarAutor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	int comprobar() {
		int contador = 0;

		if (textField.getText().length() == 0) {
			contador++;
		}
		if (textField_1.getText().length() == 0) {
			contador++;
		}
		if (textField_2.getText().length() == 0) {
			contador++;
		}
		if (textField_3.getText().length() == 0) {
			contador++;
		}
		if (textField_4.getText().length() == 0) {
			contador++;
		}

		return contador;
	}

	/**
	 * Create the frame.
	 */
	public insertarAutor() {
		setTitle("Insertar Autor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Por favor, introduce los siguientes datos para dar de alta a un autor:");
		lblNewLabel.setBounds(33, 36, 555, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setBounds(34, 85, 46, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(105, 82, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(33, 134, 63, 14);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(105, 131, 135, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Apellidos:");
		lblNewLabel_3.setBounds(34, 189, 62, 14);
		contentPane.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(105, 186, 135, 20);
		contentPane.add(textField_2);

		JLabel lblNewLabel_4 = new JLabel("Nacionalidad:");
		lblNewLabel_4.setBounds(33, 247, 129, 14);
		contentPane.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(105, 244, 135, 20);
		contentPane.add(textField_3);

		JLabel lblNewLabel_5 = new JLabel("F.Nac:");
		lblNewLabel_5.setBounds(33, 310, 63, 14);
		contentPane.add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setBounds(105, 307, 135, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("Insertar");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = comprobar();
				if (resultado != 0) {
					JOptionPane.showMessageDialog(null, "Debes de rellenar todos los campos");
				} else {
					// Justamente aqui estan todas las casillas rellenas
					conexionBD con = new conexionBD();
					con.conectar();
					try {
						Autor autorinsertar = new Autor(Integer.parseInt(textField.getText()), textField_1.getText(),
								textField_2.getText(), textField_3.getText(), textField_4.getText());
						// con.insertarAutor(Integer.valueOf(textField.getText()),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
						con.insertarAutor1(autorinsertar);

						limpiarCampos();

					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					con.desconectar();
				}
			}
		});
		btnNewButton.setBounds(45, 371, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnNewButton_1.setBounds(307, 371, 89, 23);
		contentPane.add(btnNewButton_1);
	}

	public void limpiarCampos() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
	}
}
