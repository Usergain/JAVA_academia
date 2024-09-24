package net.cipsa.mensajeria.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.cipsa.mensajeria.modelo.Datasource;
import net.cipsa.mensajeria.modelo.entidades.Mensaje;

public class ResponderMensajeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean modal;
	private boolean cancel = true;
	private JTextField textFieldAsunto;
	private JTextField textFieldDestinatario;
	private JTextPane contenido;
	private String asunto;
	private Mensaje mensaje_seleccionado;

	public static MensajeDialog MensajeDialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String usuarioDestino = null;
	private String usuarioOrigen = null;

	/**
	 * Create the dialog.
	 */
	public ResponderMensajeDialog(Mensaje mensaje_seleccionado, MensajeDialog MensajeDialog, boolean modal) {
		super(MensajeDialog, modal);
		this.mensaje_seleccionado = mensaje_seleccionado;
		setBounds(100, 100, 606, 331);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		//usuarioOrigen = MensajeDialog.getUsuarioLogeado().getNombre().toString();
		this.usuarioDestino= this.mensaje_seleccionado.getUsuario_origen();
		this.usuarioOrigen=this.mensaje_seleccionado.getUsuario_destino();
		this.asunto=this.mensaje_seleccionado.getAsunto();
		// System.out.println("probando si ventana es null " + usuarioOrigen);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
			scrollPane
					.setBorder(new TitledBorder(null, "Contenido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane.setBounds(10, 81, 572, 178);
			contentPanel.add(scrollPane);
			{
				contenido = new JTextPane();
				scrollPane.setViewportView(contenido);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Destinatario: ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 18, 83, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Asunto: ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(10, 55, 83, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textFieldAsunto = new JTextField();
			textFieldAsunto.setEditable(false);
			textFieldAsunto.setBounds(137, 54, 237, 20);
			System.out.println(asunto);
			textFieldAsunto.setText(asunto);
			contentPanel.add(textFieldAsunto);
			textFieldAsunto.setColumns(10);
		}
		
		textFieldDestinatario = new JTextField();
		textFieldDestinatario.setEditable(false);
		textFieldDestinatario.setBounds(137, 17, 237, 20);
		System.out.println(textFieldDestinatario);
		textFieldDestinatario.setText(usuarioDestino);
		contentPanel.add(textFieldDestinatario);
		textFieldDestinatario.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Enviar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insertar(usuarioDestino, usuarioOrigen);
						setVisible(false);
						// System.out.println(Destinatario);
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
						cancelar();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void cancelar() {
		// TODO Auto-generated method stub
		setVisible(false);
	}

	private void insertar(String usuarioDestino, String usuarioOrigen) {
		// System.out.println(usuarioDestino);

		try {
			String asunto = textFieldAsunto.getText();
			// El DAO no tiene contenido, hay que meterle mano
			String cont = contenido.getText();
			LocalDate fechaActual = LocalDate.now();
			Date date = Date.valueOf(fechaActual);
			boolean leido = false;
			String usuario_destino = usuarioDestino;
			// ------AQUÍ ESTÁ MAL EN USUARIO_ORIGEN------------
			String usuario_origen = usuarioOrigen;
			// -------------------------------------------------
			Mensaje men = new Mensaje(asunto, cont, date, leido, usuario_destino, usuario_origen);

			new Datasource().getMensajes().insertar(men);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
