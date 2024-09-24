package DialogModal2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DialogModal1.PrincipalFrame;

import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogAjuste extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean cancel = true;
	private JSlider sliderTemperatura;
	private boolean modal;
	
	public static VisualizacionTemperatura ventana;

	public boolean esCancelado() {
		return cancel;
	}

	public int getTemperartura() {
		return sliderTemperatura.getValue();
	}

	public void setTemperatura(int temperatura) {
		sliderTemperatura.setValue(temperatura);
	}

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
	public JDialogAjuste(VisualizacionTemperatura ventana, boolean modal) {
		super( ventana, modal); 
		setTitle("Seleccion Temperatura");
		setBounds(500, 100, 559, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		sliderTemperatura = new JSlider();
		sliderTemperatura.setValue(20);
		sliderTemperatura.setMaximum(50);
		sliderTemperatura.setMajorTickSpacing(10);
		sliderTemperatura.setMinorTickSpacing(2);
		sliderTemperatura.setPaintLabels(true);
		sliderTemperatura.setPaintTicks(true);
		sliderTemperatura.setBounds(15, 16, 513, 65);
		contentPanel.add(sliderTemperatura);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel = false; 
				setVisible(false);
			}
		});
		btnOk.setBounds(384, 97, 53, 29);
		contentPanel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel = true; 
				setVisible(false);
			}
		});
		btnCancel.setBounds(441, 97, 87, 29);
		contentPanel.add(btnCancel);
	}
}
