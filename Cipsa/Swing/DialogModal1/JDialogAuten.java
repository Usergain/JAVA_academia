package DialogModal1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogAuten extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JLabel lblComentario;
	private JPasswordField passwordField;
	private JButton btnCancelar;
	private boolean cancel = true; 
	private boolean modal;
	
	public static PrincipalFrame ventana;
	
	public boolean isCancelado() {
		return cancel;
	}

	public String getUsuario() {
		return txtUsuario.getText();
	}

	public String getClave() {
		return txtUsuario.getText();
	}

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
	public JDialogAuten(PrincipalFrame ventana, boolean modal) {
		super( ventana, modal); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 393, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Solicitud de Identidad");
		lblNewLabel.setBounds(177, 26, 107, 20);
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

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel = false;
				setVisible(false);
			}
		});
		
		btnOk.setBounds(132, 147, 88, 29);
		contentPane.add(btnOk);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(132, 65, 180, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(132, 103, 180, 20);
		contentPane.add(passwordField);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel = true;
				setVisible(false);
			}
		});
		btnCancelar.setBounds(230, 147, 82, 29);
		contentPane.add(btnCancelar);

	}

}
