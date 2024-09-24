package ExamenSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class JEqualizator extends JFrame {

	private JPanel contentPane;
	private JLabel Band_5Hz;
	private JLabel Band_10Hz;
	private JLabel Band_25Hz;
	private JLabel Band_50Hz;
	private JLabel Band_100Hz;
	private JLabel Band_200Hz;
	private JLabel lblValorEcualizador;
	private JSlider slider5Hz;
	private JSlider slider10Hz;
	private JSlider slider25Hz;
	private JSlider slider50Hz;
	private JSlider slider100Hz;
	private JSlider slider200Hz;
	private JComboBox comboBoxEcualizador;
	private final int BAND_5HZ = 1;
	private final int BAND_10HZ = 2;
	private final int BAND_25HZ = 3;
	private final int BAND_50HZ = 4;
	private final int BAND_100HZ = 5;
	private final int BAND_200HZ = 6;
	private JTextField textFieldEcualizador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JEqualizator frame = new JEqualizator();
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
	public JEqualizator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 676, 405);
		contentPane.add(panel);
		panel.setLayout(null);
		
		slider5Hz = new JSlider();
		slider5Hz.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valor = slider5Hz.getValue(); 
				Band_5Hz.setText(String.valueOf(valor)+"%");
			}
		});
		slider5Hz.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		slider5Hz.setOrientation(SwingConstants.VERTICAL);
		slider5Hz.setBounds(47, 39, 59, 321);
		panel.add(slider5Hz);
		
		slider10Hz = new JSlider();
		slider10Hz.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valor = slider10Hz.getValue(); 
				Band_10Hz.setText(String.valueOf(valor)+"%");
			}
		});
		slider10Hz.setOrientation(SwingConstants.VERTICAL);
		slider10Hz.setBounds(152, 39, 59, 321);
		panel.add(slider10Hz);
		
		slider50Hz = new JSlider();
		slider50Hz.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valor = slider50Hz.getValue(); 
				Band_50Hz.setText(String.valueOf(valor)+"%");
			}
		});
		slider50Hz.setOrientation(SwingConstants.VERTICAL);
		slider50Hz.setBounds(357, 39, 59, 321);
		panel.add(slider50Hz);
		
		slider25Hz = new JSlider();
		slider25Hz.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valor = slider25Hz.getValue(); 
				Band_25Hz.setText(String.valueOf(valor)+"%");
			}
		});
		slider25Hz.setOrientation(SwingConstants.VERTICAL);
		slider25Hz.setBounds(252, 39, 59, 321);
		panel.add(slider25Hz);
		
		slider200Hz = new JSlider();
		slider200Hz.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valor = slider200Hz.getValue(); 
				Band_200Hz.setText(String.valueOf(valor)+"%");
			}
		});
		slider200Hz.setOrientation(SwingConstants.VERTICAL);
		slider200Hz.setBounds(570, 39, 59, 321);
		panel.add(slider200Hz);
		
		slider100Hz = new JSlider();
		slider100Hz.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valor = slider100Hz.getValue(); 
				Band_100Hz.setText(String.valueOf(valor)+"%");
			}
		});
		slider100Hz.setOrientation(SwingConstants.VERTICAL);
		slider100Hz.setBounds(465, 39, 59, 321);
		panel.add(slider100Hz);
		
		JLabel lblNewLabel = new JLabel("5Hz");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(47, 380, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblhz = new JLabel("10Hz");
		lblhz.setHorizontalAlignment(SwingConstants.CENTER);
		lblhz.setBounds(162, 380, 46, 14);
		panel.add(lblhz);
		
		JLabel lblhz_1 = new JLabel("25Hz");
		lblhz_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblhz_1.setBounds(262, 380, 46, 14);
		panel.add(lblhz_1);
		
		JLabel lblhz_2 = new JLabel("50Hz");
		lblhz_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblhz_2.setBounds(367, 380, 46, 14);
		panel.add(lblhz_2);
		
		JLabel lblhz_3 = new JLabel("100Hz");
		lblhz_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblhz_3.setBounds(475, 380, 46, 14);
		panel.add(lblhz_3);
		
		JLabel lblhz_4 = new JLabel("200Hz");
		lblhz_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblhz_4.setBounds(580, 380, 46, 14);
		panel.add(lblhz_4);
		
		Band_5Hz = new JLabel("50%");
		Band_5Hz.setHorizontalAlignment(SwingConstants.CENTER);
		Band_5Hz.setBounds(47, 11, 46, 14);
		panel.add(Band_5Hz);
		
		Band_10Hz = new JLabel("50%");
		Band_10Hz.setHorizontalAlignment(SwingConstants.CENTER);
		Band_10Hz.setBounds(152, 11, 46, 14);
		panel.add(Band_10Hz);
		
		Band_25Hz = new JLabel("50%");
		Band_25Hz.setHorizontalAlignment(SwingConstants.CENTER);
		Band_25Hz.setBounds(252, 11, 46, 14);
		panel.add(Band_25Hz);
		
		Band_50Hz = new JLabel("50%");
		Band_50Hz.setHorizontalAlignment(SwingConstants.CENTER);
		Band_50Hz.setBounds(357, 11, 46, 14);
		panel.add(Band_50Hz);
		
		Band_100Hz = new JLabel("50%");
		Band_100Hz.setHorizontalAlignment(SwingConstants.CENTER);
		Band_100Hz.setBounds(465, 11, 46, 14);
		panel.add(Band_100Hz);
		
		Band_200Hz = new JLabel("50%");
		Band_200Hz.setHorizontalAlignment(SwingConstants.CENTER);
		Band_200Hz.setBounds(570, 11, 46, 14);
		panel.add(Band_200Hz);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 427, 676, 62);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnEcualizador = new JButton("Ecualizador");
		btnEcualizador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 0) {
					lblValorEcualizador.setText(Band_5Hz.getText());
				} else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 1) {
					lblValorEcualizador.setText(Band_10Hz.getText());
				} else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 2) {
					lblValorEcualizador.setText(Band_25Hz.getText());
				} else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 3) {
					lblValorEcualizador.setText(Band_50Hz.getText());
				} else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 4) {
					lblValorEcualizador.setText(Band_100Hz.getText());
				} else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 5) {
					lblValorEcualizador.setText(Band_200Hz.getText());
				}
			}
		});
		btnEcualizador.setBounds(25, 11, 123, 40);
		panel_1.add(btnEcualizador);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 0) {
					setSignal(0,Integer.parseInt(textFieldEcualizador.getText()));	
				} else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 1) {
					setSignal(1,Integer.parseInt(textFieldEcualizador.getText()));	
				} else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 2) {
					setSignal(2,Integer.parseInt(textFieldEcualizador.getText()));	
				} else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 3) {
					setSignal(3,Integer.parseInt(textFieldEcualizador.getText()));	
				} else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 4) {
					setSignal(4,Integer.parseInt(textFieldEcualizador.getText()));	
				} else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 5) {
					setSignal(5,Integer.parseInt(textFieldEcualizador.getText()));	
				}else if (getSignal(comboBoxEcualizador.getSelectedIndex()) == 10){
					InvalidEqualizaroReferenceException();
				}
			}
		});
		btnModificar.setBounds(169, 11, 123, 40);
		panel_1.add(btnModificar);
		
		lblValorEcualizador = new JLabel("");
		lblValorEcualizador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValorEcualizador.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorEcualizador.setBounds(532, 11, 134, 40);
		panel_1.add(lblValorEcualizador);
		
		comboBoxEcualizador = new JComboBox();
		comboBoxEcualizador.setBounds(302, 20, 115, 22);
		panel_1.add(comboBoxEcualizador);
		comboBoxEcualizador.setModel(new DefaultComboBoxModel(new String[] {"BAND_5HZ", "BAND_10HZ", "BAND_25HZ", 
				"BAND_50HZ", "BAND_100HZ", "BAND_200HZ"}));
		
		textFieldEcualizador = new JTextField();
		textFieldEcualizador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textFieldEcualizador.setBounds(427, 21, 86, 20);
		panel_1.add(textFieldEcualizador);
		textFieldEcualizador.setColumns(10);
		comboBoxEcualizador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBoxEcualizador.getSelectedItem());
				comboBoxEcualizador.getSelectedIndex();
			}
		});

	}
	
//-------------------------------------------------------------------------------------------------
	
	int getSignal(int refEqualizator) {

		if ((refEqualizator + 1) == BAND_5HZ) {
			return 0;
		} else if ((refEqualizator + 1) == BAND_10HZ) {
			return 1;
		} else if ((refEqualizator + 1) == BAND_25HZ) {
			return 2;
		} else if ((refEqualizator + 1) == BAND_50HZ) {
			return 3;
		} else if ((refEqualizator + 1) == BAND_100HZ) {
			return 4;
		} else if ((refEqualizator + 1) == BAND_200HZ) {
			return 5;
		}
		return 10;
	}
	
	void setSignal(int refEqualizator, int value) {
		if (value >= 0 && value <= 100) {
			if ((refEqualizator + 1) == BAND_5HZ) {
				slider5Hz.setValue(value);
				Band_5Hz.setText(textFieldEcualizador.getText() + "%");
			} else if ((refEqualizator + 1) == BAND_10HZ) {
				slider10Hz.setValue(value);
				Band_10Hz.setText(String.valueOf(slider10Hz.getValue()) + "%");
				slider5Hz.setValue(value);
			} else if ((refEqualizator + 1) == BAND_25HZ) {
				slider25Hz.setValue(value);
				Band_25Hz.setText(String.valueOf(slider25Hz.getValue()) + "%");
			} else if ((refEqualizator + 1) == BAND_50HZ) {
				slider50Hz.setValue(value);
				Band_50Hz.setText(String.valueOf(slider50Hz.getValue()) + "%");
			} else if ((refEqualizator + 1) == BAND_100HZ) {
				slider100Hz.setValue(value);
				Band_100Hz.setText(String.valueOf(slider100Hz.getValue()) + "%");
			} else if ((refEqualizator + 1) == BAND_200HZ) {
				slider200Hz.setValue(value);
				Band_200Hz.setText(String.valueOf(slider200Hz.getValue()) + "%");
			} else {
				InvalidEqualizaroReferenceException();
			}
		}
	}

	void InvalidEqualizaroReferenceException() {
		// TODO Auto-generated method stub
		 JOptionPane.showMessageDialog(JEqualizator.this, "La opción no es correcta.");
	}
}
