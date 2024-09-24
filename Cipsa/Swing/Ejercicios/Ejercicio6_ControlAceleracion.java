package Ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.text.View;
import javax.swing.event.ChangeEvent;
import java.awt.Component;
import java.awt.Point;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class Ejercicio6_ControlAceleracion extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblEntrada;
	private JLabel lblSalida;
	private JSlider slider;
	private JList list;
	private JPanel panel;
	
	
	private float[] coefs = { 2.0f, 2.5f, 3.0f, 4.0f, 5.0f, 5.5f }; 
	private String[] coefs_ids = { "2,0x", "2,5x", "3,0x", "4,0x", "5,0x", "5,5x"}; 
	private JRadioButton rdbtn10;
	private JRadioButton rdbtn5;
	private JRadioButton rdbtn20;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6_ControlAceleracion frame = new Ejercicio6_ControlAceleracion();
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
	public Ejercicio6_ControlAceleracion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				control(e);
				
				
			}
		});
		slider.setFont(new Font("Tahoma", Font.PLAIN, 14));
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setBounds(10, 39, 511, 81);
		contentPane.add(slider);
		
		JLabel lblNewLabel = new JLabel("ACELERADOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(224, 11, 90, 27);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Reductores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(172, 131, 142, 161);
		contentPane.add(panel);
		
		rdbtn5 = new JRadioButton("-5%");
		rdbtn5.setSelected(true);
		rdbtn5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(rdbtn5);
		rdbtn5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rdbtn5);
		
		rdbtn10 = new JRadioButton("-10%");
		rdbtn10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(rdbtn10);
		rdbtn10.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rdbtn10);
		
		rdbtn20 = new JRadioButton("-20%");
		rdbtn20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(rdbtn20);
		rdbtn20.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rdbtn20);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Entrada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(324, 131, 197, 68);
		contentPane.add(panel_2);
		
		lblEntrada = new JLabel("50");
		lblEntrada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblEntrada);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new TitledBorder(null, "Salida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1.setBounds(323, 223, 198, 68);
		contentPane.add(panel_2_1);
		
		lblSalida = new JLabel("50");
		lblSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalida.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblSalida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2_1.add(lblSalida);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Multiplicador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 131, 142, 161);
		contentPane.add(scrollPane);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setModel(new AbstractListModel() {
			public int getSize() {
				return Ejercicio6_ControlAceleracion.this.coefs_ids.length;
			}
			public Object getElementAt(int index) {
				return Ejercicio6_ControlAceleracion.this.coefs_ids[index];
			}
		});
		list.setSelectedIndex(0);
		scrollPane.setViewportView(list);
		
	}
	
	private void control( ChangeEvent e) { 	
		float multiplicador = this.coefs[this.list.getSelectedIndex()];
		float entrada=slider.getValue();
		float salida=0;
		int red = 0; 
		if(rdbtn5.isSelected()) {
			red=5;
		}else if(rdbtn10.isSelected()) {
			red=10;
		}else if(rdbtn20.isSelected()) {
			red=20;
		}
		// visualizacion del valor actualizado
		this.lblEntrada.setText("         " + slider.getValue());
		
		float entrada_potencia = entrada * multiplicador; 
		float entrada_porcentuada = entrada_potencia * ( red / 100.0f );
		salida = entrada_potencia - entrada_porcentuada;
		
		this.lblSalida.setText("         " + salida);
		
		 }
}
