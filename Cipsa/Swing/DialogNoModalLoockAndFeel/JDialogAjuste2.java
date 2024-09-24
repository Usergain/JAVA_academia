package DialogNoModalLoockAndFeel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

import DialogModal2.VisualizacionTemperatura;

public class JDialogAjuste2 extends JDialog {
	// Interfaz escuchadora
	interface Listener {
		// Evento de pulsacion de botón OK indicando temperatura seleccionada
		void temperaturaCambiada(int nueva_temperatura);

		// Evento de pulsacion de botón CANCEL
		void cancelado();
	}

	private Listener listener = null;

	public void setListener(Listener _listener) {
		listener = _listener;
	}

	private final JPanel contentPanel = new JPanel();
	private boolean cancel = true;
	private JSlider sliderTemperatura;
	private boolean modal;

	public static VisualizacionTemperatura2 ventana;

	public boolean esCancelado() {
		return cancel;
	}

	public int getTemperartura() {
		return sliderTemperatura.getValue();
	}

	public void setTemperatura(int temperatura) {
		sliderTemperatura.setValue(temperatura);
	}

	public static void main(String[] args) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JDialogAjuste2(VisualizacionTemperatura2 ventana, boolean modal) {
		super(ventana, modal);
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
				// Envío de evento temperaturaCambiada()
				 if ( listener != null ) 
				 listener.temperaturaCambiada(sliderTemperatura.getValue()); 
				 } 
		});
		btnOk.setBounds(384, 97, 53, 29);
		contentPanel.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel = true;
				setVisible(false);
				// Envío de evento cancelado()
				 if ( listener != null ) 
				 listener.cancelado(); 
			}
		});
		btnCancel.setBounds(441, 97, 87, 29);
		contentPanel.add(btnCancel);
	}
}
