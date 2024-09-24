import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;

public class CovertidorGrados extends JFrame {

	private JPanel contentPane;
	private JTextField jtxtGradosFarenheit;
	private JTextField jtxtGradosCelsius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CovertidorGrados frame = new CovertidorGrados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CovertidorGrados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jtxtGradosFarenheit = new JTextField();
		jtxtGradosFarenheit.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		jtxtGradosFarenheit.setText("0");
		jtxtGradosFarenheit.setBounds(197, 79, 146, 26);
		contentPane.add(jtxtGradosFarenheit);
		jtxtGradosFarenheit.setColumns(10);
		
		jtxtGradosCelsius = new JTextField();
		jtxtGradosCelsius.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		jtxtGradosCelsius.setText("0");
		jtxtGradosCelsius.setBounds(197, 144, 146, 26);
		contentPane.add(jtxtGradosCelsius);
		jtxtGradosCelsius.setColumns(10);
		
		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBounds(64, 82, 69, 20);
		contentPane.add(lblCelsius);
		
		JLabel lblFarenheit = new JLabel("Farenheit");
		lblFarenheit.setBounds(64, 147, 69, 20);
		contentPane.add(lblFarenheit);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recogida y conversión del valor inscrito en caja de texto Celsius.
				double valorCelsius = Double.parseDouble(jtxtGradosFarenheit.getText());
				// Conversión numérica.
				double valorFarenheit = (valorCelsius - 32.0) / 1.8;
				// Inscripcion del resultado en caja texto con formato de dos decimales.
				jtxtGradosCelsius.setText(String.format("%.2f", valorFarenheit));
			}
		});
		btnNewButton.setBounds(197, 216, 146, 29);
		contentPane.add(btnNewButton);
	}
}
