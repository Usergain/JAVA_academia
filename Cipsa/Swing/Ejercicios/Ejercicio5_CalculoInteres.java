package Ejercicios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Pattern;

public class Ejercicio5_CalculoInteres extends JFrame {

	private JPanel contentPane;
	private JTextField textCapitalInvertido;
	private JTextField textCapitalFinal;
	private JComboBox cbxTipoInteres;
	private JSpinner spinner_anios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5_CalculoInteres frame = new Ejercicio5_CalculoInteres();
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
	public Ejercicio5_CalculoInteres() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CALCULO DE INVERSION");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(169, 80, 224, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Capital invertido:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(29, 146, 186, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de interes:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(29, 189, 186, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Capital percibido:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(29, 289, 186, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCalcular.setBounds(142, 334, 289, 35);
		contentPane.add(btnCalcular);
		
		textCapitalInvertido = new JTextField();
		textCapitalInvertido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

				if (!pattern.matcher(textCapitalInvertido.getText()).matches())
					textCapitalInvertido.setBackground(Color.red);
				else
					textCapitalInvertido.setBackground(Color.white);
			}
		});
		textCapitalInvertido.setSelectionEnd(18500);
		textCapitalInvertido.setSelectionStart(765);
		textCapitalInvertido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCapitalInvertido.setBounds(298, 150, 133, 20);
		contentPane.add(textCapitalInvertido);
		textCapitalInvertido.setColumns(10);
		
		cbxTipoInteres = new JComboBox();
		cbxTipoInteres.setModel(new DefaultComboBoxModel(new String[] {"3,4", "3,6", "3,8", "4", "4,2", "4,6"}));
		cbxTipoInteres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxTipoInteres.setBounds(298, 194, 133, 22);
		contentPane.add(cbxTipoInteres);
		
		textCapitalFinal = new JTextField();
		textCapitalFinal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textCapitalFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCapitalFinal.setBounds(298, 295, 134, 20);
		contentPane.add(textCapitalFinal);
		textCapitalFinal.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u20AC");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(441, 153, 14, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u20AC");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(441, 296, 14, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("%");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(441, 198, 14, 14);
		contentPane.add(lblNewLabel_2_2);
		
		spinner_anios = new JSpinner();
		spinner_anios.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinner_anios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_anios.setBounds(298, 244, 133, 20);
		contentPane.add(spinner_anios);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("a\u00F1os.");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(441, 249, 39, 14);
		contentPane.add(lblNewLabel_2_2_1);
	}
	
	private void calcular() {
		
		float CapitalFinal;
		float CapitalInicial=Float.parseFloat(this.textCapitalInvertido.getText());
		String selected_interes =((String) this.cbxTipoInteres.getSelectedItem());
		selected_interes = selected_interes.replace(',', '.');
		float interes = Float.parseFloat(selected_interes);
		int anios = (Integer)this.spinner_anios.getValue();		
		CapitalFinal =(float)(CapitalInicial*(Math.pow(1+(interes/100), anios)));
		
		textCapitalFinal.setText(String.format("%,.2f", CapitalFinal));		
	}
}
