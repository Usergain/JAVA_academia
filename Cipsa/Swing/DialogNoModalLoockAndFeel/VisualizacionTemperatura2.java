package DialogNoModalLoockAndFeel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import DialogModal2.JDialogAjuste;
import DialogModal2.VisualizacionTemperatura;

public class VisualizacionTemperatura2 extends JFrame implements JDialogAjuste2.Listener{

	private JPanel contentPane;
	private JLabel lblTemperatura;
	private int temperaturaActual=20;
	private JDialogAjuste2 dialog = null;
	
	public static void main(String[] args) {
			 try { 
			 // Set cross-platform Java L&F (also called "Metal") 
			 UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); 
			 } 
			 catch (UnsupportedLookAndFeelException e) { 
			 // handle exception 
			 } 
			 catch (ClassNotFoundException e) { 
			 // handle exception 
			 } 
			 catch (InstantiationException e) { 
			 // handle exception 
			 } 
			 catch (IllegalAccessException e) { 
			 // handle exception 
			 } 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizacionTemperatura2 frame = new VisualizacionTemperatura2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VisualizacionTemperatura2() {
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
				if(dialog==null) {
					// Instanciar cuadro de dialogo
					 dialog = new JDialogAjuste2( VisualizacionTemperatura2.this, false); 
					 dialog.setListener(VisualizacionTemperatura2.this);
					 // Asignar temperatura actual
					 dialog.setTemperatura(temperaturaActual); 
					 // Visualizar cuadro de dialogo
					 dialog.setVisible(true); 
				}else 
					 JOptionPane.showMessageDialog(VisualizacionTemperatura2.this, "El cuadro de diálogo ya está abierto");
			}	 
		});
		btnNewButton.setBounds(320, 216, 99, 29);
		contentPane.add(btnNewButton);
	}

	@Override
	public void temperaturaCambiada(int nueva_temperatura) {
		// TODO Auto-generated method stub
		// Se asigna la nueva temperatura como temperatura actual
		 temperaturaActual = nueva_temperatura; 
		 lblTemperatura.setText(String.valueOf(temperaturaActual) + "ºC"); 
		 // El dialogo se cerró.
		 dialog = null;
	}

	@Override
	public void cancelado() {
		// TODO Auto-generated method stub
		dialog = null; 
	}
}
