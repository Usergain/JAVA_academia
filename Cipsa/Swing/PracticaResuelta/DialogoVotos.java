package PracticaResuelta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DialogoVotos extends JDialog {
	
	public static final int RESULT_OK = 0;
	public static final int RESULT_CANCEL = 1;
	
	private int resultado;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblPartido;
	private JButton okButton;
	private JButton cancelButton;
	private JFormattedTextField ftxtVotos;
	private boolean modal;

	public int getResultado() {
		return resultado;
	}

	public void setPartido(String partido) {
		lblPartido.setText(partido);
	}

	public long getVotos() {
		return (long) ftxtVotos.getValue();
	}

	/**
	 * Create the dialog.
	 */
	public DialogoVotos(PracticaResuelta ventana, boolean modal) {
		super( ventana, modal); 
		setBounds(100, 100, 447, 175);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Votos Registrados para partidos: ");
		lblNewLabel.setBounds(35, 23, 187, 20);
		contentPanel.add(lblNewLabel);
		
		lblPartido = new JLabel("XXXXXXXXX");
		lblPartido.setBounds(269, 26, 77, 14);
		contentPanel.add(lblPartido);
		
		ftxtVotos = new JFormattedTextField(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0")));
		ftxtVotos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		ftxtVotos.setText("0");
		ftxtVotos.setHorizontalAlignment(SwingConstants.RIGHT);
		ftxtVotos.setBounds(112, 54, 124, 20);
		contentPanel.add(ftxtVotos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						resultado = RESULT_OK;
						setVisible( false );
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						resultado = RESULT_CANCEL;
						setVisible( false );
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
