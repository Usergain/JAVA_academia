package net.cipsa.mensajeria.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.cipsa.mensajeria.modelo.Datasource;
import net.cipsa.mensajeria.modelo.Mensajes;
import net.cipsa.mensajeria.modelo.entidades.Mensaje;
import net.cipsa.mensajeria.modelo.entidades.Usuario;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTable;

public class ConexionDialogo extends JDialog {
	
	private JTable tableMensajes;
	private MensajesTableModel tableModel;
	private final JPanel contentPanel = new JPanel();
	private static JTextField txtFieldUsuario;
	private static JPasswordField passwordField;
	private boolean modal;
	
	public static MainFrame ventana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Usuario usuario_login = null; 
	public Usuario getUsuarioLogeado() {
		return this.usuario_login; 
	}
	
	/**
	 * Create the dialog.
	 */
	public ConexionDialogo(MainFrame ventana, boolean modal) {
		super( ventana, modal);
		setTitle("Autentificacion");
		setBounds(100, 100, 372, 241);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtFieldUsuario = new JTextField();
		txtFieldUsuario.setBounds(148, 31, 183, 20);
		contentPanel.add(txtFieldUsuario);
		txtFieldUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(34, 34, 64, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblClave = new JLabel("Clave: ");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClave.setBounds(34, 97, 64, 14);
		contentPanel.add(lblClave);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 96, 187, 20);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						verificarUsuario();
						if ( usuario_login != null ) {	// Usuario autentificado OK
							setVisible(false);
						}
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void verificarUsuario() {
		// TODO Auto-generated method stub
		try {
			String user = txtFieldUsuario.getText();
			String password = passwordField.getText();
			Usuario usuario = new Datasource().getUsuarios().obtener(user);
			if (usuario != null) {
				if (usuario.getClave().equalsIgnoreCase(password)) 	{
					this.usuario_login = usuario;
				} else {
					JOptionPane.showMessageDialog(null, "La contraseña introducida es incorrecta", "Contraseña",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else
				JOptionPane.showMessageDialog(null, "El usuario indicado no existe!", "Contraseña",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);

		}
	}
	
}