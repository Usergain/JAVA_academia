package Ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Ejercicio7_SeleccionFruta extends JFrame {

	private JPanel contentPane;
	private JLabel lblMostrarSeleccion;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio7_SeleccionFruta frame = new Ejercicio7_SeleccionFruta();
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
	public Ejercicio7_SeleccionFruta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Manzana", "Platano", "Limon", "Naranja", "Cereza", "Melocoton", "Melon",
					"Sandia", "Mandarina", "Kiwi", "Pera", "Paraguay" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(list);
		
		scrollPane.setBounds(15, 16, 404, 229);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(list);

		JButton btnMostrarSeleccion = new JButton("Mostrar Seleccion");
		// Registro de objeto escuchador para evento actionPerformed.
		btnMostrarSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMostrarSeleccion_Click();
			}
		});
		btnMostrarSeleccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrarSeleccion.setBounds(15, 269, 135, 25);
		contentPane.add(btnMostrarSeleccion);

		lblMostrarSeleccion = new JLabel("");
		lblMostrarSeleccion.setBounds(184, 274, 235, 20);
		contentPane.add(lblMostrarSeleccion);
	}
	
	private void btnMostrarSeleccion_Click() {
		String cadena = ""; 
		for( Object valor : this.list.getSelectedValuesList()) {
			if(cadena=="") {
				cadena +=  valor.toString(); 
			}
			else {
				cadena += "," + valor.toString(); 
			}
		}
		this.lblMostrarSeleccion.setText(cadena);		
	}
	
}
