import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Prueba7 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba7 frame = new Prueba7();
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
	public Prueba7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Obtencion del modelo de la JTable.
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				if (table.getSelectedRowCount() > 0) {
					// Obtencion posiciones de filas seleccionadas
					int[] filas = table.getSelectedRows();
					// Recorrido de todas las filas seleccionadas
					for (int fila : filas) {
						// Obtencion de datos de las celdas de la fila
						String dni = (String) modelo.getValueAt(fila, 0); // col. DNI
						String nombre = (String) modelo.getValueAt(fila, 1); // col. Nombre
						float saldo = (Float) modelo.getValueAt(fila, 2); // col. Saldo
						System.out.println("DNI:" + dni + " " + nombre + "Saldo: " + String.valueOf(saldo));
					}
				} else
					JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada.");
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"12345678K", "Roger Petrovich", new Float(1200.45f)}, 
				 {"38928478J", "Victor Tatamovich", new Float(900.4f)}, 
				 {"32489238S", "Ivan Piskunov", new Float(1150.75f)}, 
			},
			new String[] {
				"DNI", "NOMBRE", "SALDO"
			}
		));
		scrollPane.setViewportView(table);
	}
}
