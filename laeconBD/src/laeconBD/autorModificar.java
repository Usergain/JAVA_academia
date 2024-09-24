package laeconBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class autorModificar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					autorModificar frame = new autorModificar();
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
	public autorModificar() {
		setTitle("Modificar los datos de un Autor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPorFavorIntroduce = new JLabel("Por favor introduce la id del autor que deseas modificar:");
		lblPorFavorIntroduce.setBounds(10, 34, 555, 14);
		contentPane.add(lblPorFavorIntroduce);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setBounds(11, 83, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(82, 80, 135, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 132, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(82, 129, 135, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos:");
		lblNewLabel_3.setBounds(11, 187, 62, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(82, 184, 135, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("Nacionalidad:");
		lblNewLabel_4.setBounds(10, 245, 129, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conexionBD bd = new conexionBD();
				bd.conectar();
				Autor am = new Autor(Integer.parseInt(textField.getText()),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
				try {
					bd.modificarAutor(am);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bd.desconectar();
			}
		});
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(255, 128, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(82, 242, 135, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_5 = new JLabel("F.Nac:");
		lblNewLabel_5.setBounds(10, 308, 63, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(82, 305, 135, 20);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (textField.getText().length()!=0)
			{
				conexionBD bd = new conexionBD();
				bd.conectar();
				try {
					if (bd.comprobaridAutor(Integer.parseInt(textField.getText())))
					{
						//Tengo al autor y lo que vamos  a hacer es traernos sus datos de base de datos.
						try {
							Autor autoramodificar = bd.obtenerDatosAutor(Integer.parseInt(textField.getText()));
							textField_1.setEnabled(true);
							textField_2.setEnabled(true);
							textField_3.setEnabled(true);
							textField_4.setEnabled(true);
							textField.setEnabled(false);
							textField_1.setText(autoramodificar.getNombre());
							textField_2.setText(autoramodificar.getApellidos());
							textField_3.setText(autoramodificar.getNacionalidad());
							textField_4.setText(autoramodificar.getFnacimiento());
							btnNewButton.setVisible(false);
							btnNewButton_1.setVisible(true);
							btnNewButton_1.setEnabled(true);
							
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
					{
						//El autor no existe. Informar al usuario de que hay error y la id no existe.
					}
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				bd.desconectar();
			}
			}
		});
		btnNewButton.setBounds(255, 79, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(255, 183, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexionBD bd =  new conexionBD();
				bd.conectar();
				Autor am = new Autor(Integer.parseInt(textField.getText()),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
				try {
					bd.eliminarAutor(am);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bd.desconectar();
				
			}
		});
		btnNewButton_3.setBounds(370, 79, 89, 23);
		contentPane.add(btnNewButton_3);
		
		
	}
}

