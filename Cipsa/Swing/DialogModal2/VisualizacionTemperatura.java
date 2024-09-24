package DialogModal2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class VisualizacionTemperatura extends JFrame {

	private JPanel contentPane;
	private JLabel lblTemperatura;
	private int temperaturaActual=20;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizacionTemperatura frame = new VisualizacionTemperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VisualizacionTemperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTemperatura = new JLabel("20\u00BAC");
		lblTemperatura.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 86));
		lblTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperatura.setBounds(15, 16, 404, 197);
		contentPane.add(lblTemperatura);
		
		JButton btnNewButton = new JButton("Ajustar...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instanciar cuadro de dialogo
				 JDialogAjuste dialog = new JDialogAjuste( VisualizacionTemperatura.this, true); 
				 // Asignar temperatura actual
				 dialog.setTemperatura(temperaturaActual); 
				 // Visualizar cuadro de dialogo
				 dialog.setVisible(true); 
				 //---------------------------------------------
				 // Fue cancelado?
				 if (!dialog.esCancelado()) { 
				 // Obtencion de la temperatura seleccionada
				 temperaturaActual = dialog.getTemperartura(); 
				 lblTemperatura.setText(String.valueOf(temperaturaActual) + "ºC"); 
				 } 
				 // Liberado de memoria
				 dialog.dispose();
			}
		});
		btnNewButton.setBounds(320, 216, 99, 29);
		contentPane.add(btnNewButton);
	}
}
