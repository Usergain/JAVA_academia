package net.cipsa.elecciones.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.cipsa.elecciones.modelo.Candidatos;
import net.cipsa.elecciones.modelo.Datasource;
import net.cipsa.elecciones.modelo.entidades.Candidato;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarResultadoDialog extends JDialog {
	private boolean modal;
	public static MainFrame ventana;
	private JTable table;
	private Candidato[] candidato;
	private ConsultaTableModel tableModel;

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
	public ConsultarResultadoDialog(MainFrame ventana, boolean modal) {
		super(ventana, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 230, 436, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 416, 208);
			getContentPane().add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
		}
		/*if (dialog.getUsuarioLogeado() != null) {
			// Obtencion del usuario logueado OK
			this.usuario_logeado = dialog.getUsuarioLogeado();
			this.btnNuevoMensaje.setEnabled(true);*/
			try {
				this.candidato = new Datasource().getCandidatos().listar();
				tableModel = new ConsultaTableModel(candidato);
				table.setModel(tableModel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

