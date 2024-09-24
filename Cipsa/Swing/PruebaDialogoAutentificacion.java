import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PruebaDialogoAutentificacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnLanzarModal;
	protected Frame MainFrame;
	private JLabel etiqueta1;
	private JLabel etiqueta2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PruebaDialogoAutentificacion dialog = new PruebaDialogoAutentificacion(null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PruebaDialogoAutentificacion(Frame ventana, boolean modal) {
		super(ventana, modal);
		setBounds(100, 100, 289, 213);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnLanzarModal = new JButton("Lanzar MODAL");
			btnLanzarModal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PruebaDialogoAutentificacion dialog = new PruebaDialogoAutentificacion(MainFrame, true);
					dialog.setVisible(true);
					// A partir de aqui, el código se ejecuta al cerrar el cuadro de dialogo
					// ....
					dialog.dispose();
				}
			});
			btnLanzarModal.setBounds(72, 76, 125, 35);
			contentPanel.add(btnLanzarModal);
		}
	}

	class MainFrame extends Frame {

		public MainFrame() {
			setTitle("Ejemplo CampoPassword");
			setVisible(true);
			setBounds(300, 300, 500, 350);
			LaminaPassword lamina = new LaminaPassword();
			add(lamina);
		}

		class LaminaPassword extends JPanel {

			private JPasswordField c_contra;

			public LaminaPassword() {

				setLayout(new BorderLayout());

				JPanel lamina_superior = new JPanel();
				lamina_superior.setLayout(new GridLayout(2, 2));
				add(lamina_superior, BorderLayout.NORTH);

				JLabel etiqueta1 = new JLabel("Usuario");
				JLabel etiqueta2 = new JLabel("Contraseña");

				JTextField c_usuario = new JTextField(15);
				c_contra = new JPasswordField(15);

				Comprueba_pass mievento = new Comprueba_pass();
				c_contra.getDocument().addDocumentListener(mievento);

				lamina_superior.add(etiqueta1);
				lamina_superior.add(c_usuario);
				lamina_superior.add(etiqueta2);
				lamina_superior.add(c_contra);

				JButton enviar = new JButton("Enviar");
				add(enviar, BorderLayout.SOUTH);
			}

			private class Comprueba_pass implements DocumentListener {

				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					char[] contrasena;
					contrasena = c_contra.getPassword();

					if (contrasena.length < 8 || contrasena.length > 12) {
						c_contra.setBackground(Color.red);
					} else {
						c_contra.setBackground(Color.white);
					}
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					char[] contrasena;
					contrasena = c_contra.getPassword();

					if (contrasena.length < 8 || contrasena.length > 12) {
						c_contra.setBackground(Color.red);
					} else {
						c_contra.setBackground(Color.white);
					}
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub

				}

			}
		}

	}

}
