package laeconBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class insertarLibro extends JFrame {

	private JPanel contentPane;
	private JTextField tituloLibroTf;
	private JTextField paginasLibroTf;
	private JTextField idLibroTf;
	private JComboBox autoresLibroJC;
	private JComboBox editorialesLibroJC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertarLibro frame = new insertarLibro();
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
	public insertarLibro() {

		conexionBD conexion = new conexionBD();

		setTitle("Insertar Libro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00EDtulo");
		lblNewLabel.setBounds(71, 64, 72, 21);
		contentPane.add(lblNewLabel);

		tituloLibroTf = new JTextField();
		tituloLibroTf.setBounds(10, 81, 170, 21);
		contentPane.add(tituloLibroTf);
		tituloLibroTf.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("P\u00E1ginas");
		lblNewLabel_1.setBounds(306, 67, 46, 14);
		contentPane.add(lblNewLabel_1);

		paginasLibroTf = new JTextField();
		paginasLibroTf.setBounds(254, 81, 170, 21);
		contentPane.add(paginasLibroTf);
		paginasLibroTf.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Autores");
		lblNewLabel_2.setBounds(71, 113, 46, 14);
		contentPane.add(lblNewLabel_2);

		autoresLibroJC = new JComboBox();
		autoresLibroJC.setBounds(10, 138, 170, 21);
		contentPane.add(autoresLibroJC);

		conexion.conectar();

		try {
			ArrayList<Autor> autores = conexion.listarAutores();

			for (int i = 0; i < autores.size(); i++) {
				autoresLibroJC.addItem(new Autor(autores.get(i).getIdautor(), autores.get(i).getNombre(),
						autores.get(i).getApellidos(), autores.get(i).getNacionalidad(),
						autores.get(i).getFnacimiento()));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblNewLabel_3 = new JLabel("Editorial");
		lblNewLabel_3.setBounds(306, 113, 46, 14);
		contentPane.add(lblNewLabel_3);

		editorialesLibroJC = new JComboBox();
		editorialesLibroJC.setBounds(254, 138, 170, 21);
		contentPane.add(editorialesLibroJC);

		try {
			ArrayList<Editorial> editoriales = conexion.listarEditoriales();

			for (int i = 0; i < editoriales.size(); i++) {
				editorialesLibroJC.addItem(new Editorial(editoriales.get(i).getId(), editoriales.get(i).getNombre(),
						editoriales.get(i).getNacionalidad()));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JButton insertarLibroBtn = new JButton("Insertar");
		insertarLibroBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int idLibro = Integer.parseInt(idLibroTf.getText());
				String nombreLibro = tituloLibroTf.getText();
				int paginas = Integer.parseInt(paginasLibroTf.getText());

				Autor autor = (Autor) autoresLibroJC.getSelectedItem();
				Editorial editorial = (Editorial) editorialesLibroJC.getSelectedItem();

				Libro libro = new Libro(idLibro, nombreLibro, paginas, autor, editorial);

				conexion.conectar();

				try {
					conexion.insertarLibro(libro);
					limpiarCampos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				conexion.desconectar();

			}
		});
		insertarLibroBtn.setBounds(91, 203, 89, 23);
		contentPane.add(insertarLibroBtn);

		JButton cerrarLibroBtn = new JButton("Cerrar");
		cerrarLibroBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cerrarLibroBtn.setBounds(254, 203, 89, 23);
		contentPane.add(cerrarLibroBtn);

		JLabel lblNewLabel_4 = new JLabel("Id Libro");
		lblNewLabel_4.setBounds(32, 22, 46, 14);
		contentPane.add(lblNewLabel_4);

		idLibroTf = new JTextField();
		idLibroTf.setBounds(91, 19, 333, 21);
		contentPane.add(idLibroTf);
		idLibroTf.setColumns(10);

	}

	public void limpiarCampos() {
		idLibroTf.setText("");
		tituloLibroTf.setText("");
		paginasLibroTf.setText("");
		autoresLibroJC.setSelectedIndex(0);
		editorialesLibroJC.setSelectedIndex(0);
	}
}
