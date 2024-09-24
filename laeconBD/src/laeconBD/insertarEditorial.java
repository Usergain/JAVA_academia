package laeconBD;

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

public class insertarEditorial extends JFrame {

	private JPanel contentPane;
	private JTextField idEditorialTf;
	private JTextField textField_1;
	private JTextField nacionalidadEditorialTf;
	private JTextField nombreEditorialTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertarEditorial frame = new insertarEditorial();
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
	public insertarEditorial() {
		setTitle("Insertar Editorial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id_Editorial:");
		lblNewLabel.setBounds(20, 41, 83, 14);
		contentPane.add(lblNewLabel);
		
		idEditorialTf = new JTextField();
		idEditorialTf.setBounds(122, 38, 327, 20);
		contentPane.add(idEditorialTf);
		idEditorialTf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre editorial:");
		lblNewLabel_1.setBounds(20, 115, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 112, -1367, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nacionalidad:");
		lblNewLabel_2.setBounds(22, 215, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		nacionalidadEditorialTf = new JTextField();
		nacionalidadEditorialTf.setToolTipText("");
		nacionalidadEditorialTf.setBounds(130, 212, 319, 20);
		contentPane.add(nacionalidadEditorialTf);
		nacionalidadEditorialTf.setColumns(10);
		
		nombreEditorialTf = new JTextField();
		nombreEditorialTf.setBounds(134, 112, 315, 20);
		contentPane.add(nombreEditorialTf);
		nombreEditorialTf.setColumns(10);
		
		JButton insertarEditorialBtn = new JButton("Insertar");
		insertarEditorialBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id_editorial = Integer.parseInt(idEditorialTf.getText());
				String nombre_editorial = nombreEditorialTf.getText();
				String nacionalidad_editorial = nacionalidadEditorialTf.getText();
				
				Editorial editorial = new Editorial(id_editorial, nombre_editorial, nacionalidad_editorial);
				
				conexionBD conexion = new conexionBD();
				conexion.conectar();
				
				try {
					conexion.insertarEditorial(editorial);
					limpiarCampos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				conexion.desconectar();
				
			}
		});
		insertarEditorialBtn.setBounds(155, 375, 89, 23);
		contentPane.add(insertarEditorialBtn);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); /// cierra la ventana prioritaria
			}
		});
		btnNewButton.setBounds(365, 375, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public void limpiarCampos() {
		idEditorialTf.setText("");
		nombreEditorialTf.setText("");
		nacionalidadEditorialTf.setText("");
	}
}
