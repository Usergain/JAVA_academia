package net.cipsa.mensajeria.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.cipsa.mensajeria.modelo.Datasource;
import net.cipsa.mensajeria.modelo.entidades.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarUsuarioDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField UsuariotextField;
	private JTextField PasstextField;
	private JCheckBox chckbxAdmin;
	//private String _usuario;
	private Usuario usuario;
	private String nombre;
	private String pass;
	private boolean check;

	public static AdministradorDialog ventana;
	private boolean modal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarUsuarioDialog(Usuario usuario, AdministradorDialog ventana, boolean modal) {
		super(ventana, modal);
		this.usuario = usuario;
		setTitle("Alta Administrador");
		setBounds(100, 100, 436, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		UsuariotextField = new JTextField();
		UsuariotextField.setEditable(false);
		UsuariotextField.setBounds(117, 27, 260, 28);
		this.UsuariotextField.setText(this.usuario.getNombre());
		contentPanel.add(UsuariotextField);
		UsuariotextField.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 27, 161, 28);
		contentPanel.add(lblUsuario);
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(10, 66, 161, 28);
		contentPanel.add(lblClave);

		JLabel lblAdminsitrador = new JLabel("Administrador:");
		lblAdminsitrador.setBounds(10, 105, 88, 28);
		contentPanel.add(lblAdminsitrador);

		PasstextField = new JTextField();
		PasstextField.setColumns(10);
		PasstextField.setBounds(117, 70, 260, 28);
		this.PasstextField.setText(this.usuario.getClave());
		contentPanel.add(PasstextField);

		chckbxAdmin = new JCheckBox("");
		chckbxAdmin.setBounds(117, 110, 99, 23);
		this.chckbxAdmin.setSelected(this.usuario.isAdministrador());
		contentPanel.add(chckbxAdmin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificar();
					}
				});
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void modificar() {
		
		try {
			nombre=UsuariotextField.getText();
			pass= PasstextField.getText();
			check= chckbxAdmin.isSelected();
			
			this.usuario= new Usuario(check, pass, nombre);
			
			new Datasource().getUsuarios().modificar(usuario);
			setVisible(false);
			
		}catch(Exception e) {
			System.out.println("aqui estoy");
			JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
