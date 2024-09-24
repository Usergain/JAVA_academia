import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prueba4 extends JFrame {

	private JPanel contentPane;
	private JTextField txtElemento;
	private JComboBox <String>comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba4 frame = new Prueba4();
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
	public Prueba4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Matriz de valores String para componente JComboBox
		comboBox = new JComboBox();
		comboBox.setBounds(15, 16, 184, 28);
		contentPane.add(comboBox); 
		comboBox.setEditable(true); 
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "uno", "dos", "tres", "cuatro", "cinco" }));


		txtElemento = new JTextField();
		txtElemento.setBounds(228, 17, 191, 26);
		contentPane.add(txtElemento);
		txtElemento.setColumns(10);
		
		JButton btnEliminarElemento = new JButton("Eliminar seleccion");
		btnEliminarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					String elementoSeleccionado = (String) comboBox.getSelectedItem();
					comboBox.removeItem(elementoSeleccionado);
				}
			}
		});
		btnEliminarElemento.setBounds(15, 118, 184, 29);
		contentPane.add(btnEliminarElemento);
		
		JButton btnAgregarElemento = new JButton("A\u00F1adir elemento");
		btnAgregarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String elementoAgregar = txtElemento.getText();
				comboBox.addItem(elementoAgregar);
			}
		});
		btnAgregarElemento.setBounds(228, 118, 184, 29);
		contentPane.add(btnAgregarElemento);
	}
}
