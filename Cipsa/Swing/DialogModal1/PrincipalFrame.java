package DialogModal1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalFrame frame = new PrincipalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrincipalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIdentificarse = new JButton("Identificarse");
		btnIdentificarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialogAuten autentificador = new JDialogAuten(PrincipalFrame.this,true);
				autentificador.setVisible(true); 
				// Fue cancelado?
				if (!autentificador.isCancelado()) {
					// Recuperacion de valores dados por el usuario
					String usuario = autentificador.getUsuario();
					String clave = autentificador.getClave();
					// Comprobacion de valores
					if (usuario.equals("cipsa") && clave.equals("1234")) {
						JOptionPane.showMessageDialog(PrincipalFrame.this, "BIENVENIDO");
					} else {
						JOptionPane.showMessageDialog(PrincipalFrame.this, "ERROR DE AUTENTIFICACION");
					}
				}
				// Eliminacion final del cuadro de dialogo
				autentificador.dispose();
			}
		});
		btnIdentificarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIdentificarse.setBounds(150, 116, 128, 33);
		contentPane.add(btnIdentificarse);
	}
}
