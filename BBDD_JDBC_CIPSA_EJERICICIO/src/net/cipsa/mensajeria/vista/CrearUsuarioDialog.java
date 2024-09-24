package net.cipsa.mensajeria.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.cipsa.mensajeria.modelo.Datasource;
import net.cipsa.mensajeria.modelo.entidades.Mensaje;
import net.cipsa.mensajeria.modelo.entidades.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class CrearUsuarioDialog extends JDialog {

	private boolean modal;

	private final JPanel contentPanel = new JPanel();
	private JTextField UsuariotextField;
	private JTextField PasstextField;
	private JCheckBox chckbxAdmin;
	private String usuario;
	private String pass;
	private boolean check;
	private JList list;
	private UsuariosListModel listModelUsuario;

	public static AdministradorDialog ventana;

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
	public CrearUsuarioDialog(JList list, AdministradorDialog ventana, boolean modal) {
		super(ventana, modal);
		this.list = list;
		setTitle("Alta Administrador");
		setBounds(100, 100, 436, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		UsuariotextField = new JTextField();
		UsuariotextField.setBounds(117, 27, 260, 28);
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
		contentPanel.add(PasstextField);

		chckbxAdmin = new JCheckBox("");
		chckbxAdmin.setBounds(117, 110, 99, 23);
		contentPanel.add(chckbxAdmin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insertar();
						try {
							Usuario[] usuarios = new Datasource().getUsuarios().listar();
							System.out.println(usuarios.toString());
							if (usuarios.length > 0) {
								listModelUsuario = new UsuariosListModel(usuarios);
								list.setModel(listModelUsuario);
							} else {
								JOptionPane.showMessageDialog(null, "No hay usuarios registrados", "Sin datos",
										JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e1.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						}
						setVisible(false);
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

	private void insertar() {

		try {
			usuario = UsuariotextField.getText();
			pass = PasstextField.getText();
			check = chckbxAdmin.isSelected();

			Usuario usuario1 = new Usuario(check, pass, usuario);

			new Datasource().getUsuarios().insertar(usuario1);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
