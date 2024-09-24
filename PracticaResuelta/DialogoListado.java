import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoListado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tblPartidos;
	private boolean modal;
	
	public void setListado(Partido[] partidos) {
		// Asigna al componente JTable del modelo PartidosTableModel con los
		// partidos registrados
		tblPartidos.setModel(new PartidosTableModel(partidos));
		// Configuracion adicional del ancho de las columnas
		tblPartidos.getColumnModel().getColumn(0).setPreferredWidth(250);
		tblPartidos.getColumnModel().getColumn(1).setPreferredWidth(50);
	}

	public DialogoListado(PracticaResuelta ventana, boolean modal) {
		super(ventana, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible( false );
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 229);
		getContentPane().add(scrollPane);
		
		tblPartidos = new JTable();
		scrollPane.setViewportView(tblPartidos);
	}
}
