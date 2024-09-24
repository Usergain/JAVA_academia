package net.cipsa.academia.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.cipsa.academia.modelo.Datasource;
import net.cipsa.academia.modelo.Profesores;
import net.cipsa.academia.modelo.entidades.Profesor;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdb_filtro_DNI;
	private JRadioButton rdb_filtro_nombre;
	private JRadioButton rdb_filtro_apellidos;
	private JTextField txtFiltro;
	private ProfesoresTableModel tableModel;
	private JTable tblProfesores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarProfesores();
			}
		});
		btnFiltrar.setBounds(278, 147, 81, 23);
		contentPane.add(btnFiltrar);

		JButton btnTodos = new JButton("Todos");
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarTodos();
			}
		});
		btnTodos.setBounds(369, 147, 81, 23);
		contentPane.add(btnTodos);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoProfesor();
			}
		});
		btnNuevo.setBounds(501, 147, 81, 23);
		contentPane.add(btnNuevo);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarProfesor();
			}
		});
		btnModificar.setBounds(589, 147, 81, 23);
		contentPane.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarProfesor();
			}
		});
		btnEliminar.setBounds(675, 147, 81, 23);
		contentPane.add(btnEliminar);

		txtFiltro = new JTextField();
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(10, 148, 260, 20);
		contentPane.add(txtFiltro);

		rdb_filtro_DNI = new JRadioButton("DNI");
		buttonGroup.add(rdb_filtro_DNI);
		rdb_filtro_DNI.setBounds(6, 21, 109, 23);
		contentPane.add(rdb_filtro_DNI);

		rdb_filtro_nombre = new JRadioButton("Nombre");
		buttonGroup.add(rdb_filtro_nombre);
		rdb_filtro_nombre.setBounds(6, 60, 109, 23);
		contentPane.add(rdb_filtro_nombre);

		rdb_filtro_apellidos = new JRadioButton("Apellidos");
		buttonGroup.add(rdb_filtro_apellidos);
		rdb_filtro_apellidos.setBounds(6, 100, 109, 23);
		contentPane.add(rdb_filtro_apellidos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 6, 633, 130);
		contentPane.add(scrollPane);

		tblProfesores = new JTable();
		scrollPane.setViewportView(tblProfesores);
	}

	private void mostrarTodos() {
		this.rdb_filtro_DNI.setSelected(false);
		this.rdb_filtro_nombre.setSelected(false);
		this.rdb_filtro_apellidos.setSelected(false);
		try {
			Profesor[] datos = new Datasource().getProfesores().listar();
			if (datos.length > 0) {
				tableModel = new ProfesoresTableModel(datos);
				tblProfesores.setModel(tableModel);
			} else
				JOptionPane.showMessageDialog(null, "No hay profesores registrados", "Sin datos",
						JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void filtrarProfesores() {

		String valor_filtro;
		int tipo_filtro = -1;
		if (this.txtFiltro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se ha indicado ningún valor de filtrado",
					"Valor de fitro no valido.", JOptionPane.ERROR_MESSAGE);
			return;
		}
		valor_filtro = this.txtFiltro.getText();

		if (rdb_filtro_DNI.isSelected()) {
			tipo_filtro = Profesores.FILTRAR_DNI;
		} else if (rdb_filtro_nombre.isSelected()) {
			tipo_filtro = Profesores.FILTRAR_NOMBRE;
		} else if (rdb_filtro_apellidos.isSelected()) {
			tipo_filtro = Profesores.FILTRAR_APELLIDO;
		} else {
			JOptionPane.showMessageDialog(null, "No se ha indicado ningún criterio de filtrado",
					"Criterio de fitrado no elegido.", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			Profesor[] profesores = new Datasource().getProfesores().filtrar(tipo_filtro, valor_filtro);
			if (profesores.length > 0) {
				tableModel = new ProfesoresTableModel(profesores);
				tblProfesores.setModel(tableModel);
			} else
				JOptionPane.showMessageDialog(null, "No se ha encontrado ningún profesor", "Sin datos",
						JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void nuevoProfesor() {
		ProfesorEdicionDialog dialog = new ProfesorEdicionDialog(MainFrame.this, true);
		dialog.setVisible(true);
		Profesor nuevo = dialog.getProfesor();
		if (nuevo != null) {
			try {
				new Datasource().getProfesores().insertar(nuevo);

				JOptionPane.showMessageDialog(null, "Profesor dado de alta", "Operación completa",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		dialog.dispose();
	}

	private void editarProfesor() {
		int fila = tblProfesores.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun profesor", "Profesor no elegido",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		ProfesorEdicionDialog dialog = new ProfesorEdicionDialog(MainFrame.this, true);
		dialog.setProfesor(tableModel.getProfesor(fila));
		dialog.setVisible(true);
		Profesor modificado = dialog.getProfesor();
		if (modificado != null) {
			try {
				new Datasource().getProfesores().actualizar(modificado);
				JOptionPane.showMessageDialog(null, "Profesor actualizado", "Operación completa",
						JOptionPane.INFORMATION_MESSAGE);
				mostrarTodos();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		dialog.dispose();
	}

	private void eliminarProfesor() {
		int fila = tblProfesores.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun profesor", "Profesor no elegido",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		Profesor seleccionado = tableModel.getProfesor(fila);
		if (JOptionPane.showConfirmDialog(null, "Desea eliminar el profesor " + seleccionado.getNombre(), "Borrar",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			try {
				new Datasource().getProfesores().eliminar(seleccionado);
				JOptionPane.showMessageDialog(null, "Profesor dado de baja", "Operación completa",
						JOptionPane.INFORMATION_MESSAGE);
				mostrarTodos();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error de base de datos.\n" + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
