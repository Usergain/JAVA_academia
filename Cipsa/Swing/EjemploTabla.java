import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EjemploTabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JSpinner npdSaldo;
	private JTextField txtNombre;
	private JTextField txtDni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploTabla frame = new EjemploTabla();
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
	public EjemploTabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 208, 203);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Obtencion del modelo de la JTable.
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() != -1) {
					// Obtencion de datos de las celdas de la fila
					txtDni.setText((String) modelo.getValueAt(table.getSelectedRow(), 0));
					txtNombre.setText((String) modelo.getValueAt(table.getSelectedRow(), 1));
					npdSaldo.setValue((float) modelo.getValueAt(table.getSelectedRow(), 2));
				} else
					JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada.");
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"DNI", "NOMBRE", "SALDO"
			}
		));
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setResizable(false);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "Nuevo Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.setBounds(226, 16, 208, 203);
		contentPane.add(layeredPane);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(67, 25, 86, 16);
		layeredPane.add(txtDni);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(67, 68, 124, 16);
		layeredPane.add(txtNombre);
		
		npdSaldo = new JSpinner();
		npdSaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		npdSaldo.setBounds(67, 110, 86, 16);
		layeredPane.add(npdSaldo);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnActualizar.setBounds(15, 142, 95, 29);
		layeredPane.add(btnActualizar);
		
		JButton btnAlta = new JButton("ALTA");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizar();	
	
			}
		});
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAlta.setBounds(132, 142, 59, 29);
		layeredPane.add(btnAlta);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(17, 26, 49, 16);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(17, 69, 49, 16);
		layeredPane.add(lblNombre);
		
		JLabel lblSaldo = new JLabel("SALDO");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSaldo.setBounds(15, 109, 49, 16);
		layeredPane.add(lblSaldo);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminar();
	
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEliminar.setBounds(236, 219, 96, 26);
		contentPane.add(btnEliminar);
	}
	
	void eliminar() {
		if (table.getSelectedRowCount() > 0) {
			// Recuperación del modelo
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			// Obtencion índices filas seleccionadas
			int[] filas = table.getSelectedRows();
			for (int fila : filas) {
				// Obtencion campo DNI de fila.
				String dni = (String) modelo.getValueAt(fila, 0);
				// Confirmacion de usuario?
				int respuesta = JOptionPane.showConfirmDialog(null, "Eliminar cliente " + dni + "?", "Confirmacion",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_OPTION)
					modelo.removeRow(fila); // Eliminacion de la fila seleccionada
			}
		} else
			JOptionPane.showMessageDialog(null, "No hay ningun cliente seleccionado.");
	} 
			 
	void actualizar() {
		if (table.getSelectedRow() != -1) {
			table.setValueAt(txtDni.getText(), table.getSelectedRow(), 0);
			table.setValueAt(txtNombre.getText(), table.getSelectedRow(), 1);
			table.setValueAt(npdSaldo.getValue(), table.getSelectedRow(), 2);
		} else
			JOptionPane.showMessageDialog(null, "No hay ningun cliente seleccionado.");
	}
	
	void alta() {
		// Obtención de valores para fila
		String dni = txtDni.getText();
		String nombre = txtNombre.getText();
		float saldo = (float) npdSaldo.getValue();
		// ----- aqui las validaciones oportunas.
		// Recuperación del modelo
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.addRow(new Object[] { dni, nombre, saldo }); // Añadido de fila.
	}


}
