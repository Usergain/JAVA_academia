package Ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2_ControlRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JLabel lblComentario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2_ControlRegistro frame = new Ejercicio2_ControlRegistro();
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
	public Ejercicio2_ControlRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Solicitud de Identidad");
		lblNewLabel.setBounds(132, 26, 163, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(61, 65, 69, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Clave:");
		lblContraseña.setBounds(61, 103, 69, 20);
		contentPane.add(lblContraseña);
		
		lblComentario = new JLabel("");
		lblComentario.setBounds(127, 187, 240, 20);
		contentPane.add(lblComentario);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Usuario="admin";
				String Contrasenia="123";
				
				String Pass= new String( passwordField.getPassword() );
				
				if(txtUsuario.getText().equals(Usuario)&& Pass.equals(Contrasenia)) {
					lblComentario.setText("BIENVENIDO");
				}
				
				else if(txtUsuario.getText().equals(Usuario)&& !Pass.equals(Contrasenia)) {
					lblComentario.setText("CONTRASEÑA INCORRECTA");
				}
				
				else if(!txtUsuario.getText().equals(Usuario)) {
					lblComentario.setText("USUARIO NO RECONOCIDO");
				}
			}
		});
		btnValidar.setBounds(157, 142, 115, 29);
		contentPane.add(btnValidar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(157, 65, 163, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 103, 163, 20);
		contentPane.add(passwordField);
	}
}
