package net.cipsa.elecciones.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.cipsa.elecciones.modelo.Datasource;
import net.cipsa.elecciones.modelo.entidades.Candidato;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroCandidatoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean modal;
	public static MainFrame ventana;
	private int votos;
	private String nombre;
	private JTextField nomTextField;
	private Candidato candidato;
	private Candidato [] candidatos;
	private CandidatosListModel listModelCandidato;
	private JList listCandidatos;
	

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
	public RegistroCandidatoDialog(JList listCandidatos, MainFrame ventana, boolean modal) {
		super(ventana, modal);
		this.listCandidatos=listCandidatos;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre :");
		lblNewLabel.setBounds(10, 39, 159, 28);
		contentPanel.add(lblNewLabel);

		nomTextField = new JTextField();
		nomTextField.setBounds(179, 39, 197, 28);
		contentPanel.add(nomTextField);
		nomTextField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registrar();
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

	private void registrar() {

		try {
			nombre = nomTextField.getText();
			votos=0;
			this.candidato = new Candidato(nombre, votos);
			new Datasource().getCandidatos().insertar(candidato);

			candidatos = new Datasource().getCandidatos().listar();
			try {
				Candidato[] candidatos = new Datasource().getCandidatos().listar();
				System.out.println(candidatos.toString());
				if (candidatos.length > 0) {
					listModelCandidato=new CandidatosListModel(candidatos);
					listCandidatos.setModel(listModelCandidato);
					
				} else {
					JOptionPane.showMessageDialog(null, "No hay candidatos registrados", "Sin datos",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			setVisible(false);

		} catch (Exception e) {
			System.out.println("aqui estoy");
			JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
