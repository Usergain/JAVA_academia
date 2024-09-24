package net.cipsa.mensajeria.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import net.cipsa.mensajeria.modelo.Datasource;
import net.cipsa.mensajeria.modelo.entidades.Mensaje;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MensajeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static MainFrame ventana;
	private boolean modal;
	private JLabel lblOrigen;
	private JLabel lblEnviado;
	private JLabel lblAsunto;
	private Mensaje mensaje_seleccionado;
	private JTextArea textArea;

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
	 * @param mensaje_seleccionado 
	 */
	public MensajeDialog(Mensaje mensaje_seleccionado, MainFrame ventana, boolean modal) {
		super(ventana, modal);
		this.mensaje_seleccionado = mensaje_seleccionado;
		setBounds(100, 100, 711, 314);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Origen:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 21, 68, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enviado:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 46, 68, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Asunto:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 71, 68, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblOrigen = new JLabel();
		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrigen.setBounds(88, 21, 154, 14);
		this.lblOrigen.setText(this.mensaje_seleccionado.getUsuario_origen());
		contentPanel.add(lblOrigen);
		
		lblEnviado = new JLabel();
		lblEnviado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnviado.setBounds(88, 46, 154, 14);
		this.lblEnviado.setText(this.mensaje_seleccionado.getUsuario_destino());
		contentPanel.add(lblEnviado);
		
		lblAsunto = new JLabel();
		lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAsunto.setBounds(88, 71, 154, 14);
		this.lblAsunto.setText(this.mensaje_seleccionado.getAsunto());
		contentPanel.add(lblAsunto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Contenido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 96, 677, 146);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	
		//System.out.println(this.mensaje_seleccionado.getContenido());
		this.textArea.setText(this.mensaje_seleccionado.getContenido());
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(mensaje_seleccionado.getId());
						eliminar();
					}
				});
				btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
				buttonPane.add(btnEliminar);
			}
			{
				JButton btnResponder = new JButton("Responder");
				btnResponder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						responder();
					}
				});
				btnResponder.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnResponder.setActionCommand("OK");
				buttonPane.add(btnResponder);
				getRootPane().setDefaultButton(btnResponder);
			}
			{
				JButton btnCerrar = new JButton("Cerrar");
				btnCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
	}
	
	private void responder() {
		// TODO Auto-generated method stub
		// Instanciar cuadro de dialogo
		ResponderMensajeDialog dialog = new ResponderMensajeDialog(mensaje_seleccionado, MensajeDialog.this, true);
		dialog.setVisible(true);
		// Liberado de memoria
		dialog.dispose();
	}
	
	private void eliminar(){
		System.out.println(mensaje_seleccionado.toString());
		 try {
			new Datasource().getMensajes().eliminar(mensaje_seleccionado);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//new Datasource().getUsuarios().(mensaje_seleccionado);
		//setVisible(false);
	}
	
	/*private void eliminarProfesor() {
		int fila = tblProfesores.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun profesor", "Profesor no elegido",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		Profesor seleccionado = tableModel.getProfesor(fila);
		if (JOptionPane.showConfirmDialog(null, "Desea eliminar el profesor " + seleccionado.getNombre(), "Borrar",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			try {
				new Datasource().getProfesores().eliminar(seleccionado);
				JOptionPane.showMessageDialog(null, "Profesor dado de baja", "Operación completa",
						JOptionPane.INFORMATION_MESSAGE);
				mostrarTodos();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	} */
}