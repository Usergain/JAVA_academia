

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Prueba3 extends JFrame {

	private JPanel contentPane;
	//private JTextField txtElemento; 
	private DefaultListModel<String> modelo; 
	private JList<String> list;
	private JTextField txtElemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba3 frame = new Prueba3();
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
	public Prueba3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 214, 229);
		contentPane.add(scrollPane);
		
		modelo = new DefaultListModel();
		JList list = new JList(modelo);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) { 
					 // Muestra los indices de los valores seleccionados
					 System.out.println("INDICES: " + Arrays.toString(list.getSelectedIndices())); 
					 // Muestra los valores seleccionados 
					 System.out.println(list.getSelectedValuesList().toString()); 
				}
			}
		});
		scrollPane.setViewportView(list);
		
		txtElemento = new JTextField();
		txtElemento.setBounds(244, 15, 175, 32);
		contentPane.add(txtElemento);
		txtElemento.setColumns(10);
		
		JButton btnAgregarElemento = new JButton("A\u00F1adir elemento");
		btnAgregarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String elemento = txtElemento.getText();
				modelo.addElement(elemento);
			}
		});
		btnAgregarElemento.setBounds(244, 63, 175, 29);
		contentPane.add(btnAgregarElemento);
		
		JButton btnEliminarElemento = new JButton("Eliminar seleccion");
		btnEliminarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( !list.isSelectionEmpty()) { 
					 String eSeleccionado = (String) list.getSelectedValue(); 
					 modelo.removeElement(eSeleccionado); 
					 };
			}
		});
		btnEliminarElemento.setBounds(244, 216, 175, 29);
		contentPane.add(btnEliminarElemento);
	}

}
